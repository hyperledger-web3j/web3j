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

public class NameWrapperApi {

    public static final String BASE_URL = "https://ens-metadata-service.appspot.com/";
    public static final String MAINNET_URL =
            BASE_URL + "mainnet/" + "0xD4416b13d2b3a9aBae7AcD5D6C2BbDBE25686401/";
    public static final String SEPOLIA_URL =
            BASE_URL + "sepolia/" + "0x0635513f179D50A207757E05759CbD106d7dFcE8/";
    public static final String HOLESKY_URL =
            BASE_URL + "holesky/" + "0xab50971078225D365994dc1Edcb9b7FD72Bb4862/";

    private NameWrapperApi() {}

    public static String getEnsMetadataApi(String chainId) {
        final Long chainIdLong = Long.parseLong(chainId);
        if (chainIdLong.equals(ChainIdLong.MAINNET)) {
            return MAINNET_URL;
        } else if (chainIdLong.equals(ChainIdLong.SEPOLIA)) {
            return SEPOLIA_URL;
        } else if (chainIdLong.equals(ChainIdLong.HOLESKY)) {
            return HOLESKY_URL;
        } else {
            throw new EnsResolutionException(
                    "Unable to get ENS metadata API for network id: " + chainId);
        }
    }
}
