package master.comporator;

import java.util.Comparator;
import master.Master;

public class ComporatorMasterPatronymic implements Comparator<Master> {
	public int compare(Master a, Master b) {
		return a.contactData.getPatronymic().compareTo(b.contactData.getPatronymic());
	}
}
