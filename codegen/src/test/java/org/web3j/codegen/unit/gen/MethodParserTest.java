/*
 * Copyright 2019 Web3 Labs Ltd.
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
package org.web3j.codegen.unit.gen;

import java.lang.reflect.Method;
import java.util.Optional;

import com.squareup.javapoet.MethodSpec;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodParserTest extends Setup {
    @Test
    public void testThatDeployMethodWasGenerated() {

        Optional<Method> deployMethod =
                filteredMethods.stream().filter(m -> m.getName().equals("deploy")).findAny();
        MethodSpec deployMethodSpec =
                new MethodParser(deployMethod.get(), greeterContractClass).getMethodSpec();
        assertEquals(
                deployMethodSpec.toString(),
                "@org.junit.jupiter.api.Test\n"
                        + "public void deploy(org.web3j.protocol.Web3j web3j, org.web3j.tx.TransactionManager transactionManager, org.web3j.tx.gas.ContractGasProvider contractGasProvider) throws java.lang.Exception {\n"
                        + "  greeter=org.com.generated.contracts.Greeter.deploy(web3j,transactionManager,contractGasProvider,\"REPLACE_ME\").send();\n"
                        + "}\n");
    }

    @Test
    public void testThatLoadMethodWasGenerated() {

        Optional<Method> loadMethod =
                filteredMethods.stream().filter(m -> m.getName().equals("load")).findAny();
        MethodSpec loadMethodSpec =
                new MethodParser(loadMethod.get(), greeterContractClass).getMethodSpec();
        assertEquals(
                loadMethodSpec.toString(),
                "@org.junit.jupiter.api.Test\n"
                        + "public void load(org.web3j.protocol.Web3j web3j, org.web3j.tx.TransactionManager transactionManager, org.web3j.tx.gas.ContractGasProvider contractGasProvider) throws java.lang.Exception {\n"
                        + "  greeter=org.com.generated.contracts.Greeter.load(\"REPLACE_ME\",web3j,transactionManager,contractGasProvider).send();\n"
                        + "}\n");
    }

    @Test
    public void testThatKillMethodWasGenerated() {

        Optional<Method> killMethod =
                filteredMethods.stream().filter(m -> m.getName().equals("kill")).findAny();
        MethodSpec killMethodSpec =
                new MethodParser(killMethod.get(), greeterContractClass).getMethodSpec();
        assertEquals(
                killMethodSpec.toString(),
                "@org.junit.jupiter.api.Test\n"
                        + "public void kill() throws java.lang.Exception {\n"
                        + "  org.web3j.protocol.core.methods.response.TransactionReceipt transactionReceiptVar=greeter.kill().send();\n"
                        + "}\n");
    }

    @Test
    public void testThatNewGreetingMethodWasGenerated() {

        Optional<Method> deployMethod =
                filteredMethods.stream().filter(m -> m.getName().equals("newGreeting")).findAny();
        MethodSpec deployMethodSpec =
                new MethodParser(deployMethod.get(), greeterContractClass).getMethodSpec();
        assertEquals(
                deployMethodSpec.code.toString(),
                "org.web3j.protocol.core.methods.response.TransactionReceipt transactionReceiptVar=greeter.newGreeting(\"REPLACE_ME\").send();\n");
    }
}
