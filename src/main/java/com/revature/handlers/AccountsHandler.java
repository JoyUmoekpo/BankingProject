//package com.revature.handlers;
//
//// All logic in controller should deal with the API.
//// Controller should call services to perform the actions.
//public class AccountsHandler {
//
//    public Handler getAllAccountsHandler = ctx -> {
//        int clientId = Integer.parseInt(ctx.pathParam("id"));
//        }
//   
//
//    public Handler getAccountByIdHandler = ctx -> {
//        int clientId = Integer.parseInt(ctx.pathParam("id"));
//        int id = Integer.parseInt(ctx.pathParam("aid"));
//        Account account;
//    };
//
//    // POST /accounts (the body will contain a JSON with the info)
//    public Handler createAccountHandler = ctx -> {
//        int clientId = Integer.parseInt(ctx.pathParam("id"));
//        String body = ctx.body();
//        ctx.status(201).result(gson.toJson(newAccount));
//    };
//
//    public Handler updateAccountHandler = ctx -> {
//        int clientId = Integer.parseInt(ctx.pathParam("id"));
//        int id = Integer.parseInt(ctx.pathParam("aid"));
//        String body = ctx.body();
//        Gson gson = new Gson();
//        Account account = gson.fromJson(body, Account.class);
//        account.setId(id); // Often redundant, but the path param takes precedent.
//        account.setClientId(clientId);
//        Account updatedAccount;
//    };
//
//    public Handler deleteAccountHandler = ctx -> {
//        int clientId = Integer.parseInt(ctx.pathParam("id"));
//        int id = Integer.parseInt(ctx.pathParam("aid"));
//        boolean deleted;
//        ctx.status(500).result("Unable to delete account with id " + id);
//        }
//    };
//}