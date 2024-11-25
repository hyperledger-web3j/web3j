package org.web3j.ens;

import org.web3j.tx.ChainIdLong;

public class NameWrapperApi {

    public static final String BASE_URL = "https://ens-metadata-service.appspot.com/";
    public static final String MAINNET = "0xa58E81fe9b61B5c3fE2AFD33CF304c454AbFc7Cb";
    public static final String SEPOLIA = "0xA0a1AbcDAe1a2a4A2EF8e9113Ff0e02DD81DC0C6";
    public static final String HOLESKY = "0x132AC0B116a73add4225029D1951A9A707Ef673f";

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
