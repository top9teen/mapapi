package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.MemberBean;
import com.example.util.ConnectDB;




@Repository
public class MemberDao {

	public MemberBean meber(String memberUsername, String memberPassword) {
		
		MemberBean bean = new MemberBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		
		
		try {
			sql.append(" SELECT * FROM  public.member WHERE mem_username = ? AND mem_password = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setString(1,memberUsername);
			prepared.setString(2,memberPassword);

			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setMemUsername(rs.getString("mem_username"));
				bean.setMemPassword(rs.getString("mem_password"));
			}
		
		
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		return bean ;
		
	}

	  public List<MemberBean> findAll(){
		   List<MemberBean> list = new ArrayList<>();
		   ConnectDB con = new ConnectDB();
			PreparedStatement prepared = null;
			StringBuilder sql = new StringBuilder();

			try {
				sql.append(" SELECT * FROM public.member ");
				prepared = con.openConnect().prepareStatement(sql.toString());
				ResultSet rs = prepared.executeQuery();

				while (rs.next()) {
					MemberBean bean = new MemberBean();
					bean.setMemId(rs.getInt("mem_id"));
					bean.setMemUsername(rs.getString("mem_username"));
					bean.setMemPassword(rs.getString("mem_password"));
					list.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		   return list;
	   }
	

// End Class
}

