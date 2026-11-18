public class Cell<T> {
    private T data;
    public void setValue(T data) { this.data = data; }
    public T getValue() { return data; }

    public void displayType() {
        System.out.println(data == null ? "Tipe: (null)"
            : "Tipe: " + data.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Cell<Integer> angka = new Cell<>();
        angka.setValue(100);
        Cell<String> teks = new Cell<>();
        teks.setValue("Halo");
        angka.displayType();   // Integer
        teks.displayType();    // String
        // angka.setValue("Halo"); // error kompilasi
        int x = angka.getValue(); // tanpa casting
    }
}