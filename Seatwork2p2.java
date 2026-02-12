// Parent Class (Base Class)
//SEATWORK2 PART2 SEM2
class Person {
    
    // Encapsulated variables (private)
    private String name;
    private int age;

    // Setters (Write data)
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            this.age = 0; // validation
        }
    }

    // Getters (Read data)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Child Class (Derived Class)
// Inheritance: Student inherits Person
class Student extends Person {

    private String strand;

    // Setter and Getter for new variable
    public void setStrand(String strand) {
        this.strand = strand;
    }

    public String getStrand() {
        return strand;
    }

    // Responsive method (easy to modify)
    public void displayInfo() {
        System.out.println("------ Student Information ------");
        System.out.println("Name   : " + getName());
        System.out.println("Age    : " + getAge());
        System.out.println("Strand : " + getStrand());
        System.out.println("----------------------------------");
    }
}

// Main Class
public class Seatwork2p2 {
    public static void main(String[] args) {
        // Create object of child class (Student)
        Student s = new Student();

        // Using setters from Person (inherited)
        s.setName("Tam");
        s.setAge(16 );

        // Using setter from Student
        s.setStrand("ICT");

        // Display all data
        s.displayInfo();
    }
}
