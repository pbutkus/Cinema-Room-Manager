package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();
        System.out.println();

        String[][] seatMap = new String[rows][seatsInRow];
        int purchasedTicketCount = 0;
        int currentIncome = 0;
        int totalIncome = getTotalPossibleIncome(rows, seatsInRow);
        int cinemaSize = rows * seatsInRow;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                seatMap[i][j] = "S";
            }
        }

        boolean running = true;

        while (running) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int input = scanner.nextInt();

            switch (input) {
                case 0:
                    running = false;
                    break;
                case 1:
                    printSeatMap(rows, seatsInRow, seatMap);
                    break;
                case 2:
                    int ticketPrice = buyTicket(scanner, seatMap);
                    if (ticketPrice != 0) {
                        purchasedTicketCount++;
                        currentIncome += ticketPrice;
                    }
                    break;
                case 3:
                    printStatistics(purchasedTicketCount, currentIncome, totalIncome, cinemaSize);
                    break;
            }
        }
    }

    public static void printSeatMap(int rows, int seatsInRow, String[][] seatMap) {
        System.out.println();
        System.out.println("Cinema:");

        for (int i = 0; i <= rows; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print(i);
            }
            for (int j = 0; j <= seatsInRow; j++) {
                if (i == 0 && j > 0) {
                    System.out.print(" " + j);
                } else if (j > 0) {
                    System.out.print(" " + seatMap[i - 1][j - 1]);
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int buyTicket(Scanner scanner, String[][] seatMap) {
        System.out.println();
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        if (row < 1 || seatNumber < 1 || row > seatMap.length || seatNumber > seatMap[row - 1].length) {
            System.out.println();
            System.out.println("Wrong input!");
            return buyTicket(scanner, seatMap);
        } else if (!seatMap[row - 1][seatNumber - 1].equals("S")) {
            System.out.println();
            System.out.println("That ticket has already been purchased!");
            return buyTicket(scanner, seatMap);
        } else {
            seatMap[row - 1][seatNumber - 1] = "B";
        }

        if (seatMap.length * seatMap[row - 1].length > 60 && row > seatMap.length / 2) {
            System.out.println();
            System.out.println("Ticket price: $8");
            System.out.println();
            return 8;
        }

        System.out.println();
        System.out.println("Ticket price: $10");
        System.out.println();

        return 10;
    }

    public static int getTotalPossibleIncome (int rows, int seatsInRow) {
        if (rows * seatsInRow > 60) {
            int firstHalf = rows / 2;
            int backHalf = rows - firstHalf;

            return (firstHalf * seatsInRow * 10) + (backHalf * seatsInRow * 8);
        }

        return rows * seatsInRow * 10;
    }

    public static void printStatistics(int soldTickets, int currentIncome, int totalIncome, int cinemaSize) {
        double percentage = 1.0 * soldTickets / cinemaSize * 100;

        System.out.println();
        System.out.println("Number of purchased tickets: " + soldTickets);
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
        System.out.println();
    }

}