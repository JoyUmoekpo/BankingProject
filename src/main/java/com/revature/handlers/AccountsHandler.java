package com.revature.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.entities.Accounts;
import com.revature.utilities.ConnectionUtils;

import io.javalin.http.Handler;

public class AccountsHandler {

	public static Handler getAccountsByIdHandler = ctx -> {
		int ac = Integer.parseInt(ctx.pathParam("id"));
		Connection conn = ConnectionUtils.createConnection();
		String selectAccounts = "select * from accounts where account_number=?";
		PreparedStatement ptsmt = conn.prepareStatement(selectAccounts);
		ptsmt.setInt(1, ac);
		ResultSet rs = ptsmt.executeQuery();
		ArrayList<Accounts> aList = new ArrayList<Accounts>();
		Accounts a;
		while (rs.next()) {
			int id = rs.getInt("account_number");
			int bal = rs.getInt("account_balance");
			a = new Accounts(id, bal);
			aList.add(a);
		}
		if(aList.size() == 0) {
			ctx.status(404);
		}
		ctx.json(aList);
		rs.close();
		ptsmt.close();
	};

	// POST new account to client id
	public static Handler createAccountsHandler = ctx -> {
		Accounts accounts = ctx.bodyAsClass(Accounts.class);
		Connection conn = ConnectionUtils.createConnection();
		PreparedStatement ptsmt = conn.prepareStatement("insert into accounts values(?,?) where account_number=?");
		ptsmt.setInt(1, accounts.getId());
		ptsmt.setInt(2, accounts.getId());
		ptsmt.execute();
		ctx.status(201);
	};

}