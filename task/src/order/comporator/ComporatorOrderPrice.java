package order.comporator;

import java.util.Comparator;

import order.Order;

public class ComporatorOrderPrice implements Comparator<Order> {
	public int compare(Order a, Order b) {
		return ((Integer)a.getPrice()).compareTo((Integer)b.hashCode());
	}
}
