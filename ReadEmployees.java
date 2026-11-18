import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class ReadEmployees {
    public static void main(String[] args) {
        Path path = Paths.get("employees.txt");

        if (Files.notExists(path)) {
            System.out.println("File tidak ditemukan: " + path.toAbsolutePath());
            return;
        }

        List<String> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                data.add(line);
            }
            Files.write(Paths.get("copy_employees.txt"), data);
            System.out.println("Disalin ke copy_employees.txt (" + data.size() + " baris)");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
