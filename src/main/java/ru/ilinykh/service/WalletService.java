package ru.ilinykh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ilinykh.dao.WalletDao;
import ru.ilinykh.model.Wallet;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Yury
 */
@Service
public class WalletService {

    private final WalletDao walletDao;

    @Autowired
    public WalletService(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    @Transactional
    public void performOperation(UUID walletId, String operationType, BigDecimal amount) throws Exception {
        Optional<Wallet> walletOpt = walletDao.getWalletByUuid(walletId);

        if (walletOpt.isPresent()) {
            Wallet wallet = walletOpt.get();

            if ("DEPOSIT".equalsIgnoreCase(operationType)) {
                wallet.setBalance(wallet.getBalance().add(amount));
            } else if ("WITHDRAW".equalsIgnoreCase(operationType)) {
                if (wallet.getBalance().compareTo(amount) == 0 || wallet.getBalance().compareTo(amount) > 0) {
                    wallet.setBalance(wallet.getBalance().subtract(amount));
                } else {
                    throw new Exception("Insufficient funds");
                }
            } else {
                throw new IllegalArgumentException("Invalid operation type");
            }

            walletDao.save(wallet);
        } else {
            throw new Exception("Wallet not found");
        }
    }
}
