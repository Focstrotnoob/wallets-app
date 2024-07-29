package ru.ilinykh.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.ilinykh.mapper.WalletMapper;
import ru.ilinykh.model.Wallet;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Yury
 */
@Repository
public class WalletDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WalletDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Wallet> getWalletByUuid(UUID uuid) {
        String sql = "SELECT id, balance FROM Wallets WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{uuid}, new WalletMapper()));
    }

    public void save (Wallet wallet){
        jdbcTemplate.update("UPDATE wallets set balance = ? where id = ?", wallet.getBalance(), wallet.getId());
    }
}
