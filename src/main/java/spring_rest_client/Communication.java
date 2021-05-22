package spring_rest_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring_rest_client.entity.Employee;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8080/api/employees";

    public List<Employee> findAll() {

        ResponseEntity<List<Employee>> responseEntity =
                        restTemplate.exchange(
                        URL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Employee>>() {
        });

        return responseEntity.getBody();
    }

    public Employee findByID(Integer id) {

        Employee employee = restTemplate.getForObject(
                URL + "/" + id,
                Employee.class);

        return employee;
    }

    public void addOrUpdate(Employee employee) {

        Integer id = employee.getId();

        if (id == null) {
            ResponseEntity<String> responseEntity =
                            restTemplate.postForEntity(
                            URL,
                            employee,
                            String.class);
            System.out.println("New Employee was added in DataBase.");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID " + id + " was updated.");
        }
    }

    public void deleteByID(Integer id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with " + id + " was deleted from DataBase.");
    }
}
