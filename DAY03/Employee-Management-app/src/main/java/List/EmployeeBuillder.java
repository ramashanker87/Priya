package List;



public class EmployeeBuilder {
    private String name;
    private int age;
    private String company;
    private String id;
    private int salary;

    public EmployeeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public EmployeeBuilder setCompany(String company) {
        this.company = company;
        return this;
    }

    public EmployeeBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder setSalary(int salary) {
        this.salary = salary;
        return this;
    }
}
public class ListEmployee {
    public static void main(String[] args) {

        List<EmployeeBuilder> empList = new ArrayList<>();

        empList.add(new Employee("a", 21, "abc", "x", 50000));
        empList.add(new Employee("b", 25, "abc", "x", 21000));
        empList.add(new Employee("c", 30, "abc", "x", 55000));
        empList.add(new Employee("d", 35, "abc", "x", 35000));

        System.out.println("Employee Salary Greater than 50000");
        List<EmployeeBuilder> == Salary()>50000);
        empList.print();

        System.out.println("Employee age less than 30");
        List<EmployeeBuilder> == Age()>30);
        empList.print();


        System.out.println("Employee details whose salary is greater than 40000");
        empList.stream().filter(e -> e.getSalary() > 40000).collect(Collectors.toList()).
                forEach(System.out::println);

        System.out.println("Employee details whose age is greater than 25");
        empList.stream().filter(e -> e.getAge() > 25).collect(Collectors.toList()).
                forEach(System.out::println);
    }
}


