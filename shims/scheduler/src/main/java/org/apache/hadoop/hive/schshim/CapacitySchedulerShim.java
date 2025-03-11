/*
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
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.schshim;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.shims.SchedulerShim;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CapacitySchedulerShim implements SchedulerShim {
    private static final Logger LOG = LoggerFactory.getLogger(CapacitySchedulerShim.class);
    private static final String MR2_JOB_QUEUE_PROPERTY = "mapreduce.job.queuename";

    @Override
    public void refreshDefaultQueue(Configuration conf, String userName) throws IOException {
        String requestedQueue = conf.get(MR2_JOB_QUEUE_PROPERTY, YarnConfiguration.DEFAULT_QUEUE_NAME);
        LOG.info("Using Capacity Scheduler: Setting queue name to {} for user {}", requestedQueue, userName);
        conf.set(MR2_JOB_QUEUE_PROPERTY, requestedQueue);
    }
}
