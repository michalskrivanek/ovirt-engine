/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3InAdapters.adaptIn;

import org.ovirt.engine.api.model.AffinityGroups;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3AffinityGroups;

public class V3AffinityGroupsInAdapter implements V3Adapter<V3AffinityGroups, AffinityGroups> {
    @Override
    public AffinityGroups adapt(V3AffinityGroups from) {
        AffinityGroups to = new AffinityGroups();
        if (from.isSetActions()) {
            to.setActions(adaptIn(from.getActions()));
        }
        if (from.isSetActive()) {
            to.setActive(from.getActive());
        }
        if (from.isSetSize()) {
            to.setSize(from.getSize());
        }
        if (from.isSetTotal()) {
            to.setTotal(from.getTotal());
        }
        to.getAffinityGroups().addAll(adaptIn(from.getAffinityGroups()));
        return to;
    }
}
