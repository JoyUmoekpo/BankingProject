package com.revature.main;

import com.revature.handlers.AccountsHandler;
import com.revature.handlers.ClientsHandler;

import io.javalin.Javalin;

public class App {
public static void main(String[] args) {
	Javalin app = Javalin.create().start(7070);
    
    // POST /clients => Creates a new client
    app.post("/clients", ClientsHandler.addAClientHandler);
    
    // GET /clients => return all clients
    app.get("/clients", ClientsHandler.getAllClientsHandler);

    // GET /clients/12 => get client with ID 12
    app.get("/clients/{id}", ClientsHandler.getClientsByIdHandler);  

    app.put("/clients/{id}", ClientsHandler.updateClientsHandler);

    app.delete("/clients/{id}", ClientsHandler.deleteClientsHandler);  
    
    app.get("/clients/accounts/{id}", AccountsHandler.getAccountsByIdHandler);

}
}