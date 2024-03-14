// I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
// Any code taken from other sources is referenced within my code solution.
// Student ID: w1956357
// Date: 20/03/2023


import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Theatre {

    // creating three arrays for rows.
     static int[] first_row = new int[12];                                   // Introducing first array.
     static int[] sec_row = new int[16];                                     // Introducing second array.
     static int[] third_row = new int[20];                                   // Introducing third array.
     static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();          // Introducing array list as ticketList.

    public static void main(String[] args) {

        System.out.println("Welcome to New Theatre");            // print welcome massage.

        Scanner input = new Scanner(System.in);

        int option;


        lable:
        while (true) {
            // print the main menu options.
            System.out.println("-".repeat(50));
            System.out.println("Please select an option:");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit");
            System.out.println("-".repeat(50));

            System.out.print("Enter option : ");
            // Get the option from the user.
            try {                        // E

                option = input.nextInt();

                // Make switch cases.(For conditional statements.)

                switch (option) {
                    case 1:
                        System.out.println("1) Buy a ticket.");
                        buy_ticket();
                        break;
                    case 2:
                        System.out.println("2) Print seating area.");
                        print_seating_area();
                        break;
                    case 3:
                        System.out.println("3) Cancel ticket. ");
                        cancel_ticket();
                        break;
                    case 4:
                        System.out.println("4) List available seats.");
                        show_available();
                        break;
                    case 5:
                        System.out.println("5) Save to file.");
                        save();
                        break;
                    case 6:
                        System.out.println("6) Load from file.");
                        load();
                        break;
                    case 7:
                        System.out.println("7) Print ticket information and total price");
                        show_tickets_info();
                        break;
                    case 8:
                        System.out.println("8) Sort tickets by price.");
                        sort_tickets();
                        break;
                    case 0:
                        System.out.println("Thank you");
                        break lable;  //Exit from the loop.
                    default:
                        System.out.println("Invalid number.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid option");
                input.nextLine();                      // gets the next input.
            }

        }
    }

        



        public static void buy_ticket() {       // method to allows user to book tickets
        Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your name: ");
            String name = sc.nextLine();
            System.out.println("Please enter your surname: ");
            String surname = sc.nextLine();
            System.out.println("Please enter your email: ");
            String email = sc.nextLine();
            System.out.println("Please enter the ticket price: ");
            double price = sc.nextDouble();
            Person person = new Person(name, surname, email);                 // Create a Person object using the user's personal information.


            System.out.println("Enter your desired row number: ");
        int row_num = sc.nextInt();

        if (row_num < 1 || row_num > 3) {
            System.out.println("Invalid input please enter a number between(1-3)");
        } else {
            if (row_num == 1) {
                for (int i = 0; i < first_row.length; i++) {
                    System.out.println("Please choose your seat number: ");
                    int seat_num = sc.nextInt();
                    if(seat_num<first_row.length+1) {
                        if (first_row[seat_num - 1] == 1) {
                            System.out.println("Sorry, the seat is already booked.");
                        } else {
                            first_row[seat_num - 1] = 1;     // Add seat to first_row
                            Ticket ticket = new Ticket(row_num, seat_num, price, person);
                            ticketList.add(ticket);     // add details to the array list
                        }
                    }else{
                        System.err.println("Error.");
                    }
                    break;
                }


            } else if (row_num == 2) {
                for (int i = 0; i < sec_row.length; i++) {
                    System.out.println("Please choose your seat number: ");
                    int seat_num = sc.nextInt();
                    if(seat_num<sec_row.length+1) {
                        if (sec_row[seat_num - 1] == 1) {
                            System.out.println("Sorry, the seat is already booked.");
                        } else {
                            sec_row[seat_num - 1] = 1;       // Add seat to sec_row
                            Ticket ticket = new Ticket(row_num, seat_num, price, person);
                            ticketList.add(ticket);
                        }
                    }else {
                        System.err.println("Error.");
                    }
                    break;

                }

            } else {
                for (int i = 0; i < third_row.length; i++) {
                    System.out.println("Please choose your seat number: ");
                    int seat_num = sc.nextInt();
                    if(third_row[seat_num -1]==1) {
                        if (seat_num < third_row.length + 1) {
                            System.out.println("Sorry, the seat is already booked.");
                        } else {
                            third_row[seat_num - 1] = 1;      //Add seat to third_row
                            Ticket ticket = new Ticket(row_num, seat_num, price, person);
                            ticketList.add(ticket);
                        }
                    }else{
                        System.err.println("Error.");
                    }
                    break;
                }
            }

        }
    }

    public static void print_seating_area() {     // method to print the seating area
        System.out.println("    ***********\n" +
                           "    *  STAGE  *\n" +         // printing seating area
                           "    ***********  ");

        // arrangement for the first row.
        System.out.print("    ");
        for (int i = 0; i < first_row.length; i++) {

           // Add a space in the middle of the row.
            if (i == (first_row.length / 2)) {
                System.out.print(" ");
            }


            // Print '0' if the seat is available, 'X' if the seat is already booked.
            if (first_row[i] == 0) {
                System.out.print("0");
            } else {
                System.out.print("X");

            }

        }
        System.out.println();

        // arrangement for the second row.
        System.out.print("  ");
        for (int i = 0; i < sec_row.length; i++) {

            // Add a space in the middle of the row.
            if (i == sec_row.length / 2) {
                System.out.print(" ");
            }


            // Print '0' if the seat is available, 'X' if the seat is already booked.
            if (sec_row[i] == 0) {
                System.out.print("0");
            } else {

                System.out.print("X");
            }
        }

        System.out.println();

        // arrangement for the third row.
        for (int i = 0; i < third_row.length; i++) {

            // Add a space in the middle of the row.
            if (i == third_row.length / 2) {
                System.out.print(" ");
            }

            // Print '0' if the seat is available, 'X' if the seat is already booked.
            if (third_row[i] == 0) {
                System.out.print("0");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();
    }


    public static void cancel_ticket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your desired row number: ");            // Ask which row should be cancelled.
        int row_num = input.nextInt();
        System.out.println("Please choose your seat number: ");          // Ask which seat should be cancelled.
        int seat_num = input.nextInt();

        if (row_num < 1 || row_num > 3) {
            System.out.println("Invalid input please enter a number between(1-3)");
        } else {
            if (row_num == 1 && (seat_num >= 1 && seat_num <= 12)) {
                    if (0 == first_row[seat_num]) {
                        first_row[seat_num - 1] = 0;                                    // Mark the seat as available in the seating area
                        for (int i = 0; i < ticketList.size(); i++) {
                            Ticket.ticket = ticketList.get(i);
                            if (Ticket.ticket.getSeat() == seat_num) {
                                ticketList.remove(i);      // remove ticket from the ticketList array list.
                            }
                    }
                }
            } else if (row_num == 2 && (seat_num >= 1 && seat_num <= 16)) {
                if (0 == sec_row[seat_num]) {
                    sec_row[seat_num - 1] = 0;                                   // Mark the seat as available in the seating area
                    for (int i = 0; i < ticketList.size(); i++) {
                        Ticket.ticket = ticketList.get(i);
                        if (Ticket.ticket.getSeat() == seat_num) {
                            ticketList.remove(i);         // remove ticket from the ticketList array list.
                        }
                    }
                }
            } else {
                if (row_num == 3 && (seat_num >= 1 && seat_num <= 20)) {
                    if (0 == third_row[seat_num]) {
                        third_row[seat_num - 1] = 0;                                   // Mark the seat as available in the seating area
                        for (int i = 0; i < ticketList.size(); i++) {
                            Ticket.ticket = ticketList.get(i);
                            if (Ticket.ticket.getSeat() == seat_num) {
                                ticketList.remove(i);      // remove ticket from the ticketList array list
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Ticket cancelled successfully!");
    }


    static void show_available() {         // method to execute when user wants to check the available seats.

            System.out.println("Seats available in row 1: ");
            for (int j = 0; j < first_row.length; j++) {
                if (first_row[j] == 0) {
                    System.out.print(j + 1);
                    if (j != first_row.length - 1) {
                        System.out.print(",");

                    }
                }
            }
            System.out.println();

        System.out.println("Seat available in row2: ");
            for (int j = 0; j < sec_row.length; j++) {
                if (sec_row[j] == 0) {
                    System.out.print((j + 1));
                    if (j != sec_row.length - 1) {
                        System.out.print(",");

                    }
                }
            }
        System.out.println();

        System.out.println("Seat available in row 3: ");
        for (int j = 0; j < third_row.length; j++) {
            if (third_row[j] == 0) {
                System.out.print((j + 1));
                if (j != third_row.length - 1) {
                    System.out.print(",");

                }
            }
        }
        System.out.println();
    }




    public static void save() {    // create a file or opens the text file if available and writes booked seat details.
        try {
            FileWriter myfile = new FileWriter("save.txt");

            //write the row 1
            for (int i = 0 ; i< first_row.length ; i++){
                myfile.write(first_row[i] + " ");
            }
            myfile.write("\n");

            //write the row 2
            for (int i = 0 ; i< sec_row.length ; i++){
                myfile.write(sec_row[i] + " ");
            }
            myfile.write("\n");

            //write the row 3
            for (int i = 0 ; i< third_row.length ; i++){
                myfile.write(third_row[i] + " ");
            }
            myfile.close();
            System.out.println("Successfully save to the file.");
        }catch (IOException e){
            System.out.println("An error occurred.");
        }
    }



    public static void load() {   // method to executes when user wants to load booked seats and continue.
        try {
            FileReader file_reader=new FileReader("save.txt"); //declares the FileReader

            Scanner file=new Scanner(file_reader);

            for(int i=0; i< first_row.length; i++){  //loads the details of the booked seats in row_1 and saves them back in the row_1 aray
                first_row[i] = file.nextInt();
            }
            for(int i=0; i< sec_row.length; i++){
                sec_row[i] = file.nextInt();
            }
            for(int i=0; i< third_row.length; i++){
                third_row[i] = file.nextInt();
            }
            System.out.println("File loaded successfully.");
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
}

    }


    public static void show_tickets_info(){       // method to print all the information user inputs and print the total price.
        System.out.println("Ticket information: ");
        double tot_price = 0;
        for (int i = 0; i < ticketList.size(); i++) {
            Ticket.ticket = ticketList.get(i);

            Ticket.ticket.print();
            tot_price += Ticket.ticket.getPrice();
        }
        System.out.println("Total price tickets: " + tot_price);
    }


    public static void sort_tickets(){      // method to use when user wants to sort tickets according to the ascending order of prices
        int x = ticketList.toArray().length;
        for (int i = 0; i < x-1; i++) {
            for (int j = 0; j < x-1; j++) {                                   // bubble sort method.
                if(ticketList.get(j).price>ticketList.get(j+1).price){
                    Ticket temp = ticketList.get(j);
                    ticketList.set(j,ticketList.get(j+1));
                    ticketList.set(j+1,temp);
                }
            }
        }
        System.out.println("Sorted tickets: ");
        for (int i = 0; i < x; i++) {
            ticketList.get(i).print();
        }
    }

}

