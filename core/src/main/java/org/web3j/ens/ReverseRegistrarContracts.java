/*
 * Copyright 2024 Web3 Labs Ltd.
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

import org.web3j.tx.ChainIdLong;

public class ReverseRegistrarContracts {

    public static final String MAINNET = "0xa58E81fe9b61B5c3fE2AFD33CF304c454AbFc7Cb";
    public static final String SEPOLIA = "0xA0a1AbcDAe1a2a4A2EF8e9113Ff0e02DD81DC0C6";
    public static final String HOLESKY = "0x132AC0B116a73add4225029D1951A9A707Ef673f";
    public static final String LINEA = "0x08D3fF6E65f680844fd2465393ff6f0d742b67D5";
    public static final String LINEA_SEPOLIA = "0x4aAA964D8EB65508ca3DA3b0A3C060c16059E613";

    private ReverseRegistrarContracts() {}

    public static String resolveReverseRegistrarContract(String chainId) {
        final Long chainIdLong = Long.parseLong(chainId);
        if (chainIdLong.equals(ChainIdLong.MAINNET)) {
            return MAINNET;
        } else if (chainIdLong.equals(ChainIdLong.SEPOLIA)) {
            return SEPOLIA;
        } else if (chainIdLong.equals(ChainIdLong.HOLESKY)) {
            return HOLESKY;
        } else if (chainIdLong.equals(ChainIdLong.LINEA)) {
            return LINEA;
        } else if (chainIdLong.equals(ChainIdLong.LINEA_SEPOLIA)) {
            return LINEA_SEPOLIA;
        } else {
            throw new EnsResolutionException(
                    "Unable to resolve ENS reverse registrar contract for network id: " + chainId);
        }
    }
}
