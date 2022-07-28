package com.app.nba.model.user;

import com.app.nba.utils.DBUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	static DBUtils dbUtils = new DBUtils();
	
	public int isUserExists(String id, String pwd) {
		String query = "SELECT COUNT(*) as count FROM n_member WHERE user_id = '" + id + "' AND user_pwd = '" + pwd + "'";
		System.out.println("<DAO> query : " + query + " id : " + id);
		try(
				PreparedStatement pstmt = dbUtils.getConnection(query);
				ResultSet rs =  pstmt.executeQuery();
		) {
			int result = 0;
			while(rs.next()) {
				System.out.println("<DAO> isUserExists count : " + rs.getInt("count"));
				if(rs.getInt("count") > 0) {
					result++;
				}
			}
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int register(MemberVO vo) {
		int result = 0;
		String id = vo.getId();
		String pwd = vo.getPwd();
		String name = vo.getName();

		String query = "INSERT INTO n_member VALUES('" + id + "', '" + pwd + "', '" + name + "', now())";
		try(
				PreparedStatement pstmt = dbUtils.getConnection(query);
		) {
			result = pstmt.executeUpdate();
			System.out.println("MemberDAO register result : " + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int isIDExists(String id) {
		String query = "SELECT COUNT(*) AS count FROM n_member WHERE user_id = '" + id + "'";
		try(
				PreparedStatement pstmt = dbUtils.getConnection(query);
				ResultSet rs = pstmt.executeQuery();
		) {
			int result = 0;
			
			while(rs.next()) {
				System.out.println("<DAO> isIDExists count : " + rs.getInt("count"));
				if(rs.getInt("count") > 0) {
					result++;
				}
			}
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int update(String id, String pwd) {
		int result = 0;
		String query = "UPDATE n_member SET user_pwd = '" + pwd + "' WHERE user_id = '" + id + "'";
		try(
				PreparedStatement pstmt = dbUtils.getConnection(query);
		) {
			result = pstmt.executeUpdate();
			System.out.println("MemberDAO update result : " + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
