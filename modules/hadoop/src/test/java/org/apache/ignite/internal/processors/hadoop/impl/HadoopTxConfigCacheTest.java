/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.hadoop.impl;

import org.apache.ignite.Ignite;
import org.apache.ignite.internal.processors.cache.IgniteInternalCache;
import org.apache.ignite.internal.processors.cache.IgniteTxConfigCacheSelfTest;
import org.apache.ignite.internal.util.typedef.internal.CU;

/**
 * Test checks whether hadoop system cache doesn't use user defined TX config.
 */
public class HadoopTxConfigCacheTest extends IgniteTxConfigCacheSelfTest {
    /**
     * Success if system caches weren't timed out.
     *
     * @throws Exception If failed.
     */
    public void testSystemCacheTx() throws Exception {
        final Ignite ignite = grid(0);

        final IgniteInternalCache<Object, Object> hadoopCache = getSystemCache(ignite, CU.SYS_CACHE_HADOOP_MR);

        checkImplicitTxSuccess(hadoopCache);
        checkStartTxSuccess(hadoopCache);
    }
}