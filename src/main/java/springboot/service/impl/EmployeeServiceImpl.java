package springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springboot.exception.ResourceNotFoundException;
import springboot.model.Employee;
import springboot.repository.EmployeeRepository;
import springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeById(long id) {
        // Optional<Employee> employee = employeeRepository.findById(id);
        // // if(employee.isPresent()){
        // //     employee.get();
        // // }else{
        // //     throw new ResourceNotFoundException("Employee", "id", id);
        // // }


        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));

    }


    @Override
    public Employee updatEmployee(Employee employee, long id) {
        //checking the employee exisits
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        //save existing to database

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }


    @Override
    public void deleteEmployee(long id) {

        //checking the employee exisits
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));


        employeeRepository.deleteById(id);
    }
    
}
