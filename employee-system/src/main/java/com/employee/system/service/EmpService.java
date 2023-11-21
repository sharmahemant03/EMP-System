package com.employee.system.service;

import com.employee.system.entity.Employee;
import com.employee.system.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo repo;


    public void addEmp(Employee e){
        repo.save(e);


    }
    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }
    public Employee getEmployeeById(int id){
        Optional<Employee> e= repo.findById(id);
        if(e.isPresent()){
            return e.get();
        }
        return null;
    }


    public void deleteEmp(int id){
        repo.deleteById(id);
    }

}
