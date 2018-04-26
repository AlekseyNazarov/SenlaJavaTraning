package order.comporator;

import java.util.Comparator;

import order.Order;

public class ComporatorOrderDataFiling implements Comparator<Order> {
	public int compare(Order a, Order b) {
		return a.getDateFiling().compareTo(b.getDateFiling());
	}
}
