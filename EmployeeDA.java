import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDA {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeDA(String empNo, Double salary) throws FileNotFoundException {
        String employeeFilePath = "emp.csv";

        try (Scanner employeeFile = new Scanner(new FileReader(employeeFilePath))) {
            employeeFile.nextLine(); // Skip header
            while (employeeFile.hasNext()) {
                String[] employeeRowSpecific = employeeFile.nextLine().split(",");
                if (empNo.equals(employeeRowSpecific[0].trim())) {
                    createEmployee(employeeRowSpecific, salary);
                    break; // Break loop after finding the employee
                }
            }
        }
    }

    private void createEmployee(String[] employeeRowSpecific, Double salary) {
        employee = new Employee();
        employee.setEmpNo(employeeRowSpecific[0]);
        employee.setLastName(employeeRowSpecific[1].trim());
        employee.setFirstName(employeeRowSpecific[2]);
        employee.setSalary(salary);
    }
}
