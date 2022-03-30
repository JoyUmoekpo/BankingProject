package com.revature.daos;

import java.util.List;

import com.revature.entities.Clients;

public interface ClientsDAO {

	boolean addAClient(Clients c);
	
	List<Clients> getAllClients();
	
	List<Clients> getClientsById(int cl);
	
	List<Clients> updateClients(int cl);
	
	boolean deleteClient(int cl);

}
