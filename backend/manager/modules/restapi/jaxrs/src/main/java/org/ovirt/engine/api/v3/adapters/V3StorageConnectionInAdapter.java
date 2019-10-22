/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3InAdapters.adaptIn;

import org.ovirt.engine.api.model.NfsVersion;
import org.ovirt.engine.api.model.StorageConnection;
import org.ovirt.engine.api.model.StorageType;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3StorageConnection;

public class V3StorageConnectionInAdapter implements V3Adapter<V3StorageConnection, StorageConnection> {
    @Override
    public StorageConnection adapt(V3StorageConnection from) {
        StorageConnection to = new StorageConnection();
        if (from.isSetLinks()) {
            to.getLinks().addAll(adaptIn(from.getLinks()));
        }
        if (from.isSetActions()) {
            to.setActions(adaptIn(from.getActions()));
        }
        if (from.isSetAddress()) {
            to.setAddress(from.getAddress());
        }
        if (from.isSetComment()) {
            to.setComment(from.getComment());
        }
        if (from.isSetDescription()) {
            to.setDescription(from.getDescription());
        }
        if (from.isSetHost()) {
            to.setHost(adaptIn(from.getHost()));
        }
        if (from.isSetId()) {
            to.setId(from.getId());
        }
        if (from.isSetHref()) {
            to.setHref(from.getHref());
        }
        if (from.isSetMountOptions()) {
            to.setMountOptions(from.getMountOptions());
        }
        if (from.isSetName()) {
            to.setName(from.getName());
        }
        if (from.isSetNfsRetrans()) {
            to.setNfsRetrans(from.getNfsRetrans());
        }
        if (from.isSetNfsTimeo()) {
            to.setNfsTimeo(from.getNfsTimeo());
        }
        if (from.isSetNfsVersion()) {
            to.setNfsVersion(NfsVersion.fromValue(from.getNfsVersion()));
        }
        if (from.isSetPassword()) {
            to.setPassword(from.getPassword());
        }
        if (from.isSetPath()) {
            to.setPath(from.getPath());
        }
        if (from.isSetPort()) {
            to.setPort(from.getPort());
        }
        if (from.isSetPortal()) {
            to.setPortal(from.getPortal());
        }
        if (from.isSetTarget()) {
            to.setTarget(from.getTarget());
        }
        if (from.isSetType()) {
            to.setType(StorageType.fromValue(from.getType()));
        }
        if (from.isSetUsername()) {
            to.setUsername(from.getUsername());
        }
        if (from.isSetVfsType()) {
            to.setVfsType(from.getVfsType());
        }
        return to;
    }
}
