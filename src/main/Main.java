package main;

import StatTracker.XPCalculator;

public class Main {

	public static void main(String[] args) {

		//for (int i = 5; i < 100; i++) {
			//RunescapeResponse resp = RunescapeAPIInterface.getItem(""+i);
			//if(resp.name!=null)
				//System.out.println("Item: "+resp.name+"   Price: "+resp.current_price + " i = " + i);
		//}
		
		System.out.println(XPCalculator.XPToNextLevel(5000000, 99));
	}
}
