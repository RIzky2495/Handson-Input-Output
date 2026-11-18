import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    Employee(String n, int a) { name = n; age = a; }
}

public class SerializeDemo {
    static void serialize(Employee e, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(e);
            System.out.println("Serialized: " + e.name);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static Employee deserialize(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Employee) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        List<Employee> list = List.of(
            new Employee("John", 30), new Employee("Siti", 27), new Employee("Budi", 35));

        int i = 1;
        for (Employee e : list) serialize(e, "emp" + (i++) + ".ser");

        for (int j = 1; j <= list.size(); j++) {
            Employee r = deserialize("emp" + j + ".ser");
            if (r != null) System.out.println("Deserialized: " + r.name + ", " + r.age);
        }
    }
}
