import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to ZachRobertClient version 1.0. This is a email client for email marketing. " +
                "Simply enter your email address and password to login. Then enter the address of whom you would like to contact.");
        Scanner kboard = new Scanner (System.in);
        String control;
        String csvFile = "";
        String line = "";
        String cvsSplitBy = ",";
        boolean listImported = false;
        Inputs master = new Inputs();

        userOptions();
        control = kboard.nextLine();

        while((control.equals("0"))||(control.equals("1"))||(control.equals("2"))||(control.equals("3"))||(control.equals("4"))||(control.equals("5"))||(control.equals("6"))||(control.equals("7"))||(control.equals("8"))||(control.equals("9"))) {

            if (control.equals("0")) {

                if (listImported == true) {

                    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                        while ((line = br.readLine()) != null) {

                            String[] emailList = line.split(cvsSplitBy);

                            if(emailList[2].contains("@")){

                                master = master.updateRecipient(master, emailList[2]);
                                new SLLMail().test(master);
                            }
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else {

                    new SLLMail().test(master);
                }

            }
            else if (control.equals("1")) {

                System.out.println("Enter a new Email Subject");
                master = master.updateSubject(master, kboard.nextLine());

                System.out.println("Enter a new Email Message");
                master = master.updateMessage(master, kboard.nextLine());

            }
            else if (control.equals("2")) {

                System.out.println("Enter a new recipient's email address");
                master = master.updateRecipient(master, kboard.nextLine());

            }
            else if (control.equals("3")) {

                System.out.println("===============================================================================================================================");
                System.out.println("|                |");
                System.out.println("|   Sending from:|   " + master.getUserEmail());
                System.out.println("|   Recipient:   |   " + master.getRecipient());
                System.out.println("|                |");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("|                |");
                System.out.println("|   Subject:     |   " + master.getSubject());
                System.out.println("|                |");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("|                |");
                System.out.println("|   Message:     |   " + master.getMessage());
                System.out.println("|                |");
                System.out.println("===============================================================================================================================");

            }
            else if (control.equals("4")) {

                System.out.println("Enter your new email that you wish to login to");
                master = master.updateUser(master, kboard.nextLine());
                System.out.println("Enter the email's password");
                master = master.updateUserPass(master, kboard.nextLine());

            }
            else if (control.equals("5")) {

                master = new Inputs();

            }
            else if (control.equals("6")) {

                userOptions();

            }
            else if (control.equals("7")) {

                System.out.println("Enter the path to your csv file. Use '/' for your slashes. An example is: D://downloads/emailList.csv");
                csvFile = kboard.nextLine();
                listImported = true;
                System.out.println("Email list imported! Its a good idea to enter 9 to test it.");
            }
            else if (control.equals("8")) {

                csvFile = "";
                listImported = false;
                System.out.println("Email list removed");
            }
            else if (control.equals("9")) {

                if (listImported == true) {

                    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                        int i = 0;
                        while ((line = br.readLine()) != null) {

                            String[] emailList = line.split(cvsSplitBy);

                            if(emailList[2].contains("@")){

                                System.out.println(i + ": " + emailList[2]);

                            }

                            i++;
                        }

                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }


                } else {
                    System.out.println("Error: No imported list");
                }
            }
            else {
                System.out.println("Error: Invalid input");
            }

            userOptions();
            control = kboard.nextLine();
        }
    }

    public static void userOptions()
    {
        System.out.println("=====================================================");
        System.out.println("|                                                   |");
        System.out.println("|   Enter 0 to send your email                      |");
        System.out.println("|   Enter 1 to change the email message             |");
        System.out.println("|   Enter 2 to change the recipient                 |");
        System.out.println("|   Enter 3 to preview your email                   |");
        System.out.println("|   Enter 4 to update your email information        |");
        System.out.println("|   Enter 5 to change all your email settings       |");
        System.out.println("|   Enter 6 to see your options again               |");
        System.out.println("|   Enter 7 to import an email list from a CSV      |");
        System.out.println("|   Enter 8 to clear an imported list               |");
        System.out.println("|   Enter 9 to see your imported list               |");
        System.out.println("|   Enter anything else to terminate the program    |");
        System.out.println("|                                                   |");
        System.out.println("=====================================================");
    }
}

