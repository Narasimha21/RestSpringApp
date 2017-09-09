package trng.rest.ws.service;

import java.util.List;

import com.imcs.spring.beans.Department;
import com.imcs.spring.beans.Employee;

public interface IEmployeeService {
	public List<Department> getDeptList();

	public Department getDept(int deptNo);

	public List<Employee> getEmployeeByDeptNo(int deptNo);

	public void deleteEmployee(int empNo);

	public void updateEmployee(Employee employee);

	public Employee getEmployee(int empNo);

	public int addEmployee(Employee employee);
}
