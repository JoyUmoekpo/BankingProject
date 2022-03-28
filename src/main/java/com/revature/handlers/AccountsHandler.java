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
		ctx.json(aList);
		rs.close();
		ptsmt.close();
	};

//	// POST /accounts (the body will contain a JSON with the info)
//	public Handler createAccountHandler = ctx -> {
//		int clientId = Integer.parseInt(ctx.pathParam("id"));
//		String body = ctx.body();
//		ctx.status(201);
//	};

}