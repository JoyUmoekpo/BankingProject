package com.revature.daos;

import java.util.List;

import com.revature.entities.Accounts;

public interface AccountsDAO {
	
	boolean addAccounts(Accounts ac);
	
	List<Accounts> getAccountsById(int aid);
	
}
