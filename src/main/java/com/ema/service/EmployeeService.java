package com.ema.service;

import com.ema.domain.Employee;
import com.ema.dto.EmployeeDTO;
import com.ema.exception.ResourceNotFoundException;
import com.ema.exception.message.ErrorMessage;
import com.ema.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employeeRepository.save(employee);
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = getById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        return employeeDTO;
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();

//        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

//        for (Employee employee: employeeList) {
//            EmployeeDTO employeeDTO = new EmployeeDTO();
//            employeeDTO.setFirstName(employee.getFirstName());
//            employeeDTO.setLastName(employee.getLastName());
//            employeeDTO.setEmail(employee.getEmail());
//
//            employeeDTOList.add(employeeDTO);
//        }
        return employeeList;
    }

    public void updateEmployee(Long id,EmployeeDTO employeeDTO){
        Employee employee = getById(id);
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employeeRepository.save(employee);
    }

    public Employee getById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessage.EMPLOYEE_NOT_FOUND_MESSAGE,id)));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
