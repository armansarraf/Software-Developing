package Model;

public class SendEmail {
    private User user;
    private RegisteredUser registeredUser;
    private ShowTime showTime;
    private Theater theater;

    public SendEmail(){

    }

    public void sendEmailToUser(User user, ShowTime showTime){
     
    	System.out.println("Email has been successfully sent");
    }
}