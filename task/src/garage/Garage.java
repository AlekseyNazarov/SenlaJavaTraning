package garage;

import contactData.ContactData;
import master.AttributeSortMaster;
import master.Master;
import master.StatusMaster;
import master.comporator.ComporatorsMaster;
import order.AttributeSortOrder;
import order.Order;
import order.StatusOrder;
import order.comporator.ComporatorsOrder;
import place.Place;
import place.StatusPlace;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

public class Garage {
	private String idGarage;
	public ContactData contactData;
	private ArrayList<Place> dbPlace;
	private ArrayList<Master> dbMaster;
	private ArrayList<Order> dbOrder;
	
	/**
	 * �����������
	 * 
	 * @param id ���������� �������������
	 */
	public Garage(String id) {
		idGarage = id;
		dbPlace = new ArrayList<Place>();
		dbOrder = new ArrayList<Order>();
		dbMaster = new ArrayList<Master>();
	}
	
	/**
	 * ���������� ������ ����� � �����
	 * 
	 * @param place ����� �����
	 */	
	public void addPlace(Place place) {
		if(dbPlace.size() == 0) {
			dbPlace.add(new Place("grg_0"));
			return;
		}
		
		dbPlace.add(new Place("grg_" + String.valueOf(Integer.valueOf(dbPlace.get(dbPlace.size()).getId().substring(3)) + 1)));		
	}
	
	/**
	 * �������� ����� �� ������
	 * 
	 * @param place ��������� �����
	 * @return ������ ����������
	 */
	public boolean subPlace(Place place) {
		return dbPlace.remove(place);
	}
	
	/**
	 * ���������� ������ ������� � �����
	 * 
	 * @param master ����� ������
	 */
	public void addMaster(Master master) {
		if(dbMaster.size() == 0) {
			dbMaster.add(new Master("mstr_0"));
			return;
		}
		
		dbPlace.add(new Place("grg_" + String.valueOf(Integer.valueOf(dbMaster.get(dbMaster.size()).getId().substring(4)) + 1)));	
	}
	
	/**
	 * �������� ������� �� ������
	 * 
	 * @param master ��������� ������
	 * @return ������ ����������
	 */
	public boolean subMaster(Master master) {
		return dbMaster.remove(master);
	}
	
	/**
	 * ���������� ������ ������ ��� ������
	 * 
	 * @param order ����������� �����
	 */
	public void addOrder(Order order) {
		if(dbOrder.size() == 0) {
			dbOrder.add(new Order("ord_0"));
			return;
		}
		
		dbPlace.add(new Place("grg_" + String.valueOf(Integer.valueOf(dbOrder.get(dbOrder.size()).getId().substring(3)) + 1)));	
	}
	
	/**
	 * �������� ������ �� ������
	 * 
	 * @param order ��������� �����
	 * @return ������ ����������
	 */
	public boolean subOrder(Order order) {
		return dbOrder.remove(order);
	}
	
	/**
	 * ������ ���� � ������ �� ������� ��������� 
	 * 
	 * @param statusPlace ������ ���������
	 * @return ������ ���� � ������
	 */
	public List<Place> getListPlace(StatusPlace statusPlace){
		List<Place> tmp = new ArrayList<Place>();
		for(Place place : dbPlace) {
			if(place.getStatusPlace() == statusPlace) {
				tmp.add(place);
			}
		}
		
		return tmp;
	}
	
	/**
	 * ���������� ������ �������
	 * 
	 * @param attribute ������� ����������
	 * @param list ����������� ������ �������
	 * @return ��������������� ������ �������
	 */
	private List<Order> getListOrder(AttributeSortOrder attribute, List<Order> list){ 
		switch (attribute) {
		case dateFiling:{
			list.sort(ComporatorsOrder.dateFiling);	
			break;
		}
		
		case dateExecution:{
			list.sort(ComporatorsOrder.dateExecution);	
			break;
		}
		
		case datePlanedExecution:{
			list.sort(ComporatorsOrder.datePlanedExecution);	
			break;
		}
		
		case price:{
			list.sort(ComporatorsOrder.price);	
			break;
		}
		
		case withoutSort:{
			break;
		}
		}
		
		return list;
	}
	
	/**
	 * ���������� ������ �������
	 * 
	 * @param attribute ������� ���������
	 * @return ��������������� ������ �������
	 */
	public List<Order> getListOrder(AttributeSortOrder attribute){
		return getListOrder(attribute, (List<Order>)dbOrder.clone());
	}
	
	/**
	 * ������ ������� �� ������� ����������
	 * 
	 * @param status ������� ������
	 * @return ��������� ������
	 */
	public List<Order> getListOrder(StatusOrder status){
		List<Order> list = new ArrayList<Order>();
		
		for(Order order : dbOrder) {
			if(order.getStatusOrder() == status) {
				list.add(order);
			}
		}
		
		return list;
	}
	
	/**
	 * ���������� ������ ������� �� ������� ����������
	 * 
	 * @param attribute ������� ����������
	 * @param status ������ ����������
	 * @return ��������������� ������ �������
	 */
	public List<Order> getListOrder(AttributeSortOrder attribute, StatusOrder status){		
		return getListOrder(attribute, getListOrder(status));
	}
	
	/**
	 * ���������� ������ ��������
	 * 
	 * @param attribute ������� ����������
	 * @param list ����������� ������
	 * @return ��������������� ������
	 */
	private List<Master> getListMaster(AttributeSortMaster attribute, List<Master> list) {
		switch(attribute) {
		case alphabet:{
			list.sort(ComporatorsMaster.alphabet);
			break;
		}
		
		case withoutSort:{
			break;
		}
		}
		
		return list;
	}
	
	/**
	 * ���������� ������ ��������
	 *  
	 * @param attribute ������� ����������
	 * @return ��������������� ������ ��������
	 */
	public List<Master> getListMaster(AttributeSortMaster attribute){
		return getListMaster(attribute, (List<Master>)dbMaster.clone());
	}
	
	/**
	 * ����� �������� �� ������� ���������
	 * 
	 * @param status ������ ���������
	 * @return ������� ������ ��������
	 */
	public List<Master> getListMaster(StatusMaster status){
		List<Master> list = new ArrayList<Master>();
		
		for(Master master : dbMaster) {
			if(master.getStatus() == status) {
				list.add(master);
			}
		}
		
		return list;
	}
	
	/**
	 * ��������������� ������ �������� �� ������� ���������
	 * 
	 * @param attribute ������� ����������
	 * @param status ������ ��������� �������
	 * @return ������ ��������
	 */
	public List<Master> getListMaster(AttributeSortMaster attribute, StatusMaster status){
		return getListMaster(attribute, getListMaster(status));
	}
	
	/**
	 * ���������� � ����� �������
	 * 
	 * @param statusOrder ������ ������
	 * @param dateBegin ���� ������ ����������
	 * @param dateEnd  ���� ��������� ����������
	 * @param attribute ������� ����������
	 * @return ������� ������ �������
	 */
	public List<Order> getListOrder(StatusOrder statusOrder, Date dateBegin, Date dateEnd, AttributeSortOrder attribute){
		List<Order> tmp = getListOrder(statusOrder);
		List<Order> list = new ArrayList<Order>();
		
		for(Order order : tmp) {
			if((order.getDateFiling().after(dateBegin)) && (order.getDateFiling().before(dateEnd))) {
				list.add(order);
			}
		}
		
		return getListOrder(attribute, list);
	}
	
	/**
	 * ���������� ��������� ����
	 * 
	 * @return ����������
	 */
	public int getCountFreePlace() {
		return getListPlace(StatusPlace.freely).size();		
	}
	
	/**
	 * ���������� ��������� ���� �� ���������� ����
	 * 
	 * @param date ���� 
	 * @return ���������� ��������� ����
	 */
	private int getCountFreePlace(Date date) {
		int count = 0;
		
		for(Order order : dbOrder) {
			if((order.getStatusOrder() == StatusOrder.inProcess) && (order.getDatePlanedExecution().after(date))) {
				++count;
			}
		}		
		
		return dbPlace.size() - count;
	}
	
	/**
	 * ���������� ���������� �������� �� ���������� ����
	 * 
	 * @param date ����
	 * @return ���������� ��������� ��������
	 */
	private int getCountFreeMaster(Date date) {
		int count = 0;
		List<Order> tmp;
		
		for(Master master : dbMaster) {
			tmp = master.getListOrder();
			if((master.getStatus() == StatusMaster.free) || (tmp.get(tmp.size() - 1).getDatePlanedExecution().after(date))) {
				++count;
			}
		}
		
		return count;
	}
	
	/**
	 * ���������� ��������� ���� ��� ������������ �������� �� ���������� ����
	 * 
	 * @param date ����
	 * @return ���������� ��������� ����
	 */
	public int getCountFreeMasterDate(Date date) {
		return Math.min(getCountFreeMaster(date), getCountFreePlace(date));
	}
	
	/**
	 * ��������� ���� ����� ������������ ������
	 * 
	 * @return ����
	 */
	private Date getNearDateFreeMaster() {
		Date tmpDate = new Date(Long.MAX_VALUE);
		List<Order> tmpList;
		
		for(Master master : dbMaster) {
			tmpList = master.getListOrder();
			if(tmpList.get(tmpList.size() - 1).getDatePlanedExecution().after(tmpDate)) {
				tmpDate = tmpList.get(tmpList.size() - 1).getDatePlanedExecution();
			}
		}
		
		return tmpDate;
	}
	
	/**
	 * ��������� ���� ����� ������������ �����
	 * 
	 * @return ����
	 */
	private Date getNearDateFreePlace() {
		Date tmpDate = new Date(Long.MAX_VALUE);
		List<Order> tmpList = getListOrder(StatusOrder.inProcess);
		
		for(Order order : tmpList) {
			if(order.getDatePlanedExecution().after(tmpDate)) {
				tmpDate = order.getDatePlanedExecution();
			}
		}
		
		return tmpDate;
	}
	
	/**
	 * ��������� ��������� ��������� ���� ��� ������������� ������� �� ��������� �����
	 * 
	 * @return ��������� ��������� ����
	 */
	public Date getNearFreeDate() {
		if((getListPlace(StatusPlace.freely).size() > 0) && (getListMaster(StatusMaster.free).size() > 0)) {
			return new Date(System.currentTimeMillis());
		}
		
		Date nearDateMaster = getNearDateFreeMaster();
		Date nearDatePlace = getNearDateFreePlace();
		
		return (nearDateMaster.after(nearDatePlace)) ? nearDatePlace : nearDateMaster;
	}
}
