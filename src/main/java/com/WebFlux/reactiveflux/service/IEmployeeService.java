package com.WebFlux.reactiveflux.service;

import com.WebFlux.reactiveflux.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
        void create(Employee employee);

        Mono<Employee> findById(Integer id);

        Flux<Employee> findByLocation(String name);

        Flux<Employee> findAll();

        Mono<Employee> update(Employee emp);

        Mono<Void> delete(Integer id);

}
