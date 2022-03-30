package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.entities.Clients;
import com.revature.utilities.ConnectionUtils;

public class ClientsPostgresDAO implements ClientsDAO {

	@Override
	public boolean addAClient(Clients c) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtils.createConnection();) {
			PreparedStatement ptsmt = conn.prepareStatement("insert into clients values(?,?,?)");
			ptsmt.setInt(1, c.getId());
			ptsmt.setString(2, c.getName());
			ptsmt.setInt(3, c.getAcc_num());
			ptsmt.execute();
			ptsmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public List<Clients> updateClients(int cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteClient(int cl) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Clients> getAllClients() {
		// TODO Auto-generated method stub
		String selectClients = "select * from clients";
		ArrayList<Clients> cList = new ArrayList<Clients>();
		Clients c;
		
		try (Connection conn = ConnectionUtils.createConnection();) {
		PreparedStatement ptsmt = conn.prepareStatement(selectClients);
		ResultSet rs = ptsmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("clientid");
			String name = rs.getString("client_name");
			int acc_num = rs.getInt("account_number");
			c = new Clients(id, name, acc_num);
			cList.add(c);			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public List<Clients> getClientsById(int cl) {
		// TODO Auto-generated method stub
		String selectClients = "select * from clients where clientid=?";
		ArrayList<Clients> cList = new ArrayList<Clients>();
		Clients c;
		
		try (Connection conn = ConnectionUtils.createConnection()) {
		PreparedStatement ptsmt = conn.prepareStatement(selectClients);
		ptsmt.setInt(1, cl);
		ResultSet rs = ptsmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("clientid");
			String name = rs.getString("client_name");
			int acc_num = rs.getInt("account_number");
			c = new Clients(id, name, acc_num);
			cList.add(c);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cList;
	}

	
}
