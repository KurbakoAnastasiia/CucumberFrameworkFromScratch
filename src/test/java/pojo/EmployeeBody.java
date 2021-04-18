package pojo;

public class EmployeeBody {
    private String employee_id;
    private String emp_firstname;
    private String emp_middle_name;
    private String emp_lastname;
    private String emp_birthday;
    private String emp_gender;
    private String emp_job_title;
    private String emp_status;

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmp_firstname() {
        return emp_firstname;
    }

    public void setEmp_firstname(String emp_firstname) {
        this.emp_firstname = emp_firstname;
    }

    public String getEmp_middle_name() {
        return emp_middle_name;
    }

    public void setEmp_middle_name(String emp_middle_name) {
        this.emp_middle_name = emp_middle_name;
    }

    public String getEmp_lastname() {
        return emp_lastname;
    }

    public void setEmp_lastname(String emp_lastname) {
        this.emp_lastname = emp_lastname;
    }

    public String getEmp_birthday() {
        return emp_birthday;
    }

    public void setEmp_birthday(String emp_birthday) {
        this.emp_birthday = emp_birthday;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public String getEmp_job_title() {
        return emp_job_title;
    }

    public void setEmp_job_title(String emp_job_title) {
        this.emp_job_title = emp_job_title;
    }

    public String getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status;
    }

    @Override
    public String toString() {
        return "EmployeeBody{" +
                "employee_id='" + employee_id + '\'' +
                ", emp_firstname='" + emp_firstname + '\'' +
                ", emp_middle_name='" + emp_middle_name + '\'' +
                ", emp_lastname='" + emp_lastname + '\'' +
                ", emp_birthday='" + emp_birthday + '\'' +
                ", emp_gender='" + emp_gender + '\'' +
                ", emp_job_title='" + emp_job_title + '\'' +
                ", emp_status='" + emp_status + '\'' +
                '}';
    }
}
