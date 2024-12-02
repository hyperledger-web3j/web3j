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
package org.web3j.ens;

import org.junit.jupiter.api.Test;

import org.web3j.tx.ChainIdLong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.web3j.ens.Contracts.HOLESKY;
import static org.web3j.ens.Contracts.LINEA;
import static org.web3j.ens.Contracts.LINEA_SEPOLIA;
import static org.web3j.ens.Contracts.MAINNET;
import static org.web3j.ens.Contracts.RINKEBY;
import static org.web3j.ens.Contracts.ROPSTEN;
import static org.web3j.ens.Contracts.SEPOLIA;
import static org.web3j.ens.Contracts.resolveRegistryContract;
import static org.web3j.ens.NameWrapperUrl.getEnsMetadataApi;
import static org.web3j.ens.ReverseRegistrarContracts.resolveReverseRegistrarContract;

@SuppressWarnings("deprecation")
class ContractsTest {

    @Test
    void testResolveRegistryContract() {
        assertEquals(resolveRegistryContract(ChainIdLong.MAINNET + ""), (MAINNET));
        assertEquals(resolveRegistryContract(ChainIdLong.ROPSTEN + ""), (ROPSTEN));
        assertEquals(resolveRegistryContract(ChainIdLong.RINKEBY + ""), (RINKEBY));
        assertEquals(resolveRegistryContract(ChainIdLong.SEPOLIA + ""), (SEPOLIA));
        assertEquals(resolveRegistryContract(ChainIdLong.HOLESKY + ""), (HOLESKY));
        assertEquals(resolveRegistryContract(ChainIdLong.LINEA + ""), (LINEA));
        assertEquals(resolveRegistryContract(ChainIdLong.LINEA_SEPOLIA + ""), (LINEA_SEPOLIA));
    }

    @Test
    void testReverseRegistrarContract() {
        assertEquals(
                resolveReverseRegistrarContract(ChainIdLong.MAINNET + ""),
                (ReverseRegistrarContracts.MAINNET));
        assertEquals(
                resolveReverseRegistrarContract(ChainIdLong.SEPOLIA + ""),
                (ReverseRegistrarContracts.SEPOLIA));
        assertEquals(
                resolveReverseRegistrarContract(ChainIdLong.HOLESKY + ""),
                (ReverseRegistrarContracts.HOLESKY));
        assertEquals(
                resolveReverseRegistrarContract(ChainIdLong.LINEA + ""),
                (ReverseRegistrarContracts.LINEA));
        assertEquals(
                resolveReverseRegistrarContract(ChainIdLong.LINEA_SEPOLIA + ""),
                (ReverseRegistrarContracts.LINEA_SEPOLIA));
    }

    @Test
    void testNameWrapperApiLinks() {
        assertEquals(getEnsMetadataApi(ChainIdLong.MAINNET + ""), (NameWrapperUrl.MAINNET_URL));
        assertEquals(getEnsMetadataApi(ChainIdLong.SEPOLIA + ""), (NameWrapperUrl.SEPOLIA_URL));
        assertEquals(getEnsMetadataApi(ChainIdLong.HOLESKY + ""), (NameWrapperUrl.HOLESKY_URL));
    }

    @Test
    void testResolveRegistryContractInvalid() {
        assertThrows(
                EnsResolutionException.class, () -> resolveRegistryContract(ChainIdLong.NONE + ""));
    }

    @Test
    void testReverseRegistrarContractInvalid() {
        assertThrows(
                EnsResolutionException.class,
                () -> resolveReverseRegistrarContract(ChainIdLong.NONE + ""));
    }
}
