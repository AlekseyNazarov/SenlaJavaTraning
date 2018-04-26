package master;

import java.util.ArrayList;
import java.util.List;
import contactData.ContactDataPerson;
import order.Order;

public class Master {
	public ContactDataPerson contactData;
	private String idMaster;
	private StatusMaster statusMaster;
	private ArrayList<Order> dbOrder;
	
	public Master(String id) {
		contactData = new ContactDataPerson();
		dbOrder = new ArrayList<Order>();
		this.idMaster = id;
	}
	
	public Master(String id, ContactDataPerson contactData) {
		this(id);
		this.contactData = contactData;
	}
	
	public Master(String id, String surname, String patronymic, String name, String phone, String addres) {
		this(id, new ContactDataPerson(surname, patronymic, name, phone, addres));
	}
	
	public void setStatus(StatusMaster status) {
		statusMaster = status;
	}
	
	public StatusMaster getStatus() {
		return statusMaster;
	}
	
	public String getId() {
		return idMaster;
	}
	
	public void addOrder(Order order) {
		dbOrder.add(order);
	}
	
	public boolean subOrder(Order order) {
		return dbOrder.remove(order);
	}
	
	public List<Order> getListOrder(){
		return dbOrder;
	}
}
