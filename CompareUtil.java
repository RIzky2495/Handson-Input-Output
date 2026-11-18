public class CompareUtil {
    public static <T extends Comparable<T>> boolean isEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEqual(5, 5));            // true
        System.out.println(isEqual("Hello", "World")); // false
        System.out.println(isEqual(3.14, 3.14));      // true
        System.out.println(isEqual(2.5, 3.5));        // false (Double)
        System.out.println(isEqual('A', 'A'));        // true (Character)
        System.out.println(isEqual('A', 'B'));        // false (Character)
    }
}