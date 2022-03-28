package com.revature.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.entities.Clients;
import com.revature.utilities.ConnectionUtils;

import io.javalin.http.Handler;

public class ClientsHandler {

    public static Handler getAllClientsHandler = ctx -> {
        Connection conn = ConnectionUtils.createConnection();
        String selectClients = "select * from clients";
        PreparedStatement ptsmt = conn.prepareStatement(selectClients);
        ResultSet rs = ptsmt.executeQuery();
        ArrayList<Clients> cList = new ArrayList<Clients>();
        Clients c;
        while (rs.next()) {
        	int id = rs.getInt("clientId");
        	String name = rs.getString("client_name");
        	c = new Clients(id, name);
        	cList.add(c);
        	ctx.json(cList);
        }
    };
}

