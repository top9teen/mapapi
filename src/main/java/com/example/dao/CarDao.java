package com.example.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.CarBean;
import com.example.util.ConnectDB;



@Repository
public class CarDao {
	public String damoname(String mos) {

		return mos;
	}

	// list  for email
	public List<CarBean> findAll( String useremail){
		   List<CarBean> list = new ArrayList<>();
		   ConnectDB con = new ConnectDB();
			PreparedStatement prepared = null;
			StringBuilder sql = new StringBuilder();

			try {
				sql.append("  SELECT * FROM public.car WHERE user_email = ? ");
				prepared = con.openConnect().prepareStatement(sql.toString());
				prepared.setString(1,useremail);
				ResultSet rs = prepared.executeQuery();

				while (rs.next()) {
					CarBean bean = new CarBean();
					bean.setCarId(rs.getInt("car_id"));
					bean.setUseremail(rs.getString("user_email"));
					bean.setCarLat(rs.getString("car_lat"));
					bean.setCarLog(rs.getString("car_log"));
					bean.setCarAddress(rs.getString("car_address"));
					bean.setCarMid(rs.getInt("car_mid"));
					list.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		   return list ;
	   }
	//insert
	public void insert (CarBean bean) {
	    ConnectDB con = new ConnectDB();
 		PreparedStatement prepared = null;
 		StringBuilder sql = new StringBuilder();
 		
 	
 		try {
			sql.append(" INSERT INTO public.car (user_email,car_lat,car_log,car_address,car_mid) VALUES(?,?,?,?,?) "  );
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setString(1, bean.getUseremail());
			prepared.setString(2, bean.getCarLat());
			prepared.setString(3, bean.getCarLog());
			prepared.setString(4, bean.getCarAddress());
			prepared.setInt(5, bean.getCarMid());
		prepared.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	
}
	//list all
	   public List<CarBean> findAll(){
		   List<CarBean> list = new ArrayList<>();
		   ConnectDB con = new ConnectDB();
			PreparedStatement prepared = null;
			StringBuilder sql = new StringBuilder();

			try {
				sql.append(" SELECT * FROM public.car ");
				prepared = con.openConnect().prepareStatement(sql.toString());
				ResultSet rs = prepared.executeQuery();

				while (rs.next()) {
					CarBean bean = new CarBean();
					bean.setCarId(rs.getInt("car_id"));
					bean.setUseremail(rs.getString("user_email"));
					bean.setCarLat(rs.getString("car_lat"));
					bean.setCarLog(rs.getString("car_log"));
					bean.setCarAddress(rs.getString("car_address"));
					bean.setCarMid(rs.getInt("car_mid"));
					list.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		   return list;
	   }
	
	// End Class
}


/*CREATE TABLE car (
		 car_id serial PRIMARY KEY,
		  user_email VARCHAR (50) NOT NULL,
		 car_lat VARCHAR (50) NOT NULL,
		 car_log VARCHAR (50) NOT NULL,
		 car_address VARCHAR (50) NOT NULL,
		car_mid INTEGER NOT NULL
		) ;*/