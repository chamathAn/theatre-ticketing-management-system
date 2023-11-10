
import java.util.*;
import java.io.*;

public class Theatre {
    public static void main(String arg[]) {
        //initializing the array to save the tickets
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

        //creating arrays to store if sheets are occupied or available
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        ArrayList<Integer> secondRow = new ArrayList<Integer>();
        ArrayList<Integer> thirdRow = new ArrayList<Integer>();

        //initial all arrays with setting up by making all sheets are available
        for (int i = 0; i < 12; i++) {
            firstRow.add(0);
        }

        for (int i = 0; i < 16; i++) {
            secondRow.add(0);
        }

        for (int i = 0; i < 20; i++) {
            thirdRow.add(0);
        }

        try {
            while (true) {
                //menu
                System.out.println("Welcome to the New Theatre");
                System.out.println("-------------------------------------------------");
                System.out.println("Please select an option");
                System.out.println("1) Buy a ticket");
                System.out.println("2) Print seating area ");
                System.out.println("3) Cancel ticket ");
                System.out.println("4) List available seats");
                System.out.println("5) Save to file ");
                System.out.println("6) Load from file");
                System.out.println("7) Print ticket information and total price ");
                System.out.println("8) Sort tickets by price ");
                System.out.println("0) Quit");
                System.out.println("-------------------------------------------------");

                //user input case from menu
                Scanner input = new Scanner(System.in);
                System.out.print("Enter option:");
                int menuInput = input.nextInt();

                //program work on user given input
                switch (menuInput) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        buy_ticket(firstRow, secondRow, thirdRow, ticketList);
                        break;
                    case 2:
                        print_seating_area(firstRow, secondRow, thirdRow);
                        break;
                    case 3:
                        cancel_ticket(firstRow, secondRow, thirdRow, ticketList);
                        break;
                    case 4:
                        show_available(firstRow, secondRow, thirdRow);
                        break;
                    case 5:
                        save(firstRow, secondRow, thirdRow);
                        break;
                    case 6:
                        load(firstRow, secondRow, thirdRow);
                        break;
                    case 7:
                        show_tickets_info(ticketList);
                        break;
                    case 8:
                        sort_tickets(ticketList);
                        break;
                    default:
                        System.out.println("Enter number 1-8\n");
                        break;
                }

                Scanner input3 = new Scanner(System.in);
                System.out.println("Press n to stop or press any key to continue");
                System.out.print("Do you want to continue:");
                String cont1 = input3.nextLine().toLowerCase();
                if (cont1.equals("n")) {
                    break;
                }
            }
        } catch (Throwable t) {
            System.out.println("Error has occurred! please rerun the program and give inputs as mentioned.");
        }
    }

    private static void buy_ticket(ArrayList<Integer> firstRow2, ArrayList<Integer> secondRow2, ArrayList<Integer> thirdRow2, ArrayList<Ticket> ticketList) {

        //ask for person details and ticket details
        Scanner inputName = new Scanner(System.in);
        System.out.print("Enter your name :");
        String name = inputName.next();

        Scanner inputSurname = new Scanner(System.in);
        System.out.print("Enter your surname :");
        String surname = inputSurname.next();

        Scanner inputEmail = new Scanner(System.in);
        System.out.print("Enter your email :");
        String email = inputEmail.next();


        Boolean wrongSheet = true;
        Boolean wrongRow = true;
        int rowNumber;
        do {
            //this will loop until user enter a valid number to this sub menu
            Scanner input = new Scanner(System.in);
            System.out.print(""" 
                                        
                    Select  row
                     
                    1. Fitst row - Rs.100.00
                    2. Second row - Rs.75.00 
                    3. Third row - Rs.50.00
                                        
                    """);
            System.out.print("Selection:");
            rowNumber = input.nextInt();
            if (rowNumber == 1 || rowNumber == 2 || rowNumber == 3) {
                break;
            }
        } while (wrongRow == true);

        //program work on user given option
        switch (rowNumber) {

            //first row part
            case (1):
                int firstRow[] = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12};
                Scanner input = new Scanner(System.in);
                System.out.print("Select the sheet(1-12):");
                int sheetNumber2 = input.nextInt();

                //check if the sheet is in the row
                if (!Arrays.toString(firstRow).contains(Integer.toString(sheetNumber2))) {
                    while (wrongSheet == true) {
                        System.out.println();
                        System.out.println("Your sheet is not in this row. Try again!!!");
                        Scanner input1 = new Scanner(System.in);
                        System.out.print("Select the sheet(1-12):");
                        sheetNumber2 = input1.nextInt();
                        if (Arrays.toString(firstRow).contains(Integer.toString(sheetNumber2))) {
                            break;
                        }
                    }
                } else if (firstRow2.get(sheetNumber2 - 1) == 1) {
                    //check if the sheet is already booked or not


                    while (wrongSheet == true) {
                        System.out.println();
                        System.out.println("Your sheet already has been booked. Try again!!!");
                        Scanner input2 = new Scanner(System.in);
                        System.out.print("Select the sheet(1-12):");
                        sheetNumber2 = input2.nextInt();
                        if (firstRow2.get(sheetNumber2 - 1) == 0) {
                            break;
                        }
                    }
                }
                //purchasing the seat
                firstRow2.set(sheetNumber2 - 1, 1);
                System.out.println("Your purchase is succeeded");
                System.out.println();

                //save tickets to array
                ticketList.add(new Ticket(rowNumber, sheetNumber2, 100, name, surname, email));
                break;

            //second row part
            case (2):

                int secondRow[] = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
                Scanner input3 = new Scanner(System.in);
                System.out.print("Select the sheet(1-16):");
                int sheetNumber3 = input3.nextInt();

                //check if the sheet is in the row
                if (!Arrays.toString(secondRow).contains(Integer.toString(sheetNumber3))) {
                    while (wrongSheet == true) {
                        System.out.println();
                        System.out.println("Your sheet is not in this row. Try again!!!");
                        Scanner input4 = new Scanner(System.in);
                        System.out.print("Select the sheet(1-16):");
                        sheetNumber3 = input4.nextInt();
                        if (Arrays.toString(secondRow).contains(Integer.toString(sheetNumber3))) {
                            break;
                        }
                    }
                } else if (secondRow2.get(sheetNumber3 - 1) == 1) {
                    //check if the sheet is already booked or not

                    while (wrongSheet == true) {
                        System.out.println();
                        System.out.println("Your sheet already has been booked. Try again!!!");
                        Scanner input4 = new Scanner(System.in);
                        System.out.print("Select the sheet(1-12):");
                        sheetNumber3 = input4.nextInt();
                        if (secondRow2.get(sheetNumber3 - 1) == 0) {
                            break;
                        }
                    }
                }
                //purchasing the seat
                secondRow2.set(sheetNumber3 - 1, 1);
                System.out.println("Your purchase is succeeded");
                System.out.println();

                //save tickets to array
                ticketList.add(new Ticket(rowNumber, sheetNumber3, 75, name, surname, email));
                break;

            //third row part
            case (3):
                int thirdRow[] = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
                Scanner input5 = new Scanner(System.in);
                System.out.print("Select the sheet(1-20):");
                int sheetNumber4 = input5.nextInt();

                //check if the sheet is in the row
                if (!Arrays.toString(thirdRow).contains(Integer.toString(sheetNumber4))) {
                    while (wrongSheet == true) {
                        System.out.println();
                        System.out.println("Your sheet is not in this row. Try again!!!");
                        Scanner input6 = new Scanner(System.in);
                        System.out.print("Select the sheet(1-20):");
                        sheetNumber4 = input6.nextInt();
                        if (Arrays.toString(thirdRow).contains(Integer.toString(sheetNumber4))) {
                            break;
                        }
                    }
                } else if (thirdRow2.get(sheetNumber4 - 1) == 1) {
                    //check if the seat is already booked or not

                    while (wrongSheet == true) {
                        System.out.println();
                        System.out.println("Your sheet already has been booked. Try again!!!");
                        Scanner input6 = new Scanner(System.in);
                        System.out.print("Select the sheet(1-20):");
                        sheetNumber4 = input6.nextInt();
                        if (thirdRow2.get(sheetNumber4 - 1) == 0) {
                            break;
                        }
                    }
                } 
                //purchasing the seat
                thirdRow2.set(sheetNumber4 - 1, 1);
                System.out.println("Your purchase is succeeded");
                System.out.println();

                //save tickets to array
                ticketList.add(new Ticket(rowNumber, sheetNumber4, 50, name, surname, email));
                break;

        }
    }

    private static void print_seating_area(ArrayList<Integer> firstRow2, ArrayList<Integer> secondRow2, ArrayList<Integer> thirdRow2) {

        System.out.println();
        System.out.printf(String.format("%" + 26 + "s", "***********") + "\n");
        System.out.printf(String.format("%" + 25 + "s", " * STAGE *") + "\n");
        System.out.printf(String.format("%" + 26 + "s", "***********"));

        //initializing variables to store seats availability
        String row1 = "";
        String row2 = "";
        String row3 = "";

        //check the first row seats availability to display
        for (int element : firstRow2) {
            if (element == 0) {
                row1 = "O" + row1;

            } else {
                row1 = "X" + row1;
            }
        }

        System.out.println();

        //check the second row seats availability to display
        for (int element2 : secondRow2) {
            if (element2 == 0) {
                row2 = "O" + row2;

            } else {
                row2 = "X" + row2;
            }
        }
        System.out.println();

        //check the third row seats availability to display
        for (int element3 : thirdRow2) {
            if (element3 == 0) {
                row3 = "O" + row3;

            } else {
                row3 = "X" + row3;

            }

        }

        //call out the aligning method
        centerAlign(row1, row2, row3);

    }

    private static void centerAlign(String string1, String string2, String string3) {

        /*
        To align the seats output as required
        @param string1 first row of seats availability
        @param string2 second row of seats availability
        @param string3 third row of seats availability
         */

        //initializing 2 separate variables to store first row seats
        String firstRowPart1 = "";
        String firstRowPart2 = "";
        //separate all characters of row1
        String[] row1Splitted = string1.split("");

        //initializing 2 separate variables to store second row seats
        String secondRowPart1 = "";
        String secondRowPart2 = "";
        //separate all characters of row2
        String[] row2Splitted = string2.split("");

        //initializing 2 separate variables to store third row seats
        String thirdRowPart1 = "";
        String thirdRowPart2 = "";
        //separate all characters of row3
        String[] row3Splitted = string3.split("");

        //these for loops storing each characters to their respect variables
        for (int i = 0; i < string1.length(); i++) {
            if (i <= (string1.length() / 2) - 1) {
                firstRowPart1 += row1Splitted[i];
            } else {
                firstRowPart2 += row1Splitted[i];
            }
        }

        for (int i = 0; i < string2.length(); i++) {
            if (i <= (string2.length() / 2) - 1) {
                secondRowPart1 += row2Splitted[i];
            } else {
                secondRowPart2 += row2Splitted[i];
            }
        }

        for (int i = 0; i < string3.length(); i++) {
            if (i <= (string3.length() / 2) - 1) {
                thirdRowPart1 += row3Splitted[i];
            } else {
                thirdRowPart2 += row3Splitted[i];
            }
        }

        //formatting part which is based on longest length among the these variables.
        int maxLength = Math.max(string1.length(), Math.max(string2.length(), string3.length()));
        //this part formatting the behind part to right align
        String format1 = "%" + maxLength + "s" + " ";
        //this part is formatting to after parts to left align
        String format2 = "%-" + maxLength + "s";


        //all below variables are used to fulfill the formatting part which is inherent to them
        String output1A = String.format(format1, firstRowPart1);
        String output1B = String.format(format2, firstRowPart2);


        String output2A = String.format(format1, secondRowPart1);
        String output2B = String.format(format2, secondRowPart2);

        String output3A = String.format(format1, thirdRowPart1);
        String output3B = String.format(format2, thirdRowPart2);


        //bellow part are used to display everything as required
        System.out.printf(output1A);
        System.out.printf(output1B);
        System.out.println();
        System.out.printf(output2A);
        System.out.printf(output2B);
        System.out.println();
        System.out.printf(output3A);
        System.out.printf(output3B);
        System.out.println();
        System.out.println();
    }

    private static void cancel_ticket(ArrayList<Integer> firstRow, ArrayList<Integer> secondRow, ArrayList<Integer> thirdRow, ArrayList<Ticket> ticketList) {
        /*
        To cancel the seats that has been already booked
        @param firstRow depicts the first row of seats with availability
        @param secondRow depicts the second row of seats with availability
        @param thirdRow depicts the third row of seats with availability
         */
        int rowNum;
        int seatNum;
        while (true) {
            Scanner input1 = new Scanner(System.in);
            System.out.print("Please enter the row number :");
            rowNum = input1.nextInt();
            if (rowNum == 1 || rowNum == 2 || rowNum == 3) {
                break;
            } else {
                System.out.println("\n" + "Wrong row number. Choose a row between 1 to 3");
            }
        }
        switch (rowNum) {
            case 1:
                while (true) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the seat number :");
                    seatNum = input.nextInt();
                    if (1 <= seatNum && 12 >= seatNum) {
                        break;
                    } else {
                        System.out.println("\n" + "Seat is not available in this row. Choose rows from 1 to 12");
                    }
                }

                while (firstRow.get(seatNum - 1) == 0) {
                    System.out.println("\n" + "Seat is already available to book. Nothing to cancel. Try again!");
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the seat number :");
                    seatNum = input.nextInt();
                    if (firstRow.get(seatNum - 1) == 1) {
                        break;
                    }
                }

                firstRow.set(seatNum - 1, 0);
                System.out.println("Your occupied seat is canceled successfully. \n");

                //deleting ticket details from ticketArray
                for (Ticket ticket : ticketList) {
                    if (ticket.getRow() == rowNum && ticket.getSeat() == seatNum) {
                        ticketList.remove(ticket);
                        break;
                    }
                }
                break;

            case 2:
                while (true) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the seat number :");
                    seatNum = input.nextInt();
                    if (1 <= seatNum && 16 >= seatNum) {
                        break;
                    } else {
                        System.out.println("\n" + "Seat is not available in this row. Choose rows from 1 to 16");
                    }
                }

                while (secondRow.get(seatNum - 1) == 0) {
                    System.out.println("\n" + "Seat is already available to book. Nothing to cancel. Try again!");
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the seat number :");
                    seatNum = input.nextInt();
                    if (secondRow.get(seatNum - 1) == 1) {
                        break;
                    }
                }

                secondRow.set(seatNum - 1, 0);
                System.out.println("Your occupied seat is canceled successfully. ");
                //deleting ticket details from ticketArray
                for (Ticket ticket : ticketList) {
                    if (ticket.getRow() == rowNum && ticket.getSeat() == seatNum) {
                        ticketList.remove(ticket);
                        break;
                    }
                }
                break;

            case 3:
                while (true) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the seat number :");
                    seatNum = input.nextInt();
                    if (1 <= seatNum && 20 >= seatNum) {
                        break;
                    } else {
                        System.out.println("\n" + "Seat is not available in this row. Choose rows from 1 to 20");
                    }
                }

                while (thirdRow.get(seatNum - 1) == 0) {
                    System.out.println("\n" + "Seat is already available to book. Nothing to cancel. Try again!");
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the seat number :");
                    seatNum = input.nextInt();
                    if (thirdRow.get(seatNum - 1) == 1) {
                        break;
                    }
                }

                thirdRow.set(seatNum - 1, 0);
                System.out.println("Your occupied seat is canceled successfully. ");
                for (Ticket ticket : ticketList) {
                    if (ticket.getRow() == rowNum && ticket.getSeat() == seatNum) {
                        ticketList.remove(ticket);
                        break;
                    }
                }
                break;
        }
    }

    private static void show_available(ArrayList<Integer> firstRow, ArrayList<Integer> secondRow, ArrayList<Integer> thirdRow) {

            /*
            display all available seats in categorized manner
            @param firstRow takes the first row availability included array
            @param secondRow takes the second row availability included array
            @param thirdRow takes the third row availability included array
             */

        //display all available seats info separately
        System.out.print("\n" + "Seats available in row 1:");
        for (int count = 0; count < firstRow.size(); count++) {
            if (firstRow.get(count) == 0) {
                System.out.print((count + 1) + ", ");
            }
        }
        System.out.println();

        System.out.print("Seats available in row 2:");
        for (int count = 0; count < secondRow.size(); count++) {
            if (secondRow.get(count) == 0) {
                System.out.print((count + 1) + ", ");
            }
        }
        System.out.println();

        System.out.print("Seats available in row 3:");
        for (int count = 0; count < thirdRow.size(); count++) {
            if (thirdRow.get(count) == 0) {
                System.out.print((count + 1) + ", ");
            }
        }
        System.out.println("\n");
    }

    private static void save(ArrayList<Integer> firstRow, ArrayList<Integer> secondRow, ArrayList<Integer> thirdRow) {

        //import FileWriter and write all rows details into a storedRows.txt called text file
        try {
            FileWriter file = new FileWriter("StoredRows.txt");
            for (int element : firstRow) {
                file.write(Integer.toString(element));
            }
            file.write("\n");
            for (int element : secondRow) {
                file.write(Integer.toString(element));
            }
            file.write("\n");
            for (int element : thirdRow) {
                file.write(Integer.toString(element));
            }
            file.close();
            System.out.println("Successfully wrote to the file.");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Seems like a error had occurred.");
        }
    }

    private static void load(ArrayList<Integer> firstRow, ArrayList<Integer> secondRow, ArrayList<Integer> thirdRow) {

        //import File and until end of text lines of txt file, it read and load into respect arrays which is belonging to each row
        try {
            File file = new File("StoredRows.txt");
            Scanner fileReader = new Scanner(file);
            int counter = 0;
            while (fileReader.hasNextLine()) {
                counter++;
                String line = fileReader.nextLine();//save the whole line to a string
                String[] lineSplitted = line.split("");//split every character in string and collect those into an array
                if (counter == 1) {
                    for (int x = 0; x < lineSplitted.length; x++) {
                        firstRow.set(x, Integer.parseInt(lineSplitted[x]));//setting up every array of rows with booked details
                    }
                } else if (counter == 2) {
                    for (int x = 0; x < lineSplitted.length; x++) {
                        secondRow.set(x, Integer.parseInt(lineSplitted[x]));
                    }
                } else {
                    for (int x = 0; x < lineSplitted.length; x++) {
                        thirdRow.set(x, Integer.parseInt(lineSplitted[x]));
                    }
                }
                Arrays.fill(lineSplitted, null);//make the above splitted array null to start with on next line as a new array
            }
            fileReader.close();
            System.out.println("Successfully loaded booked and available seats.");
            System.out.println();

        } catch (IOException e) {//error handling with IO exception
            System.out.println("Error while reading a file.");
            e.printStackTrace();
        }
    }

    private static void show_tickets_info(ArrayList<Ticket> ticketList) {

        /*
        display all booked seats with owners details and other ticket details
        @param ticketList is the list of where all Ticket objects have save
         */

        int totalPrice = 0;
        for (Ticket ticket : ticketList) {
            ticket.print();
            totalPrice += ticket.getPrice();
            System.out.println();
        }
        System.out.println("------------------------------------------------");
        System.out.println("Your total cost for ticket(Rs.):" + totalPrice);
    }

    private static void sort_tickets(ArrayList<Ticket> ticketList) {
        /*
        to sort out ticketList array and display on ascending order the tickerts
        @PARAM ticketList depict ticketList array
         */

        //sorting up using bubble sort
        Ticket temp;
        int bottom = ticketList.size() - 2;
        boolean exchanged = true;
        while (exchanged) {
            exchanged = false;
            for (int i = 0; i <= bottom; i++) {
                if (ticketList.get(i).getPrice() < ticketList.get(i + 1).getPrice()) {
                    temp = ticketList.get(i);
                    ticketList.set(i, ticketList.get(i + 1));
                    ticketList.set(i + 1, temp);
                    exchanged = true;
                }
            }
            bottom--;
        }

        //displaying sorted array
        for (int i = ticketList.size() - 1; i >= 0; i--) {
            ticketList.get(i).print();
            System.out.println();
        }
    }

}





