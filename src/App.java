import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String player = "X";

        String[][] table = { { "_", "_", "_" },
                             { "_", "_", "_" },
                             { " ", " ", " " } };

        upDate(table);

        System.out.println("First move by X");

        
        System.out.println("Enter the r and c:");

        while (true) {

            int r = scanner.nextInt() - 1;
            int c = scanner.nextInt() - 1;

            if (r >= 0 && r < 3 && c >= 0 && c < 3) {
                if (table[r][c] != "X" && table[r][c] != "O") {
                    if (player == "X") {
                        table[r][c] = player;
                        upDate(table);
                        if (checkWin(table, player)) {
                            break;
                        }
                        player = "O";
                    } else {
                        table[r][c] = player;
                        upDate(table);
                        if (checkWin(table, player)) {
                            break;
                        }
                        player = "X";
                    }
                } else {
                    System.out.println("This cell is taken, please choose the another");
                }
            } else {
                System.out.println("Please enter correct numbers (1-3)");
            }
        }
    }

    public static void upDate(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    public static boolean checkWin(String[][] table, String player) {

        for (int i = 0; i < 3; i++) {
            if (table[i][0] == player && table[i][1] == player && table[i][2] == player) {
                System.out.println(player + " WINS!!!");
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (table[0][i] == player && table[1][i] == player && table[2][i] == player) {
                System.out.println(player + " WINS!!!");
                return true;
            }
        }

        if (table[0][0] == player && table[1][1] == player && table[2][2] == player) {
            System.out.println(player + " WINS!!!");
            return true;
        }

        if (table[0][2] == player && table[1][1] == player && table[2][0] == player) {
            System.out.println(player + " WINS!!!");
            return true;
        }
        return false;
    }

}
