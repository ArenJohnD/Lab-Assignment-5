import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepartmentDA {
    private HashMap<String, Employee> employeeMap;

    public DepartmentDA() throws FileNotFoundException {
        String departmentFilePath = "C:\\Users\\arene\\eclipse-workspace\\LabAssignment5\\src\\labAss5\\dep.csv";
        String deptEmpFilePath = "C:\\Users\\arene\\eclipse-workspace\\LabAssignment5\\src\\labAss5\\deptemp.csv";

        employeeMap = new HashMap<>();
        try (Scanner deptFile = new Scanner(new FileReader(departmentFilePath))) {
            deptFile.nextLine(); // Skip header
            while (deptFile.hasNext()) {
                String[] depRowSpecific = deptFile.nextLine().split(",");
                Department department = createDepartment(depRowSpecific);
                addEmployeesToDepartment(department, deptEmpFilePath);
                printDepartment(department);
            }
        }
    }

    private Department createDepartment(String[] depRowSpecific) {
        Department department = new Department();
        department.setDepCode(depRowSpecific[0]);
        department.setDepName(depRowSpecific[1].trim());
        return department;
    }

    private void addEmployeesToDepartment(Department department, String deptEmpFilePath) throws FileNotFoundException {
        try (Scanner deptEmpFile = new Scanner(new FileReader(deptEmpFilePath))) {
            employeeMap.clear(); // Clear the employee map for the department
            deptEmpFile.nextLine(); // Skip header
            int key = 0;
            while (deptEmpFile.hasNext()) {
                String[] deptEmpRowSpecific = deptEmpFile.nextLine().split(",");
                if (department.getDepCode().equals(deptEmpRowSpecific[0].trim())) {
                    EmployeeDA employeeDA = new EmployeeDA(deptEmpRowSpecific[1].trim(), Double.parseDouble(deptEmpRowSpecific[2].trim()));
                    employeeMap.put(deptEmpRowSpecific[1].trim() + key, employeeDA.getEmployee());
                    key++;
                }
            }
        }
    }

    private void printDepartment(Department department) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        System.out.println("Department code: " + department.getDepCode());
        System.out.println("Department name: " + department.getDepName());
        System.out.println("Department total salary: " + df.format(calculateTotalSalary(department)));
        System.out.println("--------------------- Details -------------------------");
        System.out.printf("%-15s %-25s %5s%n", "EmpNo", "Employee Name", "Salary");
        
        for (Map.Entry<String, Employee> entry : employeeMap.entrySet()) {
            Employee employee = entry.getValue();
            System.out.printf("%-15s %-25s %s%n",
                employee.getEmpNo(),
                employee.getLastName() + "," + employee.getFirstName(),
                df.format(employee.getSalary()));
        }
        
        System.out.println();
    }

    private double calculateTotalSalary(Department department) {
        return employeeMap.values().stream().mapToDouble(Employee::getSalary).sum();
    }
}
