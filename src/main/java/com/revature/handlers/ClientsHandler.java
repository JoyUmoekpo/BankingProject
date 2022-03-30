package com.revature.handlers;

import java.util.List;

import com.revature.daos.ClientsDAO;
import com.revature.daos.ClientsPostgresDAO;
import com.revature.entities.Clients;

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
		if (dao.updateClients(c, cl)) {
		ctx.status(201);
		}
	};

	public static Handler deleteClientsHandler = ctx -> {
		int cl = Integer.parseInt(ctx.pathParam("id"));
		if (dao.deleteClients(cl));
		ctx.status(205);
	};
	
};
