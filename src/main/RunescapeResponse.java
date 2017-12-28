/**
 * @author Miguel Deniz
 * Created: 12/27/17
 * 
 * Last update: 12/28/17
 */

package main;

public class RunescapeResponse {
	int id;
	String type;
	String name;
	String description;
	boolean members;

	String current_trend;
	int current_price;

	String today_trend;
	int today_price;

	String day30_trend;
	String day30_change;

	String day90_trend;
	String day90_change;

	String day180_trend;
	String day180_change;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("ID: " + id + System.lineSeparator());
		builder.append("Type: " + type + System.lineSeparator());
		builder.append("Name: " + name + System.lineSeparator());
		builder.append("Description: " + description + System.lineSeparator());
		builder.append("Members: " + members + System.lineSeparator());

		builder.append("Current trend: " + current_trend + System.lineSeparator());
		builder.append("Current price: " + current_price + System.lineSeparator());

		builder.append("Today trend: " + today_trend + System.lineSeparator());
		builder.append("Today price: " + today_price + System.lineSeparator());

		builder.append("Day 30"+ System.lineSeparator());
		builder.append("\tTrend: " + day30_trend + System.lineSeparator());
		builder.append("\tChange: " + day30_change + System.lineSeparator());

		builder.append("Day 90"+ System.lineSeparator());
		builder.append("\tTrend: " + day90_trend + System.lineSeparator());
		builder.append("\tChange: " + day90_change + System.lineSeparator());

		builder.append("Day 180"+ System.lineSeparator());
		builder.append("\tTrend: " + day180_trend + System.lineSeparator());
		builder.append("\tTCange: " + day180_change + System.lineSeparator());

		return builder.toString();
	}
}