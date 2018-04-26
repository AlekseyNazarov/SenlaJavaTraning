package contactData;

public class ContactDataPerson extends ContactData {
	private String surname;
	private String patronymic;
	
	public ContactDataPerson() {
	}
	
	public ContactDataPerson(String surname, String patronymic, String name, String phone, String addres) {
		super(name, phone, addres);
		this.surname = surname;
		this.patronymic = patronymic;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPatronymic() {
		return patronymic;
	}
	
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
}
