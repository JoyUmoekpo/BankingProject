package com.revature.main;

import com.revature.handlers.AccountsHandler;
import com.revature.handlers.ClientsHandler;

import io.javalin.Javalin;

public class App {
public static void main(String[] args) {
	Javalin app = Javalin.create().start(7070);
    
    app.post("/clients", ClientsHandler.addAClientHandler);
    
    app.get("/clients", ClientsHandler.getAllClientsHandler);

    app.get("/clients/{id}", ClientsHandler.getClientsByIdHandler);  

    app.put("/clients/{id}", ClientsHandler.updateClientsHandler);

    app.delete("/clients/{id}", ClientsHandler.deleteClientsHandler);  
    
    app.get("/clients/accounts/{id}", AccountsHandler.getAccountsByIdHandler);
    
    app.post("/clients/accounts", AccountsHandler.createAccountsHandler);
}
}