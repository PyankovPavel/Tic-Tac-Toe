package tictactoe;

import java.util.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static String input = "         ";
    public static boolean isFinished = true;
    public static int count = 0;

    public static void printArray(char[][] array) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|" + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static void xMoves(char[][] array) {
        System.out.println("Enter the coordinates:");
        if (sc.hasNextInt()) {
            int coordA = sc.nextInt();
            int coordB = sc.nextInt();
            if (coordA < 4 && coordB < 4 && coordA > 0 && coordB > 0) {
                OUTER:
                for (int i = 0; i < 3; i++) {
                    INNER:
                    for (int j = 0; j < 3; j++) {
                        if (array[coordA - 1][coordB - 1] == ' ') {
                            array[coordA - 1][coordB - 1] = 'X';
                            printArray(array);
                            break OUTER;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            xMoves(array);
                            break OUTER;
                        }
                    }
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
                xMoves(array);
            }
        } else {
            System.out.println("You should enter numbers!");
            sc.nextLine();
            xMoves(array);
        }
        count++;
        checking(array);
    }

    public static void oMoves(char[][] array) {
        System.out.println("Enter the coordinates:");
        if (sc.hasNextInt()) {
            int coordA = sc.nextInt();
            int coordB = sc.nextInt();
            if (coordA < 4 && coordB < 4 && coordA > 0 && coordB > 0) {
                OUTER:
                for (int i = 0; i < 3; i++) {
                    INNER:
                    for (int j = 0; j < 3; j++) {
                        if (array[coordA - 1][coordB - 1] == ' ') {
                            array[coordA - 1][coordB - 1] = 'O';
                            printArray(array);
                            break OUTER;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            oMoves(array);
                            break OUTER;
                        }
                    }
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
                oMoves(array);
            }
        } else {
            System.out.println("You should enter numbers!");
            sc.nextLine();
            oMoves(array);
        }
        count++;
        checking(array);
    }

    public static void checking(char[][] array) {
        String check = Arrays.deepToString(array).replaceAll("\\[", "")
                .replaceAll("\\]", "").replaceAll(",", "");
        int xWins = 0;
        int oWins = 0;
        // diagonal lines
        if (check.charAt(0) == 'X' && check.charAt(0) == check.charAt(8)) {
            if (check.charAt(0) == check.charAt(16)) {
                xWins++;
            }
        }
        if (check.charAt(4) == 'X' && check.charAt(4) == check.charAt(8)) {
            if (check.charAt(4) == check.charAt(12)) {
                xWins++;
            }
        }
        if (check.charAt(0) == 'O' && check.charAt(0) == check.charAt(8)) {
            if (check.charAt(0) == check.charAt(16)) {
                oWins++;
            }
        }
        if (check.charAt(4) == 'O' && check.charAt(4) == check.charAt(8)) {
            if (check.charAt(4) == check.charAt(12)) {
                oWins++;
            }
        }
        // vertical lines
        for (int i = 0; i < 5; i++) {
            if (check.charAt(i) == 'X' && check.charAt(i) == check.charAt(i + 6)) {
                if (check.charAt(i) == check.charAt(i + 12)) {
                    xWins++;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (check.charAt(i) == 'O' && check.charAt(i) == check.charAt(i + 6)) {
                if (check.charAt(i) == check.charAt(i + 12)) {
                    oWins++;
                }
            }
        }
        // horizontal lines
        if (check.charAt(0) == 'X' && check.charAt(0) == check.charAt(2)) {
            if (check.charAt(0) == check.charAt(4)) {
                xWins++;
            }
        }
        if (check.charAt(6) == 'X' && check.charAt(6) == check.charAt(8)) {
            if (check.charAt(6) == check.charAt(10)) {
                xWins++;
            }
        }
        if (check.charAt(12) == 'X' && check.charAt(12) == check.charAt(14)) {
            if (check.charAt(12) == check.charAt(16)) {
                xWins++;
            }
        }
        if (check.charAt(0) == 'O' && check.charAt(0) == check.charAt(2)) {
            if (check.charAt(0) == check.charAt(4)) {
                oWins++;
            }
        }
        if (check.charAt(6) == 'O' && check.charAt(6) == check.charAt(8)) {
            if (check.charAt(6) == check.charAt(10)) {
                oWins++;
            }
        }
        if (check.charAt(12) == 'O' && check.charAt(12) == check.charAt(14)) {
            if (check.charAt(12) == check.charAt(16)) {
                oWins++;
            }
        }
        if (xWins > 0) {
            System.out.println("X wins");
            isFinished = false;
        }
        if (oWins > 0) {
            System.out.println("O wins");
            isFinished = false;
        }
        if (count >= 9) {
            System.out.println("Draw");
            isFinished = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("---------");
        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");
        System.out.println("---------");

        int indexOfChar = 0;
        char[][] array = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = input.charAt(indexOfChar);
                indexOfChar++;
            }
        }
        while (true) {
            xMoves(array);
            if (!isFinished)
                break;
            oMoves(array);
            if (!isFinished)
                break;
        }
    }
}
