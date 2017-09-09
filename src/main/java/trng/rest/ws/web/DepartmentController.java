package trng.rest.ws.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.spring.beans.Department;
import com.imcs.spring.beans.Employee;

import trng.rest.ws.service.EmployeeService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employees/{deptNo}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getEmployee(@PathVariable int deptNo) {
		List<Employee> list = employeeService.getEmployeeByDeptNo(deptNo);
		if (list == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/{deptNo}", method = RequestMethod.GET)
	public ResponseEntity<?> getDept(@PathVariable int deptNo) {
		Department dept = employeeService.getDept(deptNo);
		if (dept == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(dept, HttpStatus.OK);
		}

	}

}
