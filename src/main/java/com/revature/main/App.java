package com.revature.main;

//import com.revature.handlers.AccountsHandler;
import com.revature.handlers.ClientsHandler;

import io.javalin.Javalin;

public class App {
public static void main(String[] args) {
	Javalin app = Javalin.create().start(7070);
    
    app.get("/", ctx->{ctx.result("Hello World");});

    // GET /clients => return all clients
    app.get("/clients", ClientsHandler.getAllClientsHandler);

  // GET /clients/12 => get client with ID 12
    app.get("/clients/{id}", ClientsHandler.getClientsByIdHandler);
  

}
}