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
	 * Конструктор
	 * 
	 * @param id Уникальный идентификатор
	 */
	public Garage(String id) {
		idGarage = id;
		dbPlace = new ArrayList<Place>();
		dbOrder = new ArrayList<Order>();
		dbMaster = new ArrayList<Master>();
	}
	
	/**
	 * Добавление нового места в гараж
	 * 
	 * @param place Новое место
	 */	
	public void addPlace(Place place) {
		if(dbPlace.size() == 0) {
			dbPlace.add(new Place("grg_0"));
			return;
		}
		
		dbPlace.add(new Place("grg_" + String.valueOf(Integer.valueOf(dbPlace.get(dbPlace.size()).getId().substring(3)) + 1)));		
	}
	
	/**
	 * Удаление места из гаража
	 * 
	 * @param place Удаляемое место
	 * @return Статус выполнения
	 */
	public boolean subPlace(Place place) {
		return dbPlace.remove(place);
	}
	
	/**
	 * Добавление нового мастера в гараж
	 * 
	 * @param master Новый мастер
	 */
	public void addMaster(Master master) {
		if(dbMaster.size() == 0) {
			dbMaster.add(new Master("mstr_0"));
			return;
		}
		
		dbPlace.add(new Place("grg_" + String.valueOf(Integer.valueOf(dbMaster.get(dbMaster.size()).getId().substring(4)) + 1)));	
	}
	
	/**
	 * Удаление мастера из гаража
	 * 
	 * @param master Удаляемый мастер
	 * @return Статус выполнения
	 */
	public boolean subMaster(Master master) {
		return dbMaster.remove(master);
	}
	
	/**
	 * Добавление нового заказа для гаража
	 * 
	 * @param order Добавляемый заказ
	 */
	public void addOrder(Order order) {
		if(dbOrder.size() == 0) {
			dbOrder.add(new Order("ord_0"));
			return;
		}
		
		dbPlace.add(new Place("grg_" + String.valueOf(Integer.valueOf(dbOrder.get(dbOrder.size()).getId().substring(3)) + 1)));	
	}
	
	/**
	 * Удаление заказа из гаража
	 * 
	 * @param order Удаляемый заказ
	 * @return Статус выполнения
	 */
	public boolean subOrder(Order order) {
		return dbOrder.remove(order);
	}
	
	/**
	 * Список мест в гараже по статусу занятости 
	 * 
	 * @param statusPlace Статус занятости
	 * @return Список мест в гараже
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
	 * Сортировка списка заказов
	 * 
	 * @param attribute Атрибут сортировки
	 * @param list Сортируемый список заказов
	 * @return Отсортированный список заказов
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
	 * Сортировка списка заказов
	 * 
	 * @param attribute Атрибут сртировки
	 * @return Отсортированный список заказов
	 */
	public List<Order> getListOrder(AttributeSortOrder attribute){
		return getListOrder(attribute, (List<Order>)dbOrder.clone());
	}
	
	/**
	 * Список заказов по статусу выполнения
	 * 
	 * @param status Искомый статус
	 * @return Найденные заказы
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
	 * Сортировка списка заказов по статусу выполнения
	 * 
	 * @param attribute Атрибут сортировки
	 * @param status Статус выполнения
	 * @return Отсортированный список заказов
	 */
	public List<Order> getListOrder(AttributeSortOrder attribute, StatusOrder status){		
		return getListOrder(attribute, getListOrder(status));
	}
	
	/**
	 * Сортировка списка мастеров
	 * 
	 * @param attribute Атрибут сортировки
	 * @param list Сортируемый список
	 * @return Отсортированный список
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
	 * Сортировка списка мастеров
	 *  
	 * @param attribute Атрибут сортировки
	 * @return Отсортированный список мастеров
	 */
	public List<Master> getListMaster(AttributeSortMaster attribute){
		return getListMaster(attribute, (List<Master>)dbMaster.clone());
	}
	
	/**
	 * Поиск мастеров по статусу занятости
	 * 
	 * @param status Статус занятости
	 * @return Искомый список мастеров
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
	 * Отсортированный список мастеров по статусу занятости
	 * 
	 * @param attribute Атрибут сортировки
	 * @param status Статус занятости мастера
	 * @return Список мастеров
	 */
	public List<Master> getListMaster(AttributeSortMaster attribute, StatusMaster status){
		return getListMaster(attribute, getListMaster(status));
	}
	
	/**
	 * Сортировка и поиск заказов
	 * 
	 * @param statusOrder Статус заказа
	 * @param dateBegin Дата начала промежутка
	 * @param dateEnd  Дата окончания промежутка
	 * @param attribute Атрибут сортировки
	 * @return Искомый список заказов
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
	 * Количество свободных мест
	 * 
	 * @return Количество
	 */
	public int getCountFreePlace() {
		return getListPlace(StatusPlace.freely).size();		
	}
	
	/**
	 * Количество свободных мест на конкретную дату
	 * 
	 * @param date Дата 
	 * @return Количество свободных мест
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
	 * Количество совободных мастеров на конкретную дату
	 * 
	 * @param date Дата
	 * @return Количество свободных мастеров
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
	 * Количество свободных мест для обслуживания мастером на конкретную дату
	 * 
	 * @param date Дата
	 * @return Количество свободных мест
	 */
	public int getCountFreeMasterDate(Date date) {
		return Math.min(getCountFreeMaster(date), getCountFreePlace(date));
	}
	
	/**
	 * Ближайщая дата когда освободиться мастер
	 * 
	 * @return Дата
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
	 * Ближайщая дата когда освободиться место
	 * 
	 * @return Дата
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
	 * Получение ближайщей свободной даты для обслуживанием мастера на свободном месте
	 * 
	 * @return Ближайщая свободная дата
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
