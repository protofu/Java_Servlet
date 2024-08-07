package com.olympic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.olympic.model.International;
import com.olympic.util.ConnectionPool.DBPool;

public class OlympicDAOImpl implements OlympicDAO {

	@Override
	public void addInter(International international) throws Exception {
		String sql = "INSERT INTO olympic (name, flag) Values (?, ?)";
		try (
			Connection conn = DBPool.getDBPool();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, international.getName());
			pstmt.setString(2, international.getFlag());
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void deleteInter(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyInter(International international) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sumMedal(International international) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<International> getRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
