package labAss5;

import java.io.FileNotFoundException;

import java.io.FileNotFoundException;

public class DepartmentReport {
    public DepartmentReport() throws FileNotFoundException {
        DepartmentDA departmentDA = new DepartmentDA();
    }

    public static void main(String[] args) {
        try {
            new DepartmentReport();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
