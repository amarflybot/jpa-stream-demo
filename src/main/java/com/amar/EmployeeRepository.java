package com.amar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.stream.Stream;

/**
 * Created by amarendra on 5/12/16.
 */
@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @RestResource(path = "findAllByEmployeeQueryAndStream")
    @Query("select u from Employee u")
    Stream<Employee> findAllByEmployeeQueryAndStream();

}
