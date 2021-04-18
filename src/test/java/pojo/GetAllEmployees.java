package pojo;

import java.util.List;

public class GetAllEmployees {
    private String totalEmployees;
    private List<EmployeeBody> employees;

    public String getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(String totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public List<EmployeeBody> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBody> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "GetAllEmployees{" +
                "totalEmployees='" + totalEmployees + '\'' +
                ", employees=" + employees +
                '}';
    }
}
