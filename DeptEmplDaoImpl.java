package com.deloitte.deptempl.dao.impl;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.deptempl.beans.Department;
import com.deloitte.deptempl.doa.DeptEmplDao;
import com.deloitte.deptempl.utils.DeptEmplUtils;

import oracle.jdbc.OracleDriver;

	
	public class DeptEmplDaoImpl implements DeptEmplDao{
		
		private Connection conn=null;
		private PreparedStatement pst;
		private ResultSet rs;
		@Override
		public void openConnection() {
			try {
				DriverManager.registerDriver(new OracleDriver());
				String url ="jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String pass = "tiger";
				conn = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		@Override
		public void close() {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		@Override
		public int addDept(Department dept) {
			openConnection();
			int rows=0;
			try {
				pst = conn.prepareStatement(DeptEmplUtils.INSERTDEPT);
				pst.setInt(1,dept.getDeptno());
				pst.setString(2, dept.getDname());
				pst.setString(3, dept.getLoc());
				rows= pst.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("exception thrown");
			}
			finally{
				close();
			}
			return rows;
		}
		@Override
		public void deleteDept() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void updateDept() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public List<Department> getDept() {
			openConnection();
			List<Department> emplist = new ArrayList<Department>();
			try {
				pst = conn.prepareStatement(DeptEmplUtils.GETDEPT);
				rs = pst.executeQuery();
				while(rs.next()){
					Department emp = new Department(rs.getInt(1), rs.getString(2),rs.getString(3));
					emplist.add(emp);
				}
				System.out.println(emplist);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close();
			return emplist;
		}
		

	}


