package spring_rest_client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_rest_client.configuration.MyConfig;
import spring_rest_client.entity.Employee;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        // findAllEmployee
        // communication.findAll().forEach(System.out::println);

        // findByIDEmployee
        // Employee employee = communication.findByID(10);
        // System.out.println(employee);

        // AddAndUpdateEmployee
        // Employee employee = new Employee("Svetlana", "Parker", "HR", 65000);
        // employee.setId(16); | for update
        // communication.addOrUpdate(employee);

        // DeleteEmployeeByID
        // communication.deleteByID(16);
    }
}
