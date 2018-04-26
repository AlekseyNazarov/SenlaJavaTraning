package order.comporator;

import java.util.Comparator;

import order.Order;

public class ComporatorOrderDataPlanedExecution implements Comparator<Order> {
	public int compare(Order a, Order b) {
		return a.getDatePlanedExecution().compareTo(b.getDatePlanedExecution());
	}
}
