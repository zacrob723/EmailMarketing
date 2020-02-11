import java.util.*;

public class Inputs {
    private String userEmail;
    private String userPass;
    private String recipient;
    private String subject;
    private String message;
    private int numRecipients;

    public Inputs (String user, String pass, String recipient){
        this.userEmail = user;
        this.userPass = pass;
        this.recipient = recipient;
    }

    public Inputs(){
        Scanner kboard = new Scanner(System.in);

        System.out.println("Enter your email to log into.");
        //this.userEmail = kboard.nextLine();
        this.userEmail = "zach@zachrobert.com";

        System.out.println("Enter your password.");
        //this.userPass = kboard.nextLine();
        this.userPass = "9498003Zjr#";

        System.out.println("Enter your recipient.");
        //this.recipient = kboard.nextLine();
        this.recipient = "zacrob723@gmail.com";

        System.out.println("Enter a message subject.");
        //this.subject =  kboard.nextLine();
        this.subject = "Hey this is a bot";

        System.out.println("Enter your message.");
        //this.message = kboard.nextLine();
        this.message =  "I am just testing some stuff";
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public Inputs updateUser(Inputs input, String user) {
        this.userEmail = user;
        return input;
    }

    public Inputs updateUserPass(Inputs input, String pass) {
        this.userPass = pass;
        return input;
    }

    public Inputs updateRecipient(Inputs input, String recip) {
        this.recipient = recip;
        return input;
    }

    public Inputs updateSubject(Inputs input, String subj) {
        this.subject = subj;
        return input;
    }

    public Inputs updateMessage(Inputs input, String mess) {
        this.message = mess;
        return input;
    }
}
