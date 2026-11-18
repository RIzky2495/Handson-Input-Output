import java.io.IOException;
import java.nio.file.*;
import java.util.*;

interface CsvSerializable {
    String toCsv();
}

class Produk<T, U, V> implements CsvSerializable {
    private T nama;
    private U harga;
    private V stok;
    public Produk(T nama, U harga, V stok) { this.nama = nama; this.harga = harga; this.stok = stok; }
    public String toCsv() { return nama + "," + harga + "," + stok; }
    @Override public String toString() { return toCsv(); }
}

class Pelanggan implements CsvSerializable {
    private String nama, email;
    Pelanggan(String nama, String email) { this.nama = nama; this.email = email; }
    public String toCsv() { return nama + "," + email; }
}

class Transaksi implements CsvSerializable {
    private String id; private double total;
    Transaksi(String id, double total) { this.id = id; this.total = total; }
    public String toCsv() { return id + "," + total; }
}

class FileStore<T extends CsvSerializable> {
    private final Path path;
    FileStore(String file) { this.path = Paths.get(file); }

    void save(List<T> items) throws IOException {
        List<String> lines = new ArrayList<>();
        for (T item : items) lines.add(item.toCsv());
        Files.write(path, lines);
    }
    List<String> load() throws IOException { return Files.readAllLines(path); }
}

public class ProdukWriterNew {
    public static void main(String[] args) {
        List<Produk<String, Double, Integer>> produkList = new ArrayList<>();
        produkList.add(new Produk<>("Laptop", 15000000.0, 10));
        produkList.add(new Produk<>("Mouse", 150000.0, 50));
        produkList.add(new Produk<>("Keyboard", 350000.0, 25));

        try {
            FileStore<Produk<String, Double, Integer>> store = new FileStore<>("produk_output.txt");
            store.save(produkList);
            System.out.println("Data produk berhasil disimpan menggunakan NIO.2");

            System.out.println("Isi file:");
            for (String line : store.load()) System.out.println(line);

            // Jenis data lain dengan kelas generic yang sama
            new FileStore<Pelanggan>("pelanggan.txt")
                .save(List.of(new Pelanggan("Andi", "andi@mail.com")));
            new FileStore<Transaksi>("transaksi.txt")
                .save(List.of(new Transaksi("TRX001", 15150000.0)));
        } catch (IOException e) {
            System.out.println("Gagal memproses file: " + e.getMessage());
        }
    }
}
