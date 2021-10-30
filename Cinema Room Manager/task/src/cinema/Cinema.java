package cinema;


import java.util.Scanner;

import static cinema.Tickets.countingTickets;
import static cinema.Tickets.ticketSeat;


public class Cinema {

    private static final Scanner sc = new Scanner(System.in);
    private static final String RESERVE = "B"; // резерв места = англ буква "B"

    // переменная видимая в классе Ticket
    public static int rowSeatTicket = 0;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int col = sc.nextInt();
        System.out.println();

        CreateHall ch = new CreateHall();
        Tickets tk = new Tickets();

        // Объявление зала с с количеством рядом и мест
        String[][] arr = ch.twoRowCol(row, col);

        // подсчет стоимость всех билетов в зале и создания зала
        String[][] ticketArr = tk.countingTickets(ch.createMatrixHall(arr));

        System.out.println();


        System.out.println("Enter a row number:");
        int n = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int m = sc.nextInt();

        // переменнной присваивается номер ряда ---> class Tickets
        rowSeatTicket = n;

        // выбор свободного места в зале
        checkTicketSeat(ticketArr, n, m);

        // вызов второй раз метод countingTickets, только для того,
        // чтобы проверить билет на ряд чет или нечет(стоимость билета 10 или 8)
        countingTickets(ticketArr);
        System.out.println();

        // вывод зала
        matrixOutput(ticketArr);

        System.out.println();

        System.out.println("Ticket price: $" + ticketSeat + "\n");

    }

    // резерв места в зале "B"
    public static String[][] checkTicketSeat(String[][] seat, int a, int b) {
        a -= 1; b -= 1;
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (seat[a][b] == seat[i][j]) {
                    seat[a][b] = RESERVE;
                }

            }
        }
        return seat;
    }

    // вывод зала
    public static String[][] matrixOutput(String[][] arr) {
        System.out.println("Cinema:");
        System.out.print("  ");

        for (int a = 0; a <= arr.length; a++) {
            System.out.print((a + 1) + " ");
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        return arr;
    }


}