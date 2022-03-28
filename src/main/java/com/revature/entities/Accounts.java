package com.revature.entities;

public class Accounts {
    private int id;
    private String accountNumber;
    private int balanceInCents;
    private int clientId;

    public Accounts(){
		super();
    }

    public Accounts(int id, String accountNumber, int balanceInCents, int clientId) {
		super();
    	this.id = id;
        this.accountNumber = accountNumber;
        this.balanceInCents = balanceInCents;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalanceInCents() {
        return balanceInCents;
    }

    public void setBalanceInCents(int balanceInCents) {
        this.balanceInCents = balanceInCents;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balanceInCents=" + balanceInCents +
                ", clientId=" + clientId +
                '}';
    }
}
