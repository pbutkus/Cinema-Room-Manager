import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String nAndM = scanner.nextLine();
        String[] splitNAndM = nAndM.split(" ");

        int n = Integer.parseInt(splitNAndM[0]);
        int m = Integer.parseInt(splitNAndM[1]);

        int[][] seats = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int seatValue = Integer.parseInt(scanner.next());
                seats[i][j] = seatValue;
            }
        }

        int k = scanner.nextInt();

        int suitableRow = 0;

        for (int i = 0; i < n; i++) {
            int emptyCounter = 0;
            for (int j = 0; j < m; j++) {
                if (seats[i][j] == 0) {
                    emptyCounter++;

                    if (emptyCounter == k) {
                        break;
                    }
                } else {
                    emptyCounter = 0;
                }
            }
            if (emptyCounter >= k) {
                suitableRow = i + 1;
                break;
            }
        }

        System.out.println(suitableRow);
    }

}