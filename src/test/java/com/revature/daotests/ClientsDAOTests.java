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
		dao.deleteClients(112);
	}

	@Test
	@Order(1)
	void addingClients() {
		Clients cl = new Clients(112,"Noé", 112);
		dao.addAClient(cl);
		ClientsDAOTests.clientsObject = cl;
		Assertions.assertEquals(112, clientsObject.getId());
	}
	
	@Test
	@Order(2)
	void getClientsId() {
		Clients cl = new Clients(112,"Noé", 112);
		List<Clients> emptyList= new ArrayList<Clients>();
		List<Clients> testList= new ArrayList<Clients>();
		
		testList =dao.getClientsById(cl.getId());
		Assertions.assertNotEquals(emptyList, testList);
	}
	
	@Test
	@Order(3)
	void getAllClients() {
		List<Clients> testList = new ArrayList<Clients>();
		List<Clients> emptyList = new ArrayList<Clients>();
		testList = dao.getAllClients();
		Assertions.assertNotEquals(emptyList, testList);
	}
	
	@Test
	@Order(4)
	void updateClients() {
		Clients cl = new Clients(112, "Chloe", 112);
		dao.updateClients(cl, cl.getId());
		Assertions.assertNotEquals(cl, clientsObject.getId());
	}
	
	@Test
	@Order(5)
	void DeleteClientTest() {
		Clients cl = new Clients(112, "Chloe", 112);
		dao.deleteClients(cl.getId());
		Assertions.assertNotEquals(cl, clientsObject);
	}
	
}
