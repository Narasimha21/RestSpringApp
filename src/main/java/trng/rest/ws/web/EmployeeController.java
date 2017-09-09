package trng.rest.ws.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.spring.beans.Employee;

import trng.rest.ws.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/{empNo}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> deleteEmployee(@PathVariable int empNo) {
		try {
			employeeService.deleteEmployee(empNo);
			return new ResponseEntity<>(empNo, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{empNo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<?> getEmployee(@PathVariable int empNo) {

		Employee employee = employeeService.getEmployee(empNo);
		if (employee == null) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {

		int empNo = employeeService.addEmployee(employee);
		employee.setEmpNo(empNo);
		if (empNo < 1) {
			return ResponseEntity.noContent().build();
		} else {

			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			employeeService.updateEmployee(employee);
			return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
