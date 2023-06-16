package springboot.service;

import java.util.List;

import springboot.model.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updatEmployee(Employee employee, long id);
    void deleteEmployee(long id);
    
}
