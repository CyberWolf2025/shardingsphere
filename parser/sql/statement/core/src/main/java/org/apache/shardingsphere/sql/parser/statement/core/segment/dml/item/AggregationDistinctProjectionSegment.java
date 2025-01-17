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

package org.apache.shardingsphere.sql.parser.statement.core.segment.dml.item;

import lombok.Getter;
import org.apache.shardingsphere.sql.parser.statement.core.enums.AggregationType;
import org.apache.shardingsphere.sql.parser.statement.core.util.SQLUtils;

/**
 * Aggregation distinct projection segment.
 */
@Getter
public final class AggregationDistinctProjectionSegment extends AggregationProjectionSegment {
    
    private final String distinctInnerExpression;
    
    public AggregationDistinctProjectionSegment(final int startIndex, final int stopIndex, final AggregationType type, final String expression, final String distinctExpression) {
        super(startIndex, stopIndex, type, expression);
        distinctInnerExpression = SQLUtils.getExpressionWithoutOutsideParentheses(distinctExpression);
    }
    
    public AggregationDistinctProjectionSegment(final int startIndex, final int stopIndex, final AggregationType type, final String expression, final String distinctExpression,
                                                final String separator) {
        super(startIndex, stopIndex, type, expression, separator);
        distinctInnerExpression = SQLUtils.getExpressionWithoutOutsideParentheses(distinctExpression);
    }
}
