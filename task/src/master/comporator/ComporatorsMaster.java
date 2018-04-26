package master.comporator;

import java.util.Comparator;
import master.Master;

public class ComporatorsMaster {
	public static Comparator<Master> alphabet = new ComporatorMasterSurname().thenComparing(new ComporatorMasterName().thenComparing(new ComporatorMasterPatronymic()));
}
