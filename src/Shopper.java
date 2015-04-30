// adapted from class code Car

public class Shopper {

	public Shopper(double t, int items) {
		arrivalTime = t;
		itemCount = items;
		
		// find and add this Shopper to the shortest lane
		Checker[] lane = ShopperSim.lane;
		int minIndex = 0;
		for (int i=0; i<lane.length; i++) {
			// if express lanes are used, this will check to see if customer has 10 or less
			// items and find the shortest lane among the express lanes
			if (i < ShopperSim.expressLanes && itemCount <= 10) 
				if (lane[i].waitline.length() < lane[minIndex].waitline.length())
					minIndex = i;
			if (lane[i].waitline.length() < lane[minIndex].waitline.length()) {
				minIndex = i;
			}
		}
		
		// add itself to the queue of the shortest checker lane
		ShopperSim.lane[minIndex].enter(this);
		
		// wake-up CheckerEvent if idle
		if (!ShopperSim.lane[minIndex].isBusy())
			// new CheckerEvent with Checker with the shortest line, and bagging time
			new CheckerEvent(ShopperSim.lane[minIndex], ShopperSim.getBaggingTime()).run();
	}

	// methods
	
	public double getArrivalTime() {
		return arrivalTime;
	}

	public double getItemCount() {
		return itemCount;
	}

	// private variables

	private double arrivalTime;
	private double itemCount;

} // Shopper class
