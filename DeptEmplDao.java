package com.deloitte.deptempl.doa;

import java.util.List;

import com.deloitte.deptempl.beans.Department;

public interface DeptEmplDao {
	void openConnection();
	void close();
	
	int addDept(Department dept);
	void deleteDept();
	void updateDept();
	List<Department> getDept();
	
}
