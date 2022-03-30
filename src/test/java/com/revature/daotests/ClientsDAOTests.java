package com.revature.daotests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.daos.ClientsDAO;
import com.revature.daos.ClientsPostgresDAO;
import com.revature.entities.Clients;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ClientsDAOTests {
	private static ClientsDAO dao = new ClientsPostgresDAO();
	private static Clients clientsObject;
	
	@BeforeAll
	static void clearOut() {
		dao.deleteClients(400);
	}

	@Test
	@Order(1)
	void addingClients() {
		Clients cl = new Clients(400,"Noé", 400);
		dao.addAClient(cl);
		ClientsDAOTests.clientsObject = cl;
		Assertions.assertEquals(400, clientsObject.getId());
	}
	
	@Test
	@Order(2)
	void getClientsId() {
		Clients cl = new Clients(400,"Noé", 400);
		List<Clients> emptyList= new ArrayList<Clients>();
		List<Clients> testList= new ArrayList<Clients>();
		
		testList =dao.getClientsById(cl.getId());
		Assertions.assertNotEquals(emptyList, testList);
	}
	
}
