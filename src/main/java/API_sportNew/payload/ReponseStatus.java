package API_sportNew.payload;

public class ReponseStatus {
private String message;
private int Status;

/*
 * public ReponseStatus(String message, int status) { super(); this.message =
 * message; Status = status; }
 */
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getStatus() {
	return Status;
}
public void setStatus(int status) {
	Status = status;
}

}
