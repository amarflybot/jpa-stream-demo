package com.amar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

/**
 * Created by amarendra on 5/12/16.
 */
@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public Stream<Employee> getEmployeeAsStream(){
        Stream<Employee> stream = employeeRepository.findAllByEmployeeQueryAndStream();
        return stream;
    }
}
