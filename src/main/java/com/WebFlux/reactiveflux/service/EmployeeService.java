package com.WebFlux.reactiveflux.service;

import com.WebFlux.reactiveflux.model.Employee;
import com.WebFlux.reactiveflux.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepo;

    public void create(Employee employee) {
        employeeRepo.save(employee).subscribe();
    }

    public Mono<Employee> findById(Integer id) {
        return employeeRepo.findById(id);
    }

    public Flux<Employee> findByLocation(String location) {
        return employeeRepo.findByLocation(location);
    }

    public Flux<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Mono<Employee> update(Employee emp) {
        return employeeRepo.save(emp);
    }

    public Mono<Employee> update(int id,Employee employeeDetails) {
        Mono<Employee> employee = employeeRepo.findById(id);
        return employeeRepo.save(employeeDetails);
    }

    public Mono<Void> delete(Integer id) {
        return employeeRepo.deleteById(id);
    }
}
