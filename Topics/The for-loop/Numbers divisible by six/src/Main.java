import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Вводи кол-во цифр");
        int numberOfnumbers = sc.nextInt();
        int sum = 0;

        //System.out.println("Вводи " + numberOfnumbers + " чисел");
        for (int i = 0; i < numberOfnumbers; i++) {
            int inputNumber = sc.nextInt();
            if (inputNumber % 6 == 0) {
                sum = sum + inputNumber;
            }
        }
        System.out.println(sum);
    }
}
