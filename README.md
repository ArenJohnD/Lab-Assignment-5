You are required to present a department report that accesses CSV files. You must put the data on the domain composition of the objects.

![image](https://github.com/ArenJohnD/Lab-Assignment-5/assets/152838648/9c5997b7-4539-4cc2-be1d-8f301cea021c)

**dep.csv** contains the following:

deptCode, deptName, location
IT, Information Tech, 2nd floor
HR, Human Resource, 3rd floor
FNC, Finance, 4th floor

The **deptemp.csv** is referenced to get the salary  of the employees per department:

deptCode, empNo, salary
IT, E123, 30000
IT, E124, 45000
IT, E125, 51000
HR, E251, 66000
HR, E252, 25000
FNC, E370, 42000
FNC, E371, 29000
FNC, E372, 37000

To get the details of the employee you must access the **emp.csv**:

empNo, lastName, firstName, job
E123, Maxwell, John, Developer
E124, Delos Reyes, Ernesto, Analyst
E125, Ortiz, Manuel, Tester
E251, Natividad, Lisa, HR Manager
E252, Rosanto, Margareth, HR Specialist
E370, Baldo, Jason, Team Leader
E371, Hernandez, Timothy, Junior Accountant
E372, Cruz, Ricardo, CPA

You need to create objects that will handle the retrieval of the CSV files to convert them into objects.  These are EmployeeDA and EmployeeDA objects.  This will be the execution of the sequence:

![image](https://github.com/ArenJohnD/Lab-Assignment-5/assets/152838648/5d60205b-f5b5-438d-a3f9-66f864a84f3e)

## Sample Generated Report

**Department code: IT**  
**Department name:** Information Tech  
**Department total salary:** 126,000.00
```markdown
--------------------- Details -------------------------
      EmpNo      Employee Name            Salary
      E123       Maxwell, John            30,000.00
      E125       Ortiz, Manuel            51,000.00
      E124       Delos Reyes, Ernesto     45,000.00
```

**Department code:** HR  
**Department name:** Human Resource  
**Department total salary:** 91,000.00  
```markdown
--------------------- Details -------------------------
      EmpNo      Employee Name            Salary
      E252       Rosanto, Margareth       25,000.00
      E251       Natividad, Lisa          66,000.00
```
![image](https://github.com/ArenJohnD/Lab-Assignment-5/assets/152838648/a780bc45-5adb-4061-8e00-4ca62bb2a7f4)

**Department code: FNC**  
**Department name:** Finance  
**Department total salary:** 108,000.00
```markdown
--------------------- Details -------------------------
      EmpNo      Employee Name            Salary
      E370       Baldo, Jason             42,000.00
      E371       Hernandez, Timothy       29,000.00
      E372       Cruz, Ricardo            37,000.00
```
![image](https://github.com/ArenJohnD/Lab-Assignment-5/assets/152838648/e60b176a-0588-4b96-9956-f5586b17f4ac)


## Instructions
**1.** You are not allowed to alter the composition of domain objects. Stick to the provided design.
**2.** Adhere to correct naming conventions for variables and objects.
**3.** Use a hashmap as the solution for the problem.
**4.** Utilize `department.setDepTotalSalary()` to update aggregated values in the object.
**5.** Submit the GitHub solution link provided in NEUVLE.

