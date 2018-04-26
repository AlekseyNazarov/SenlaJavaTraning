package order.comporator;

import java.util.Comparator;
import order.Order;

public class ComporatorsOrder {
	public static Comparator<Order> price = new ComporatorOrderPrice();
	public static Comparator<Order> dateExecution = new ComporatorOrderDataExecution();
	public static Comparator<Order> dateFiling = new ComporatorOrderDataFiling();
	public static Comparator<Order> datePlanedExecution = new ComporatorOrderDataPlanedExecution();
}
