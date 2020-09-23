package servlet.message;

public class Message {
	private String userName;
	private String userMessage;
	private String date;
	
	public Message(final String userName, final String userMessage, final String date) {
		this.userName = userName;
		this.userMessage = userMessage;
		this.date = date;
	}
	
	@Override
    public String toString() {
        return "Date: " + this.date + "<br />" + this.userName + ": " + this.userMessage + "<hr />";
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getName() {
        return this.userName;
    }
    
    public String getMessage() {
        return  this.userMessage + "<br />";
    }
}
