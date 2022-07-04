import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ".";

                if (i == n / 2) {
                    matrix[i][j] = "*";
                }
            }

            matrix[i][i] = "*";
            matrix[i][n - 1 - i] = "*";
            matrix[i][n / 2] = "*";

            System.out.println(String.join(" ", matrix[i]));
        }
    }
}