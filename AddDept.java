package com.deloitte.deptempl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.deptempl.beans.Department;
import com.deloitte.deptempl.dao.impl.DeptEmplDaoImpl;
import com.deloitte.deptempl.doa.DeptEmplDao;

/**
 * Servlet implementation class AddDept
 */
@WebServlet("/AddDept")
public class AddDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		//retreiving data from html page
		int deptNo=Integer.parseInt(request.getParameter("deptno"));
		String deptName=request.getParameter("deptname");
		String location=request.getParameter("location");
		
		//pass the received vales from html to Department class constructor
		Department dept=new Department(deptNo,deptName,location);
		
		//create object for DeptEmplDaoImpl class
		DeptEmplDao deptemp=new DeptEmplDaoImpl();
		
		//function call to addDept()
		int rows=deptemp.addDept(dept);
		if(rows>0)
			out.println("inserted");
		else
			out.println("not inserted");
		
	}

}
