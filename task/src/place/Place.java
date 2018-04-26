package place;

public class Place {
	private String idPlace;
	private StatusPlace statusPlace;
	
	public Place(String id) {
		idPlace = id;
	}
	
	public void setStatusPlace(StatusPlace status) {
		statusPlace = status;
	}
	
	public StatusPlace getStatusPlace() {
		return statusPlace;
	}
	
	public String getId() {
		return idPlace;
	}
}
