import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int countA = 0; //5
        int countB = 0; //4
        int countC = 0; //3
        int countD = 0; //2

        for (int i = 0; i < n; i++) {
            int grades = sc.nextInt();
            switch (grades) {
                case 5:
                    countA++;
                    break;
                case 4:
                    countB++;
                    break;
                case 3:
                    countC++;
                    break;
                case 2:
                    countD++;
                    break;
                default:
                    break;
            }
        }
        System.out.println(countD + " " + countC + " " + countB + " " + countA);
    }
}