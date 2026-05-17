package com.tejas.wallet.repository;

import com.tejas.wallet.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcWalletAccountRepository implements AccountRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcWalletAccountRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Optional<Account> findById(Long accountId) {

		String sql = """
				SELECT id, name, balance
				FROM account
				WHERE id = ?
				""";

		List<Account> accounts = jdbcTemplate.query(sql, this::mapRow, accountId);

		return accounts.stream().findFirst();
	}

	@Override
	public List<Account> findAll() {

		String sql = """
				SELECT id, name, balance
				FROM account
				ORDER BY id
				""";

		return jdbcTemplate.query(sql, this::mapRow);
	}

	@Override
	public int updateBalance(Long accountId, BigDecimal newBalance) {

		String sql = """
				UPDATE account
				SET balance = ?
				WHERE id = ?
				""";

		return jdbcTemplate.update(sql, newBalance, accountId);
	}

	private Account mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new Account().setId(rs.getLong("id")).setName(rs.getString("name"))
				.setBalance(rs.getBigDecimal("balance"));
	}
}