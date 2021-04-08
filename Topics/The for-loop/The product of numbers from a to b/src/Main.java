import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long result = 1;

        for (long i = a; i < b; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}