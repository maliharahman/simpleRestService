package main;

import exception.ResourceNotFoundException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    public Map<String, Employee> employeeMap = new HashMap<>();

    //singleton to prevent instantiation directly
    private static EmployeeService instance = new EmployeeService();
    public static EmployeeService getInstance(){
        return instance;
    }

    /*
    Employee obj1 = new Employee("1", "Employee 01", "Description 01");
    Employee obj2 = new Employee("2", "Employee 02", "Description 02");
    Employee obj3 = new Employee("3", "Employee 03", "Description 03");
    */

    //private constructor
    private EmployeeService(){
        employeeMap.put("key1",  new Employee("1", "Employee 01", "Description 01"));
        employeeMap.put("key2",  new Employee("2", "Employee 02", "Description 02"));
        employeeMap.put("key3",  new Employee("3", "Employee 03", "Description 03"));
    }

    public String getId(String key){
        validateService(key);

        return employeeMap.get(key).getId();
    }

    public String[] getSubEntities(String key){
        validateService(key);

        return new String[] { employeeMap.get(key).getName(), employeeMap.get(key).getDescription() };
    }

    public Map<String, Employee> getData()
    {
        return employeeMap;
    }

    public void addEmployee(Employee employee){
        Random rand = new Random();
        int randomKey = rand.nextInt(10);

        employeeMap.put(Integer.toString(randomKey), employee);
    }

    public void updateEmployee(Employee employee, String key) {

        validateService(key);

        employeeMap.replace(key,employee);
    }

    public void deleteEmployee(String key) {
        employeeMap.remove(key);
    }

    public void validateService(String key){
        if(!employeeMap.containsKey(key)){
            throw new ResourceNotFoundException("User not found with key: " + key);
        }
    }
}
