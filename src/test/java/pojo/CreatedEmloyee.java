package pojo;

import java.util.List;

public class CreatedEmloyee {
    private String message;
    private List<EmployeeBody> employee;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<EmployeeBody> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeBody> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "CreateEmployeeResponse{" +
                "message='" + message + '\'' +
                ", employee=" + employee +
                '}';
    }
}
