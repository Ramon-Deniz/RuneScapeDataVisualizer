/**
 * @author Miguel Deniz
 * Created: 12/27/17
 * 
 * Last update: 12/28/17
 */

package RunescapeAPIInterface;

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
}