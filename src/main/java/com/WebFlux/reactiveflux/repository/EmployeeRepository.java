package com.WebFlux.reactiveflux.repository;

import com.WebFlux.reactiveflux.model.Employee;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {

    @Query("{ 'baseLocation': ?0 }")
    Flux<Employee> findByLocation(String location);
}
