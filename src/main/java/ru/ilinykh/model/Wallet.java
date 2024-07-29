package ru.ilinykh.model;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Yury
 */
public class Wallet {

    private UUID id;
    private BigDecimal balance;

    public Wallet() {
    }

    public Wallet(UUID id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
