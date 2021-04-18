package pojo;

import java.util.List;

public class GetOneEmployeeBody {
    private List<EmployeeBody> employee;

    public List<EmployeeBody> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeBody> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "GetOneEmployeeBody{" +
                "employee=" + employee +
                '}';
    }
}
