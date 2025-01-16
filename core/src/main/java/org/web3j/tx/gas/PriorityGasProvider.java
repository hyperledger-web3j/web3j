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

    BigInteger calculateGasPrice(BigInteger baseGasPrice, Priority priority, BigDecimal customMultiplier);

    default BigInteger applyPriority(BigInteger baseGasPrice, Priority priority, BigDecimal customMultiplier) {

        return switch (priority) {
            case FAST -> baseGasPrice.multiply(BigInteger.valueOf(2)); // 2x for fast
            case NORMAL -> baseGasPrice; // Default gas price
            case SLOW -> baseGasPrice.divide(BigInteger.valueOf(2)); // 0.5x for slow
            case CUSTOM -> {
                if (customMultiplier == null || customMultiplier.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new IllegalArgumentException("Custom multiplier must be a positive value");
                }
                yield new BigDecimal(baseGasPrice).multiply(customMultiplier).toBigInteger();
            }
        };
    }
}
