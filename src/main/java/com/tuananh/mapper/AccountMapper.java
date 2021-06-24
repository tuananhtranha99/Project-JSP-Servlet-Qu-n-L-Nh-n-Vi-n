package com.tuananh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuananh.model.AccountModel;
import com.tuananh.model.EmployeeModel;

public class AccountMapper implements RowMapper<AccountModel>{

	@Override
	public AccountModel mapRow(ResultSet resultSet) {
		try {
			AccountModel account = new AccountModel();
			account.setId(resultSet.getLong("id"));
			account.setUsername(resultSet.getString("username"));
			account.setPassword(resultSet.getString("password"));
			account.setEmail(resultSet.getString("email"));
			return account;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
