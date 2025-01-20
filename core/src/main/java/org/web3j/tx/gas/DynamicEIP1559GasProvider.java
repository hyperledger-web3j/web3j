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

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthMaxPriorityFeePerGas;

public class DynamicEIP1559GasProvider implements ContractEIP1559GasProvider, PriorityGasProvider {
    private Web3j web3j;
    private long chainId;
    private final Priority priority;
    private final BigDecimal customMultiplier;

    public DynamicEIP1559GasProvider(Web3j web3j, long chainId) {
        this(web3j, chainId, Priority.NORMAL);
    }

    public DynamicEIP1559GasProvider(Web3j web3j, long chainId, Priority priority) {
        this(web3j, chainId, priority, BigDecimal.ONE);
    }

    public DynamicEIP1559GasProvider(
            Web3j web3j, long chainId, Priority priority, BigDecimal customMultiplier) {
        this.web3j = web3j;
        this.chainId = chainId;
        this.priority = priority;
        this.customMultiplier = customMultiplier;
    }

    @Override
    public boolean isEIP1559Enabled() {
        return true;
    }

    @Override
    public long getChainId() {
        return chainId;
    }

    @Override
    public BigInteger getMaxFeePerGas() {
        return getGasPrice();
    }

    @Override
    public BigInteger getMaxPriorityFeePerGas() {
        try {
            EthMaxPriorityFeePerGas ethMaxPriorityFeePerGas =
                    web3j.ethMaxPriorityFeePerGas().send();
            if (ethMaxPriorityFeePerGas.hasError()) {
                throw new RuntimeException(
                        "Error fetching ethMaxPriorityFeePerGas: "
                                + ethMaxPriorityFeePerGas.getError().getMessage());
            }
            return ethMaxPriorityFeePerGas.getMaxPriorityFeePerGas();
        } catch (IOException e) {
            throw new RuntimeException("Failed to get ethMaxPriorityFeePerGas");
        }
    }

    @Override
    public BigInteger getGasPrice() {
        return applyPriority(fetchCurrentGasPrice(), priority, customMultiplier);
    }

    @Override
    public BigInteger getGasLimit(Transaction transaction) {
        return null;
    }

    @Override
    public BigInteger getGasLimit() {
        return null;
    }

    private BigInteger fetchCurrentGasPrice() {
        try {
            EthGasPrice ethGasPrice = web3j.ethGasPrice().send();
            if (ethGasPrice.hasError()) {
                throw new RuntimeException(
                        "Error fetching gas price: " + ethGasPrice.getError().getMessage());
            }
            return ethGasPrice.getGasPrice();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch gas price", e);
        }
    }
}
