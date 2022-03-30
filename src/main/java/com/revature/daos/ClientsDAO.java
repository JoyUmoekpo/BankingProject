package com.revature.daos;

import java.util.List;

import com.revature.entities.Clients;

public interface ClientsDAO {

	boolean addAClient(Clients c);
	
	List<Clients> getAllClients();
	
	List<Clients> getClientsById(int cl);
	
	boolean updateClients(Clients c, int cl);
	
	boolean deleteClient(int cl);

}
