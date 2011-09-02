/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.oozie.servlet;

import javax.servlet.http.HttpServletResponse;

import org.apache.oozie.ErrorCode;

public class ServletUtilities {

    // accessory static method to check the app path parameter for the request
    // used only for job-related request and only one of them should exist
    protected static void ValidateAppPath(String wfPath, String coordPath) throws XServletException {
        if (wfPath != null && coordPath != null) {
            throw new XServletException(HttpServletResponse.SC_BAD_REQUEST, ErrorCode.E0301, wfPath, coordPath);
        }
        else {
            if (wfPath == null && coordPath == null) {
                throw new XServletException(HttpServletResponse.SC_BAD_REQUEST, ErrorCode.E0302);
            }
        }
    }

}
