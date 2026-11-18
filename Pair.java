public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) { this.first = first; this.second = second; }

    public void showTypes() {
        System.out.println(first.getClass().getName() + " & " + second.getClass().getName());
    }

    // Tipe berbeda, sehingga swap menghasilkan Pair baru dengan tipe terbalik
    public Pair<T2, T1> swap() { return new Pair<>(second, first); }

    @Override
    public String toString() { return "(" + first + ", " + second + ")"; }

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(90, "Andi");
        Pair<Double, Boolean> p2 = new Pair<>(3.14, true);
        p1.showTypes();
        p2.showTypes();
        System.out.println(p1 + " -> swap -> " + p1.swap());
        System.out.println(p2 + " -> swap -> " + p2.swap());
    }
}