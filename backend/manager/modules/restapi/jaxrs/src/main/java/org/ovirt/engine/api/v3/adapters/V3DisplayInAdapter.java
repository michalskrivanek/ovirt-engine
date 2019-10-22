/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3InAdapters.adaptIn;

import org.ovirt.engine.api.model.Display;
import org.ovirt.engine.api.model.DisplayType;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3Display;

public class V3DisplayInAdapter implements V3Adapter<V3Display, Display> {
    @Override
    public Display adapt(V3Display from) {
        Display to = new Display();
        if (from.isSetAddress()) {
            to.setAddress(from.getAddress());
        }
        if (from.isSetAllowOverride()) {
            to.setAllowOverride(from.isAllowOverride());
        }
        if (from.isSetCertificate()) {
            to.setCertificate(adaptIn(from.getCertificate()));
        }
        if (from.isSetCopyPasteEnabled()) {
            to.setCopyPasteEnabled(from.isCopyPasteEnabled());
        }
        if (from.isSetDisconnectAction()) {
            to.setDisconnectAction(from.getDisconnectAction());
        }
        if (from.isSetFileTransferEnabled()) {
            to.setFileTransferEnabled(from.isFileTransferEnabled());
        }
        if (from.isSetKeyboardLayout()) {
            to.setKeyboardLayout(from.getKeyboardLayout());
        }
        if (from.isSetMonitors()) {
            to.setMonitors(from.getMonitors());
        }
        if (from.isSetPort()) {
            to.setPort(from.getPort());
        }
        if (from.isSetProxy()) {
            to.setProxy(from.getProxy());
        }
        if (from.isSetSecurePort()) {
            to.setSecurePort(from.getSecurePort());
        }
        if (from.isSetSingleQxlPci()) {
            to.setSingleQxlPci(from.isSingleQxlPci());
        }
        if (from.isSetSmartcardEnabled()) {
            to.setSmartcardEnabled(from.isSmartcardEnabled());
        }
        if (from.isSetType()) {
            to.setType(DisplayType.fromValue(from.getType()));
        }
        return to;
    }
}
