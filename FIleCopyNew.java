import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;

public class FileCopyNew {
    static final Path LOG = Paths.get("log.txt");

    static void log(String pesan) throws IOException {
        Files.write(LOG, List.of(LocalDateTime.now() + " - " + pesan),
            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");
        try {
            Files.write(source, List.of("Report Generated", "Status: OK"));
            log("File report.txt ditulis");

            if (!Files.exists(source)) {
                log("GAGAL: report.txt tidak ditemukan");
                System.out.println("File sumber tidak ada.");
                return;
            }
            if (Files.notExists(backup.getParent()))
                Files.createDirectories(backup.getParent());

            Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
            log("Backup berhasil dibuat di " + backup);
            System.out.println("Backup created successfully!");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
