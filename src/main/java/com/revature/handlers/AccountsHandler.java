package com.revature.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.revature.daos.AccountsDAO;
import com.revature.daos.AccountsPostgresDAO;
import com.revature.entities.Accounts;
import com.revature.utilities.ConnectionUtils;

import io.javalin.http.Handler;

public class AccountsHandler {
	
	static AccountsDAO dao = new AccountsPostgresDAO();
	
	public static Handler getAccountsByIdHandler = ctx -> {
		int aid = Integer.parseInt(ctx.pathParam("id"));
		List<Accounts> aList = dao.getAccountsById(aid);
		
		if(aList.size() == 0)
			ctx.status(404);
			ctx.result("No client found.");

		
		ctx.json(aList);
	};

	// POST new account to client id

	public static Handler createAccountsHandler = ctx -> {
		Accounts accounts = ctx.bodyAsClass(Accounts.class);
		Connection conn = ConnectionUtils.createConnection();
		PreparedStatement ptsmt = conn.prepareStatement("insert into accounts values(?,?)"); 
		ptsmt.setInt(1, accounts.getId());
		ptsmt.setInt(2, accounts.getBal());
		ptsmt.execute();
		ctx.status(201);
		ctx.result("Account added successfully.");
	};


}