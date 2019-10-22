/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3InAdapters.adaptIn;

import org.ovirt.engine.api.model.OpenStackImage;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3OpenStackImage;

public class V3OpenStackImageInAdapter implements V3Adapter<V3OpenStackImage, OpenStackImage> {
    @Override
    public OpenStackImage adapt(V3OpenStackImage from) {
        OpenStackImage to = new OpenStackImage();
        if (from.isSetLinks()) {
            to.getLinks().addAll(adaptIn(from.getLinks()));
        }
        if (from.isSetActions()) {
            to.setActions(adaptIn(from.getActions()));
        }
        if (from.isSetComment()) {
            to.setComment(from.getComment());
        }
        if (from.isSetDescription()) {
            to.setDescription(from.getDescription());
        }
        if (from.isSetId()) {
            to.setId(from.getId());
        }
        if (from.isSetHref()) {
            to.setHref(from.getHref());
        }
        if (from.isSetName()) {
            to.setName(from.getName());
        }
        if (from.isSetOpenstackImageProvider()) {
            to.setOpenstackImageProvider(adaptIn(from.getOpenstackImageProvider()));
        }
        return to;
    }
}
