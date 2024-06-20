/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.test.it.sql.parser.internal.asserts.statement.dml.impl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dml.LoadDataStatement;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.SQLCaseAssertContext;
import org.apache.shardingsphere.test.it.sql.parser.internal.asserts.segment.table.TableAssert;
import org.apache.shardingsphere.test.it.sql.parser.internal.cases.parser.jaxb.statement.dml.LoadDataStatementTestCase;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Load data statement assert.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LoadDataStatementAssert {
    
    /**
     * Assert load data statement is correct with expected parser result.
     *
     * @param assertContext assert context
     * @param actual actual load data statement
     * @param expected expected load data statement test case
     */
    public static void assertIs(final SQLCaseAssertContext assertContext, final LoadDataStatement actual, final LoadDataStatementTestCase expected) {
        assertTable(assertContext, actual, expected);
    }
    
    private static void assertTable(final SQLCaseAssertContext assertContext, final LoadDataStatement actual, final LoadDataStatementTestCase expected) {
        if (null == expected.getTable()) {
            assertNull(actual.getTableSegment(), assertContext.getText("Actual table should not exist."));
        } else {
            TableAssert.assertIs(assertContext, actual.getTableSegment(), expected.getTable());
        }
    }
}
