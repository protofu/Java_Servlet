package com.olympic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.olympic.model.International;
import com.olympic.util.ConnectionPool.DBPool;

public class OlympicDAOImpl implements OlympicDAO {

	@Override
	public void addInter(International international) throws Exception {
		String sql = "INSERT INTO olympic (name, flag, content) Values (?, ?, ?)";
		try (Connection conn = DBPool.getDBPool(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, international.getName());
			pstmt.setString(2, international.getFlag());
			pstmt.setString(3, international.getContent());
			pstmt.executeUpdate();
		}

	}

	@Override
	public void deleteInter(int id) throws Exception {
		String sql = "DELETE FROM olympic WHERE id = ?";
		try (Connection con = DBPool.getDBPool(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
	}

	@Override
	public void modifyInter(International international) throws Exception {
		String sql = "UPDATE olympic SET name=?, flag=?, content=?, gold=?, silver=?, bronze=? WHERE id=?";
		try (Connection con = DBPool.getDBPool(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, international.getName());
			pstmt.setString(2, international.getFlag());
			pstmt.setString(3, international.getContent());
			pstmt.setInt(4, international.getGold());
			pstmt.setInt(5, international.getSilver());
			pstmt.setInt(6, international.getBronze());
			pstmt.setInt(7, international.getId());

			pstmt.executeUpdate();
		}
	}

	@Override
	public List<International> getRank() throws Exception {
		String sql = "SELECT * FROM olympic ORDER BY gold desc, silver desc, bronze desc, id desc";
		List<International> interList = new ArrayList<>();
		try (Connection conn = DBPool.getDBPool();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				International inter = new International(rs.getInt("id"), rs.getString("name"), rs.getString("flag"),
						rs.getString("content"), rs.getInt("gold"), rs.getInt("silver"), rs.getInt("bronze"));
				interList.add(inter);
			}
		}
		return interList;
	}

	@Override
	public International getInter(int id) throws Exception {
		String sql = "SELECT * FROM olympic WHERE id=?";
		International inter = null;
		try (
			Connection conn = DBPool.getDBPool(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				inter = new International(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("flag"),
						rs.getString("content"), 
						rs.getInt("gold"), 
						rs.getInt("silver"), 
						rs.getInt("bronze")
				);
			}
		}
		return inter;
	}

}
