/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.oozie.command.coord;

import org.apache.oozie.store.CoordinatorStore;
import org.apache.oozie.store.StoreException;
import org.apache.oozie.util.XLog;
import org.apache.oozie.command.CommandException;

public class CoordPurgeCommand extends CoordinatorCommand<Void> {
    private static XLog LOG = XLog.getLog(CoordPurgeCommand.class);
    private int olderThan;
    private int limit;

    public CoordPurgeCommand(int olderThan, int limit) {
        super("coord_purge", "coord_purge", 0, XLog.OPS);
        this.olderThan = olderThan;
        this.limit = limit;
    }

    protected Void call(CoordinatorStore store) throws StoreException, CommandException {
        LOG.debug("STARTED Coord Purge to purge Jobs older than [{0}] days.", olderThan);
        store.purge(olderThan, limit);
        LOG.debug("Coord-Purge succeeded");
        return null;
    }

}
