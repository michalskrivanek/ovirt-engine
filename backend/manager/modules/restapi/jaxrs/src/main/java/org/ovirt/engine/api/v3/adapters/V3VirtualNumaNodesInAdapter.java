/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3InAdapters.adaptIn;

import org.ovirt.engine.api.model.VirtualNumaNodes;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3VirtualNumaNodes;

public class V3VirtualNumaNodesInAdapter implements V3Adapter<V3VirtualNumaNodes, VirtualNumaNodes> {
    @Override
    public VirtualNumaNodes adapt(V3VirtualNumaNodes from) {
        VirtualNumaNodes to = new VirtualNumaNodes();
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
        to.getVirtualNumaNodes().addAll(adaptIn(from.getVirtualNumaNodes()));
        return to;
    }
}
