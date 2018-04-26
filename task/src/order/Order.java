package order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import master.Master;

public class Order {
	private String idOrder;
	private StatusOrder statusOrder;
	private Date dateFiling;
	private Date dateExecution;
	private Date datePlanedExecution;
	private int price;
	private ArrayList<Master> dbMaster;
	
	public Order(String id) {
		idOrder = id;
	}
	
	public Order(String id, StatusOrder status, Date dateFiling, Date datePlanedExecution, int price) {
		this(id);
		this.statusOrder = status;
		this.dateFiling = dateFiling;
		this.datePlanedExecution = datePlanedExecution;
		this.price = price;
		dbMaster = new ArrayList<Master>();
	}	
	
	public String getId() {
		return idOrder;
	}
	
	public StatusOrder getStatusOrder() {
		return statusOrder;
	}
	
	public void setStatusOrder(StatusOrder status) {
		statusOrder = status;
	}
	
	public void setDateFiling(Date date) {
		dateFiling = date;
	}
	
	public Date getDateFiling() {
		return dateFiling;
	}
	
	public void setDateExecution(Date date) {
		dateExecution = date;
	}
	
	public Date getDateExecution() {
		return dateExecution;
	}
	
	public void setDatePlanedExecution(Date date) {
		datePlanedExecution = date;
	}
	
	public Date getDatePlanedExecution() {
		return datePlanedExecution;
	}
	
	public void setPrice(int prace) {
		this.price = prace;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void addMaster(Master master) {
		dbMaster.add(master);
	}
	
	public boolean subMaster(Master master) {
		return dbMaster.remove(master);
	}
	
	public List<Master> getListMaster(){
		return dbMaster;
	}
}
