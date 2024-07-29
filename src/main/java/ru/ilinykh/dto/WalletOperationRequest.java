package ru.ilinykh.dto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Yury
 */
public class WalletOperationRequest {
    private UUID Id;
    private String operationType;
    private BigDecimal balance;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

