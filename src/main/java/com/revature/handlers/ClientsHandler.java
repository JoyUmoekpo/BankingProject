package com.revature.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.revature.daos.ClientsDAO;
import com.revature.daos.ClientsPostgresDAO;
import com.revature.entities.Clients;
import com.revature.utilities.ConnectionUtils;

import io.javalin.http.Handler;

public class ClientsHandler {
	
	static ClientsDAO dao = new ClientsPostgresDAO();
	
	public static Handler addAClientHandler = ctx -> {
		Clients c = ctx.bodyAsClass(Clients.class);
		if (dao.addAClient(c)) {
		ctx.result("Client added successfully.");
		ctx.status(201);
		}
	};

	public static Handler getAllClientsHandler = ctx -> {
		List<Clients> cList = dao.getAllClients();
		ctx.json(cList);	
	};

	public static Handler getClientsByIdHandler = ctx -> {
		int cl = Integer.parseInt(ctx.pathParam("id"));
		List<Clients>  cList = dao.getClientsById(cl);
		if(cList.size() == 0)
			ctx.status(404);
		ctx.json(cList);
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
