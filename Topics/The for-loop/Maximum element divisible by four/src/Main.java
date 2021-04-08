import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Введи кол-во цифр");
        int numberOfElements = scanner.nextInt();
        int maximum = 0;

        //System.out.println("Вводи цифры, их должно быть "+numberOfElements);
        for (int i = 1; i <= numberOfElements; i++) {

            int number = scanner.nextInt();

            if (number % 4 == 0 && number >= maximum) {
                maximum = number;
            }
        }

        System.out.println(maximum);
    }
}