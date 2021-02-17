package com.WebFlux.reactiveflux.controller;

import com.WebFlux.reactiveflux.model.Employee;
import com.WebFlux.reactiveflux.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = {"/addEmployee"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id) {
        Mono<Employee> employee = employeeService.findById(id);
        HttpStatus status = employee != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Employee>>(employee, status);
    }

    @RequestMapping(value = "/baseLocation/{location}", method = RequestMethod.GET)
    public Flux<Employee> findByBaseLocation(@PathVariable("location") String location) {
        return employeeService.findByLocation(location);
    }

    @RequestMapping(value="/employeeDetails" ,method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> findAllEmployees() {
        Flux<Employee> employees = employeeService.findAll();
        return employees;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> update(@PathVariable int id, @RequestBody final Employee employeeDetails) {
        return employeeService.update(employeeDetails);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        employeeService.delete(id).subscribe();
    }
}
