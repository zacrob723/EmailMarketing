import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SLLMail {
    private String SMTP_HOST_NAME = "box.zachrobert.com";
    private int SMTP_HOST_PORT = 587;
    private String SMTP_AUTH_USER = "zach@zachrobert.com";
    private String SMTP_AUTH_PWD  = "";
    private MimeMessage message;
    private Session mailSession;
    private Transport transport;

    private Properties props = new Properties();

    public void test(Inputs input) throws Exception{

        inputProperties();

        mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication
            getPasswordAuthentication() {

                return new PasswordAuthentication(input.getUserEmail(), input.getUserPass());
            }
        });
        mailSession.setDebug(true);
        transport = mailSession.getTransport();

        //setMessage(input, mailSession, transport);
        message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(input.getUserEmail()));
        message.setSubject(input.getSubject());
        message.setContent(input.getMessage(), "text/plain");

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(input.getRecipient()));


        //transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, input.getUserEmail(), input.getUserPass());

        transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, input.getUserEmail(), input.getUserPass());
        transport.send(message);
        transport.close();
    }

    /*public void setMessage(Inputs input, Session mailSession, Transport transport)
    {
        message = new MimeMessage(mailSession);
        message.setSubject(input.getSubject());
        message.setContent(input.getMessage(), "text/plain");

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(input.getRecipient()));
    }
*/


    public void inputProperties()
    {
        this.props.put("mail.transport.protocol", "smtp");
        this.props.put("mail.smtp.host", SMTP_HOST_NAME);
        this.props.put("mail.smtp.port", "587");
        this.props.put("mail.smtp.starttls.enable", "true");
        this.props.put("mail.smtp.auth", "true");
        //this.props.put("mail.smtps.quitwait", "false");
        return;
    }

}
