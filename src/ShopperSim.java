
// adapted from class code CarSim

public class ShopperSim {

	// public variables

	static PQ agenda = new PQ();
	static Checker[] lane; // the checker array
	static int baggingTime = 9; // employee vs customer bagging
	static int expressLanes = 0;
	static int intervalTime = 30;
	static int runTime = 10000;
	int numOfLanes;

	// methods
	public static void setRunTime(int a){
		runTime = a;
		
	}
	public void setNumOfLanes(int a){
		numOfLanes = a;
		
	}
	
	public static void setBaggingTime(int a){
		baggingTime = a;
	}
	
	public static double randomIntArrival() {
		int arrivalDist[] = { 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6,
				6, 6, 7, 7 };
		int index = (int) Math.floor((19 - 0) * Math.random() + 0.5);
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

	public void run(){
		int distArray[] = { 10, 10, 10, 20, 20, 20, 20, 30, 30, 30, 30, 30, 40,  // distribution array for number of items in cart
				40, 40, 40, 50, 50, 50, 50, 60, 60, 60, 70, 70, 70, 80, 80, 90,
				100 };
		agenda = new PQ();
		agenda.add(new ShopperMaker(randomIntArrival(), distArray), 0);  //randomIntArrival()
		
		lane = new Checker[numOfLanes]; // insantiating the checkout lanes
		for (int i=0; i<lane.length; i++)
			lane[i] = new Checker();
		
		while (agenda.getCurrentTime() <= runTime) // running the simulation 
			agenda.remove().run();
//		System.out.println(numOfLanes);
		
//		Stat.displayStats(); //outputting the stats
		
//		Stat.reset();
	}
}