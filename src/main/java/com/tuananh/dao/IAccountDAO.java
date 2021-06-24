package com.tuananh.dao;

import java.util.List;

import com.tuananh.model.AccountModel;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.Pageble;

public interface IAccountDAO {
	AccountModel findByUserNameAndPassword(String username, String password);
}
