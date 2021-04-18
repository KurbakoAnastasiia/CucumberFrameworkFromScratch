package utils;

import pojo.NewEmployee;
import pojo.User;

public class APIPayloadConstants {

    public static User userToGenerateToken() {
        User user = new User();
        user.setEmail("anastasia@gmail.com");
        user.setPassword("123456789");
        return user;
    }


    public static NewEmployee newEmployeePayload() {
        NewEmployee newEmployee = new NewEmployee();
        newEmployee.setEmp_firstname("Anastasiia");
        newEmployee.setEmp_lastname("Zaiceva");
        newEmployee.setEmp_middle_name("K");
        newEmployee.setEmp_gender("F");
        newEmployee.setEmp_birthday("1986-02-18");
        newEmployee.setEmp_status("Employee");
        newEmployee.setEmp_job_title("IT Analyst");
        return newEmployee;
    }
}
