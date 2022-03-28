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
		PreparedStatement ptsmt = conn.prepareStatement("insert into clients values(?, ?)");
		ptsmt.setInt(1, clients.getId());
		ptsmt.setString(2, clients.getName());
		ptsmt.execute();
		ctx.status(200);
		ptsmt.close();
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
			c = new Clients(id, name);
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
			c = new Clients(id, name);
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
		ptsmt.setString(1, c.getName());
		ptsmt.setInt(2, cl);
		ptsmt.execute();
		ctx.status(201);
		
	};

};
