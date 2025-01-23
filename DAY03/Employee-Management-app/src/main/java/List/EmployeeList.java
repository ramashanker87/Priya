package List;

import java.util.stream.Collectors;

public class EmployeeList {
    public static void main(String[] args) {
        List<EmployeeList> Employee=new ArrayList<>();
        EmployeeList emp1= new emp("1",31,"abc","1","55000");
        EmployeeList emp2= new emp("2",25,"abc","2","21000");
        EmployeeList emp3= new emp("3",55,"abc","3","60000");
        EmployeeList emp4= new emp("4",23,"abc","4","75000");
        EmployeeList emp5= new emp("5",27,"abc","5","850000");
        Employee.add(emp1);
        Employee.add(emp2);
        Employee.add(emp3);
        Employee.add(emp4);
        Employee.add(emp5);

        for (EmployeeList employee : Employee) {
            employee.print();
        }
        System.out.println("employee salary Greater than 50000");
        List<EmployeeList> emp50000greater_less30age =Employee.stream()
                .filter((emp -> employee.getSalary()>50000) & (employee.getAge()<30))
                .collect(Collectors.toList());
        for (EmployeeList employee :emp50000greater_less30age ) {
            employee.print();
        }
    }
}
