package org.web3j.ens;

import org.web3j.tx.ChainIdLong;

public class NameWrapperApi {

    public static final String BASE_URL = "https://ens-metadata-service.appspot.com/";
    public static final String MAINNET = "0xD4416b13d2b3a9aBae7AcD5D6C2BbDBE25686401";
    public static final String SEPOLIA = "0x0635513f179D50A207757E05759CbD106d7dFcE8";
    public static final String HOLESKY = "0xab50971078225D365994dc1Edcb9b7FD72Bb4862";

    private NameWrapperApi() {}

    public static String getEnsMetadataApi(String chainId) {
        final Long chainIdLong = Long.parseLong(chainId);
        if (chainIdLong.equals(ChainIdLong.MAINNET)) {
            return BASE_URL + "mainnet/" + MAINNET + "/";
        } else if (chainIdLong.equals(ChainIdLong.SEPOLIA)) {
            return BASE_URL + "sepolia/" + SEPOLIA + "/";
        } else if (chainIdLong.equals(ChainIdLong.HOLESKY)) {
            return BASE_URL + "holesky/" + HOLESKY + "/";
        } else {
            throw new EnsResolutionException(
                    "Unable to get ENS metadata API for network id: " + chainId);
        }
    }
}
