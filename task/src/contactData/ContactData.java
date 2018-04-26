package contactData;

public class ContactData {
	private String name;
	private String phone;
	private String addres;
	
	public ContactData(String name, String phone, String addres) {
		this.name = name;
		this.phone = phone;
		this.addres = addres;
	}
	
	public ContactData() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddres() {
		return addres;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
