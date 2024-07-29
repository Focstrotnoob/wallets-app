package ru.ilinykh.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.ilinykh.model.Wallet;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author Yury
 */
public class WalletMapper implements RowMapper<Wallet> {

    @Override
    public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
        UUID id = (UUID) rs.getObject("id");
        BigDecimal balance = rs.getBigDecimal("balance");
        return new Wallet(id, balance);
    }
}
