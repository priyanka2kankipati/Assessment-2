package com.deloitte.deptempl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.deptempl.beans.Department;
import com.deloitte.deptempl.dao.impl.DeptEmplDaoImpl;
import com.deloitte.deptempl.doa.DeptEmplDao;

/**
 * Servlet implementation class GetDept
 */
@WebServlet("/GetDept")
public class GetDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		DeptEmplDao daodept=new DeptEmplDaoImpl();
		List<Department> deprt=daodept.getDept();
		for(Department d:deprt)
		{
			out.println("<tr>");
			out.println("<td>"+d.getDeptno()+"<td>");
			out.println("<td>"+d.getDname()+"<td>");
			out.println("<td>"+d.getLoc()+"<td>");
			out.println("<td>");
		}
		out.println("</table>");
		
	}

}
