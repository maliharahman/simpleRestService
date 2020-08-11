package main;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees/{key}")
    public String getId(@PathVariable String key){
        return employeeService.getId(key);
    }

    @RequestMapping("/employees/data/{key}")
    public String[] getSubEntities(@PathVariable String key){
        return employeeService.getSubEntities(key);
    }

    @RequestMapping("/employees")
    public Map<String, Employee> getData(){
        return employeeService.getData();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employees/{key}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable String key){
        employeeService.updateEmployee(employee, key);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{key}")
    public void deleteEmployee(@PathVariable String key){
        employeeService.deleteEmployee(key);
    }
}
