package com.deloitte.deptempl.utils;

public class DeptEmplUtils {

	public static final String INSERTDEPT = "insert into dept values(?,?,?)";
	public static final String GETDEPT = "select * from dept ";
	public static final String UPDATEDEPT = "update dept set dname=?, loc=? where deptno=?";
	public static final String DELETEDEPT = "delete from dept where deptno=?";
	
	public static String INSERTEMP="insert into emp values(?,?,?,?,?,?,?,?)";
	public static final String GETEMPLS = "select * from emp";
	public static final String GETEMPlBYCODE = "select * from emp where empno=?";
	public static final String updateqry="update emp set ename=?, job=? where empno=?";
	public static final String deleteqry="delete from emp where empno=?";

}
