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
package org.web3j.protocol.scenarios;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.web3j.EVMTest;
import org.web3j.NodeType;
import org.web3j.protocol.Web3j;
import org.web3j.test.contract.HumanStandardToken;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DynamicGasProvider;
import org.web3j.tx.gas.PriorityGasProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EVMTest(type = NodeType.BESU)
public class DynamicGasProviderIT extends Scenario {
    static ContractGasProvider dynamicGasProvider;
    static String contractAddress;
    static final String TOKEN_NAME = "Alice Token";
    static final String TOKEN_SYMBOL = "ATK";
    static final BigInteger TOKEN_DECIMALS = BigInteger.valueOf(18L);
    static final BigInteger TOKEN_SUPPLY = BigInteger.valueOf(10_000_000L);

    @BeforeAll
    static void setUp(Web3j web3j) throws Exception {
        dynamicGasProvider = new DynamicGasProvider(web3j);
        contractAddress = sendTransaction();
    }

    @Test
    public void testContractCreation() {
        HumanStandardToken humanStandardToken =
                HumanStandardToken.load(contractAddress, web3j, ALICE, dynamicGasProvider);

        assertNotNull(humanStandardToken.getTransactionReceipt().get());
        assertEquals(
                humanStandardToken.getTransactionReceipt().get().getContractAddress(),
                contractAddress);
    }

    @Test
    public void callSmartContractFunction() throws Exception {
        HumanStandardToken humanStandardToken =
                HumanStandardToken.load(contractAddress, web3j, ALICE, dynamicGasProvider);

        assertEquals(humanStandardToken.name().send(), TOKEN_NAME);

        assertNotNull(humanStandardToken.transfer(BOB.getAddress(), BigInteger.ONE).send());
        assertEquals(humanStandardToken.balanceOf(BOB.getAddress()).send(), BigInteger.ONE);
    }

    @Test
    public void callSmartContractFunctionWithPriority() throws Exception {
        DynamicGasProvider fastDynamicGasProvider =
                new DynamicGasProvider(web3j, PriorityGasProvider.Priority.FAST);
        DynamicGasProvider slowDynamicGasProvider =
                new DynamicGasProvider(web3j, PriorityGasProvider.Priority.SLOW);
        DynamicGasProvider customDynamicGasProvider =
                new DynamicGasProvider(
                        web3j, PriorityGasProvider.Priority.CUSTOM, BigDecimal.valueOf(1.5));

        assertEquals(
                dynamicGasProvider.getGasPrice().multiply(BigInteger.TWO),
                fastDynamicGasProvider.getGasPrice());
        assertEquals(
                dynamicGasProvider.getGasPrice().divide(BigInteger.TWO),
                slowDynamicGasProvider.getGasPrice());
        assertEquals(
                new BigDecimal(dynamicGasProvider.getGasPrice())
                        .multiply(BigDecimal.valueOf(1.5))
                        .toBigInteger(),
                customDynamicGasProvider.getGasPrice());

        HumanStandardToken humanStandardToken =
                HumanStandardToken.load(contractAddress, web3j, ALICE, fastDynamicGasProvider);

        assertEquals(humanStandardToken.name().send(), TOKEN_NAME);

        assertNotNull(humanStandardToken.transfer(BOB.getAddress(), BigInteger.ONE).send());
        assertEquals(humanStandardToken.balanceOf(BOB.getAddress()).send(), BigInteger.ONE);
    }

    private static String sendTransaction() throws Exception {
        return HumanStandardToken.deploy(
                        web3j,
                        ALICE,
                        dynamicGasProvider,
                        TOKEN_SUPPLY,
                        TOKEN_NAME,
                        TOKEN_DECIMALS,
                        TOKEN_SYMBOL)
                .send()
                .getContractAddress();
    }
}
