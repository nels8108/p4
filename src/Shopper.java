import java.util.Arrays;

// adapted from class code Car

public class Shopper {

	public Shopper(double t, int items) {
		arrivalTime = t;
		itemCount = items;
		
		// find and add this Shopper to the shortest lane
		Checker[] lane = ShopperSim.lane;
		int minIndex = 0;
		for (int i=0; i<lane.length; i++) {
			//System.out.println("lane " + i + " size: " + lane[i].waitline.length());
			if (lane[i].waitline.length() < lane[minIndex].waitline.length()) {
				minIndex = i;
			}
		}
		
		//System.out.println(Arrays.toString(lane));
		ShopperSim.lane[minIndex].enter(this);
		//System.out.println("added to lane " + minIndex);
		//System.out.println("# of items" + this.itemCount);
		
		if (!ShopperSim.lane[minIndex].isBusy())
			new CheckerEvent(ShopperSim.lane[minIndex], ShopperSim.getBaggingTime()).run(); // wake-up CheckerEvent if idle
	}

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
