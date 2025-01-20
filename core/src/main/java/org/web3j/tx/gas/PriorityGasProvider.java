/*
 * Copyright 2025 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.tx.gas;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface PriorityGasProvider {
    enum Priority {
        FAST,
        NORMAL,
        SLOW,
        CUSTOM
    }

    default BigInteger applyPriority(
            BigInteger baseGasPrice, Priority priority, BigDecimal customMultiplier) {

        return switch (priority) {
            case FAST -> baseGasPrice.multiply(BigInteger.valueOf(2)); // 2x for fast
            case NORMAL -> baseGasPrice; // Default gas price
            case SLOW -> baseGasPrice.divide(BigInteger.valueOf(2)); // 0.5x for slow
            case CUSTOM -> {
                if (customMultiplier == null || customMultiplier.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new IllegalArgumentException(
                            "Custom multiplier must be a positive value");
                }
                yield new BigDecimal(baseGasPrice).multiply(customMultiplier).toBigInteger();
            }
        };
    }
}
