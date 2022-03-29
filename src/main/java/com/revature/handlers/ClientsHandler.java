package com.revature.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.entities.Clients;
import com.revature.utilities.ConnectionUtils;

import io.javalin.http.Handler;

public class ClientsHandler {
	
	public static Handler addAClientHandler = ctx -> {
		Clients clients = ctx.bodyAsClass(Clients.class);
		Connection conn = ConnectionUtils.createConnection();
		PreparedStatement ptsmt = conn.prepareStatement("insert into clients values(?,?,?)");
		ptsmt.setInt(1, clients.getId());
		ptsmt.setString(2, clients.getName());
		ptsmt.setInt(3, clients.getAcc_num());
		ptsmt.execute();
		ctx.status(201);
	};

	public static Handler getAllClientsHandler = ctx -> {
		Connection conn = ConnectionUtils.createConnection();
		String selectClients = "select * from clients";
		PreparedStatement ptsmt = conn.prepareStatement(selectClients);
		ResultSet rs = ptsmt.executeQuery();
		ArrayList<Clients> cList = new ArrayList<Clients>();
		Clients c;
		while (rs.next()) {
			int id = rs.getInt("clientid");
			String name = rs.getString("client_name");
			int acc_num = rs.getInt("account_number");
			c = new Clients(id, name, acc_num);
			cList.add(c);
			ctx.json(cList);
			
		}
	};

	public static Handler getClientsByIdHandler = ctx -> {
		int cl = Integer.parseInt(ctx.pathParam("id"));
		Connection conn = ConnectionUtils.createConnection();
		String selectClients = "select * from clients where clientid=?";
		PreparedStatement ptsmt = conn.prepareStatement(selectClients);
		ptsmt.setInt(1, cl);
		ResultSet rs = ptsmt.executeQuery();
		ArrayList<Clients> cList = new ArrayList<Clients>();
		Clients c;
		while (rs.next()) {
			int id = rs.getInt("clientid");
			String name = rs.getString("client_name");
			int acc_num = rs.getInt("account_number");
			c = new Clients(id, name, acc_num);
			cList.add(c);
		}
		ctx.json(cList);
		rs.close();
		ptsmt.close();
	};
	
	public static Handler updateClientsHandler = ctx -> {
		int cl = Integer.parseInt(ctx.pathParam("id"));
		Clients c = ctx.bodyAsClass(Clients.class);
		Connection conn = ConnectionUtils.createConnection();		
		PreparedStatement ptsmt = conn.prepareStatement("update clients set client_name=? where clientid=?");
		ptsmt.setInt(1, cl);
		ptsmt.setString(2, c.getName());
		ptsmt.execute();
		ctx.status(201);
		
	};

	public static Handler deleteClientsHandler = ctx -> {
		int cl = Integer.parseInt(ctx.pathParam("id"));
		Connection conn = ConnectionUtils.createConnection();		
		PreparedStatement ptsmt = conn.prepareStatement("delete from clients where clientid=?");
		ptsmt.setInt(1, cl);
		ptsmt.execute();
		ctx.status(205);
		ptsmt.close();
	};
	
};
