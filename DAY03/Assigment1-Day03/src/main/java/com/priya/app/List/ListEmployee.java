package List;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ListEmployee {
    public static void main(String[] args) {
        List<Employee> employeeList = new CopyOnWriteArrayList<>();
        Employee emp1 = new Employee("Bala", 21, "ABC", "1", 50000);
        Employee emp2 = new Employee("Dakshan", 30, "ABC", "2", 35000);
        Employee emp3 = new Employee("Raj", 26, "ABC", "3", 60000);
        Employee emp4 = new Employee("selvi", 49, "ABC", "4", 20000);
        Employee emp5 = new Employee("ManO", 50, "ABC", "5", 25000);
        Employee emp6 = new Employee("liya", 23, "ABC", "6", 45000);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);
        employeeList.add(emp6);
        for (Employee employee : employeeList) {
            employee.print();

        }
        System.out.println("Employee Salary greater than 50000");

        for (Employee ep: employeeList) {
            if (ep.getSalary() > 50000) {
                employeeList.add(ep);
                ep.print();


            }}

        System.out.println("Employee Age less than 30");

        for (Employee ep: employeeList) {
            if (ep.getAge() < 30) {
                employeeList.add(ep);
                ep.print();


            }}

        System.out.println("Employee salary less than 40000");
        List<Employee> salary40000 = employeeList.stream()
                .filter(employee -> employee.getSalary() < 40000)
                .collect(Collectors.toList());
        for (Employee e : salary40000) {
            e.print();
        }


        System.out.println("Employee Age Greater than 25");
        List<Employee> Age25 = employeeList.stream()
                .filter(employee -> employee.getAge() > 25)
                .collect(Collectors.toList());
        for (Employee e : Age25) {
            e.print();
        }




    }}











