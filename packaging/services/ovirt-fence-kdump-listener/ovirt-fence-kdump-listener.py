#!/usr/bin/python

#
# Copyright oVirt Authors
# SPDX-License-Identifier: Apache-2.0
#

import gettext
import os
import sys

import config
import db
import listener


from ovirt_engine import configfile
from ovirt_engine import service


def _(m):
    return gettext.dgettext(message=m, domain="ovirt-fence-kdump-listener")


class Daemon(service.Daemon):

    def __init__(self):
        super(Daemon, self).__init__()
        self._defaults = os.path.abspath(
            os.path.join(
                os.path.dirname(sys.argv[0]),
                'ovirt-fence-kdump-listener.conf',
            )
        )
        self._engineDefaults = os.path.abspath(
            os.path.join(
                os.path.dirname(sys.argv[0]),
                'ovirt-engine.conf',
            )
        )

    def _checkInstallation(
        self,
        pidfile,
    ):
        if pidfile is not None:
            self.check(
                name=pidfile,
                writable=True,
                mustExist=False,
            )

    def daemonSetup(self):

        if not os.path.exists(self._defaults):
            raise RuntimeError(
                _(
                    "The configuration defaults file '{file}' "
                    "required but missing"
                ).format(
                    file=self._defaults,
                )
            )

        self._config = configfile.ConfigFile(
            (
                self._defaults,
                config.ENGINE_FKLSNR_VARS,
            ),
        )

        self._engineConfig = configfile.ConfigFile(
            (
                self._engineDefaults,
                config.ENGINE_VARS,
            ),
        )

        self._checkInstallation(
            pidfile=self.pidfile,
        )

    def daemonContext(self):
        with db.DbManager(
                host=self._engineConfig.get('ENGINE_DB_HOST'),
                port=self._engineConfig.get('ENGINE_DB_PORT'),
                database=self._engineConfig.get('ENGINE_DB_DATABASE'),
                username=self._engineConfig.get('ENGINE_DB_USER'),
                password=self._engineConfig.get('ENGINE_DB_PASSWORD'),
                secured=self._engineConfig.getboolean('ENGINE_DB_SECURED'),
                secure_validation=self._engineConfig.getboolean(
                    'ENGINE_DB_SECURED_VALIDATION'
                ),
        ) as db_manager:

            with listener.FenceKdumpListener(
                    bind=(
                        self._config.get('LISTENER_ADDRESS'),
                        self._config.getinteger('LISTENER_PORT')
                    ),
                    db_manager=db_manager,
                    heartbeat_interval=(
                        self._config.getinteger('HEARTBEAT_INTERVAL')
                    ),
                    session_sync_interval=(
                        self._config.getinteger('SESSION_SYNC_INTERVAL')
                    ),
                    reopen_db_connection_interval=(
                        self._config.getinteger(
                            'REOPEN_DB_CONNECTION_INTERVAL'
                        )
                    ),
                    session_expiration_time=(
                        self._config.getinteger('KDUMP_FINISHED_TIMEOUT')
                    ),
            ) as server:
                server.run()


if __name__ == "__main__":
    service.setupLogger()
    d = Daemon()
    d.run()


# vim: expandtab tabstop=4 shiftwidth=4
