package com.revature.handlers;

import java.util.List;

import com.revature.daos.AccountsDAO;
import com.revature.daos.AccountsPostgresDAO;
import com.revature.entities.Accounts;
import io.javalin.http.Handler;

public class AccountsHandler {
	
	static AccountsDAO dao = new AccountsPostgresDAO();
	
	public static Handler getAccountsByIdHandler = ctx -> {
		int aid = Integer.parseInt(ctx.pathParam("id"));
		List<Accounts> aList = dao.getAccountsById(aid);
		
		if(aList.size() == 0)
			ctx.status(404);
		
		ctx.json(aList);
	};

	// POST new account to client id

	public static Handler createAccountsHandler = ctx -> {
		int aid = Integer.parseInt(ctx.pathParam("id"));
		Accounts ac = ctx.bodyAsClass(Accounts.class);
		if (dao.addAccounts(aid, ac)) {
			ctx.result("Account added successfully.");
			ctx.status(201);
		}else {
		
		ctx.status(404);
		}
		
	};

}