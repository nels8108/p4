// adapted from class code CarSim

public class ShopperSim {

	// public variables

	static PQ agenda = new PQ();
	static Checker[] lane; // the checker array
	static int baggingTime = 5; // employee vs customer bagging
	static int expressLanes = 2;
	static int intervalTime = 30;
	static int runTime = 10000;
	static int numOfLanes = 12;

	// methods
	
	public static double randomIntArrival() {
		// returns an interval time with the given distributions
		int arrivalDist[] = { 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6,
				6, 6, 7, 7 }; // distribution of arrival according to the table given
		int index = (int) Math.floor((19 - 0) * Math.random() + 0.5); // calculates a random index for the distribution above
		int caseNumb = arrivalDist[index];
		switch(caseNumb) {
		case 1: return intervalTime + .75 * intervalTime;
		case 2: return intervalTime + .50 * intervalTime;
		case 3: return intervalTime + .20 * intervalTime;
		case 4: return intervalTime;
		case 5: return intervalTime - .20 * intervalTime;
		case 6: return intervalTime - .50 * intervalTime;
		case 7: return intervalTime - .75 * intervalTime;
		default: return -1;
		}
	}
	
	public static int getBaggingTime() {
		return baggingTime;
	}

	public static void main(String[] args){
		int distArray[] = { 10, 10, 10, 20, 20, 20, 20, 30, 30, 30, 30, 30, 40,  // distribution array for number of items in cart
				40, 40, 40, 50, 50, 50, 50, 60, 60, 60, 70, 70, 70, 80, 80, 90,
				100 };
		agenda = new PQ();
		agenda.add(new ShopperMaker(randomIntArrival(), distArray), 0); // first instance of ShopperMaker
		
		lane = new Checker[numOfLanes]; // instantiating the checkout lanes
		for (int i=0; i<lane.length; i++)
			lane[i] = new Checker();
		
		while (agenda.getCurrentTime() <= runTime) // running the simulation 
			agenda.remove().run();
		
		Stat.displayStats();
	} // run method
	
} // ShopperSim class