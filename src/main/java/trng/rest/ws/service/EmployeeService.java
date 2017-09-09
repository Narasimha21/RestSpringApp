package trng.rest.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imcs.spring.beans.Department;
import com.imcs.spring.beans.Employee;
import com.imcs.spring.dao.EmployeeDaoInterface;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeDaoInterface edao;

	List<Department> deptList = new ArrayList<>();

	public List<Department> getDeptList() {
		deptList.add(new Department(10, "Finance"));
		deptList.add(new Department(20, "Operations"));
		deptList.add(new Department(30, "Account"));
		return deptList;

	}

	public Department getDept(int deptNo) {
		deptList = getDeptList();
		for (Department d : deptList) {
			if (d.getDeptNo() == deptNo) {
				return d;
			}
		}

		return null;

	}

	public List<Employee> getEmployeeByDeptNo(int deptNo) {
		return edao.getEmployeeByDeptNo(deptNo);
	}

	public void deleteEmployee(int empNo) {

		edao.deleteEmployee(empNo);
	}

	public void updateEmployee(Employee employee) {

		edao.updateEmployee(employee);
	}

	public Employee getEmployee(int empNo) {
		return edao.getEmployee(empNo);

	}

	public int addEmployee(Employee employee) {
		return edao.addEmployee(employee);
	}
}
