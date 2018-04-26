package master.comporator;

import java.util.Comparator;
import master.Master;

public class ComporatorMasterSurname implements Comparator<Master> {
	public int compare(Master a, Master b) {
		return a.contactData.getSurname().compareTo(b.contactData.getSurname());
	}
}
