package org.web3j.tx.gas;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthEstimateGas;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.request.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DynamicGasProvider implements ContractGasProvider, PriorityGasProvider {

    private final Web3j web3j;
    private final Priority priority;
    private final BigDecimal customMultiplier;

    public DynamicGasProvider(Web3j web3j) {
        this(web3j, Priority.NORMAL);
    }

    public DynamicGasProvider(Web3j web3j, Priority priority) {
        this(web3j, priority, BigDecimal.ONE);
    }

    public DynamicGasProvider(Web3j web3j, Priority priority, BigDecimal customMultiplier) {
        this.web3j = web3j;
        this.priority = priority;
        this.customMultiplier = customMultiplier;
    }

    @Override
    public BigInteger getGasPrice() {
        return applyPriority(fetchCurrentGasPrice(), priority, customMultiplier);
    }

    @Override
    public BigInteger getGasLimit() {
        return null;
    }

    public BigInteger getGasLimit(Transaction transaction) {
        try {
            EthEstimateGas ethEstimateGas = web3j.ethEstimateGas(transaction).send();
            if (ethEstimateGas.hasError()) {
                throw new RuntimeException("Error estimating gas limit: " + ethEstimateGas.getError().getMessage());
            }
            return ethEstimateGas.getAmountUsed();
        } catch (Exception e) {
            throw new RuntimeException("Failed to estimate gas limit", e);
        }
    }


    private BigInteger fetchCurrentGasPrice() {
        try {
            EthGasPrice ethGasPrice = web3j.ethGasPrice().send();
            if (ethGasPrice.hasError()) {
                throw new RuntimeException("Error fetching gas price: " + ethGasPrice.getError().getMessage());
            }
            return ethGasPrice.getGasPrice();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch gas price", e);
        }
    }
}
