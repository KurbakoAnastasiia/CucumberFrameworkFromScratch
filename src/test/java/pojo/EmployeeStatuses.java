package pojo;

import java.util.List;

public class EmployeeStatuses {
    private List<String> employeeStatusList;

    public List<String> getEmployeeStatusList() {
        return employeeStatusList;
    }

    public void setEmployeeStatusList(List<String> employeeStatusList) {
        this.employeeStatusList = employeeStatusList;
    }

    @Override
    public String toString() {
        return "EmployeeStatuses{" +
                "employeeStatusList=" + employeeStatusList +
                '}';
    }
}
