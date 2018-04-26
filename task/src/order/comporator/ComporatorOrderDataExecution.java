package order.comporator;

import java.util.Comparator;
import order.Order;

public class ComporatorOrderDataExecution implements Comparator<Order> {
	public int compare(Order a, Order b) {
		return a.getDateExecution().compareTo(b.getDateExecution());
	}
}
