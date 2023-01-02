package com.ema.controller;

import com.ema.domain.Employee;
import com.ema.dto.EmployeeDTO;
import com.ema.dto.response.EMAResponse;
import com.ema.dto.response.ResponseMessage;
import com.ema.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //http://localhost:8080/employee/add
    @PostMapping("/add")
    public ResponseEntity<EMAResponse> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
      employeeService.saveEmployee(employeeDTO);

      EMAResponse emaResponse = new EMAResponse();
      emaResponse.setMessage(ResponseMessage.EMPLOYEE_SAVE_RESPONSE_MESSAGE);
      emaResponse.setSuccess(true);

      return ResponseEntity.ok(emaResponse);
    }

    //http://localhost:8080/employee/1
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id){
       EmployeeDTO result = employeeService.getEmployeeById(id);
       return ResponseEntity.ok(result);
    }

    //http://localhost:8080/employee
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployee(){
       List<EmployeeDTO> result= employeeService.getAllEmployees();
       return ResponseEntity.ok(result);
    }
}
