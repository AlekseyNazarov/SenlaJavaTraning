package master.comporator;

import java.util.Comparator;
import master.Master;

public class ComporatorMasterName implements Comparator<Master> {
	public int compare(Master a, Master b) {
		return a.contactData.getName().compareTo(b.contactData.getName());
	}
}
