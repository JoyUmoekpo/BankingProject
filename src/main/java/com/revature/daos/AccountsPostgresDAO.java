package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.entities.Accounts;
import com.revature.utilities.ConnectionUtils;

public class AccountsPostgresDAO implements AccountsDAO {

	@Override
	public boolean addAccounts(Accounts ac){
		try (Connection conn = ConnectionUtils.createConnection()) {
			PreparedStatement ptsmt = conn.prepareStatement("insert into accounts values(?,?)"); //? question marks
			ptsmt.setInt(1, ac.getId());
			ptsmt.setInt(2, ac.getBal());
			ptsmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Accounts> getAccountsById(int aid) {

		ArrayList<Accounts> aList = new ArrayList<Accounts>();
		
		try (Connection conn = ConnectionUtils.createConnection()) {
			String selectAccounts = "select * from accounts where account_number=?";
			PreparedStatement ptsmt = conn.prepareStatement(selectAccounts);
			ptsmt.setInt(1, aid);
			ResultSet rs = ptsmt.executeQuery();

			Accounts a;
			while (rs.next()) {
				int id = rs.getInt("account_number");
				int bal = rs.getInt("account_balance");
				a = new Accounts(id, bal);
				aList.add(a);
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aList;
	}
}
