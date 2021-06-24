package com.tuananh.daoimpl;

import java.util.List;

import com.tuananh.dao.IAccountDAO;
import com.tuananh.mapper.AccountMapper;
import com.tuananh.model.AccountModel;

public class AccountDAO extends AbstractDAO<AccountModel> implements IAccountDAO{

	@Override
	public AccountModel findByUserNameAndPassword(String username, String password) {
		String sql = "select * from account where username = ? and password = ? and deleted = 0";
		List<AccountModel> account = query(sql, new AccountMapper(), username, password);
		return account.isEmpty() ? null : account.get(0);
	}

}
