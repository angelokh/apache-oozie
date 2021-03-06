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
package org.apache.oozie.command.wf;

import org.apache.oozie.WorkflowActionBean;
import org.apache.oozie.store.StoreException;
import org.apache.oozie.store.WorkflowStore;
import org.apache.oozie.util.ParamChecker;
import org.apache.oozie.util.XLog;

public class WorkflowActionInfoCommand extends WorkflowCommand<WorkflowActionBean> {
    private String id;

    public WorkflowActionInfoCommand(String id) {
        super("action.info", "action.info", 1, XLog.OPS, true);
        this.id = ParamChecker.notEmpty(id, "id");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected WorkflowActionBean call(WorkflowStore store) throws StoreException {
        WorkflowActionBean action = store.getAction(id, false);
        return action;
    }
}
