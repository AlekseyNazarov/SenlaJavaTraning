package service;

import contactData.ContactData;
import garage.Garage;
import master.AttributeSortMaster;
import master.Master;
import master.StatusMaster;
import order.Order;
import place.Place;

import java.util.ArrayList;
import java.util.List;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;

public class Service {
	public ContactData contactData;
	private ArrayList<Garage> dbGarage;
	private String path;
	
	public Service() {
		dbGarage = new ArrayList<Garage>();
		contactData = new ContactData();
	}
	
	public Service(ContactData contactData) {
		dbGarage = new ArrayList<Garage>();
		this.contactData = contactData;
	}
	
	public Service(String name, String phone, String addres) {
		dbGarage = new ArrayList<Garage>();
		contactData = new ContactData(name, phone, addres);
	}
	
	public Service(String path) {
		
	}
	
	private void loadOfFile(String path) {
		this.path = path;
	}
	
	private String statusMasterToString(StatusMaster status) {
		switch (status) {
		case free:{
			return "free";
		}
		case busy:{
			return "busy";
		}
		}
		
		return "";
	}
	
	private void saveInFile() {
		if(path == null) {
			path = "service.txt";
		}
		
		FileWorker fileWorker = new TextFileWorker(path);
		List<Master> listMaster;
		List<Order> listOrder;
		List<Place> listPlace;
		ArrayList<String> inFile = new ArrayList<String>();
		String buff = "";
		String tmp;
		
		for(Garage garage : dbGarage) {
			inFile.add("<Garagers>");
			
			
			
			listMaster = garage.getListMaster(AttributeSortMaster.withoutSort);			
			
			inFile.add("<Masters>");
			for(Master master : listMaster) {
				buff += "#";
				
				buff += master.getId();
				buff += "#";
				
				tmp = master.contactData.getSurname();
				if(tmp != null) {
					buff += tmp;
				}
				
				buff += "$";
				tmp = master.contactData.getName();
				if(tmp != null) {
					buff += tmp;
				}
				buff += "$";
				
				tmp = master.contactData.getPatronymic();
				if(tmp != null) {
					buff += tmp;
				}
				buff += "#";
				
				buff += statusMasterToString(master.getStatus());
				buff += "#";
				
				listOrder = master.getListOrder();
				for(Order order : listOrder) {
					buff += order.getId() + "$";
				}
				buff += "#";
				
				inFile.add(buff);
				buff = "";
			}
			
			
			
		}
	}
	
	public void addGarage(Garage garage) {
		dbGarage.add(garage);
	}
	
	public boolean subGarage(Garage garage) {
		return dbGarage.remove(garage);
	}
	
	public List<Garage> getListGarage(){
		return dbGarage;
	}
	
}
