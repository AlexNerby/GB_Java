public class Employee {
    private String fullName;
    private String position;
    private String email;
    private long telephoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, long telephoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Employee information:");
        System.out.println("Full Name: " + fullName);
        System.out.println("Position: " + position);
        System.out.println("Telephone number: " + telephoneNumber);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
    }
    public int getAge() {
        return age;
    }
}
