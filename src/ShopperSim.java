// adapted from class code CarSim

public class ShopperSim {

	// public variables

	static PQ agenda = new PQ();
	static Checker[] lane; // the checker array
	static int baggingTime = 9; // employee vs customer bagging
	static int runTime = 10000;
	static int numOfLanes = 10;

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
		int index = (int) Math.floor((19 - 0) * Math.random() + 0 + 0.5);
		int caseNumb = arrivalDist[index];
		switch(caseNumb) {
		case 1: return 30 + .75 * 30;
		case 2: return 30 + .50 * 30;
		case 3: return 30 + .20 * 30;
		case 4: return 30;
		case 5: return 30 - .20 * 30;
		case 6: return 30 - .50 * 30;
		case 7: return 30 - .75 * 30;
		default: return -1;
		}
	}
	
	public static int getBaggingTime() {
		return baggingTime;
	}

	public static void main(String args[]) {

		int distArray[] = { 10, 10, 10, 20, 20, 20, 20, 30, 30, 30, 30, 30, 40,  // distribution array for number of items in cart
				40, 40, 40, 50, 50, 50, 50, 60, 60, 60, 70, 70, 70, 80, 80, 90,
				100 };

		agenda.add(new ShopperMaker(randomIntArrival(), distArray), 0);  //randomIntArrival()
		
		lane = new Checker[numOfLanes]; // insantiating the checkout lanes
		for (int i=0; i<lane.length; i++)
			lane[i] = new Checker();
		
		while (agenda.getCurrentTime() <= runTime) // running the simulation 
			agenda.remove().run();
		System.out.println(numOfLanes);
		Stat.displayStats(); //outputting the stats
		
		double temp = 0;  // can be commented out, just checking if the randomIntArrival is close to thirty like we wanted it to be
		int count =0;
		for(int i = 0; i <= 30; i++){
			temp = randomIntArrival();
			System.out.println(temp);
			count +=temp;
		}
		System.out.println("Average arrival "+ count/29);
	} // main method
//	public void run(){
//		int distArray[] = { 10, 10, 10, 20, 20, 20, 20, 30, 30, 30, 30, 30, 40,  // distribution array for number of items in cart
//				40, 40, 40, 50, 50, 50, 50, 60, 60, 60, 70, 70, 70, 80, 80, 90,
//				100 };
//		agenda = new PQ();
//		agenda.add(new ShopperMaker(randomIntArrival(), distArray), 0);  //randomIntArrival()
//		
//		lane = new Checker[numOfLanes]; // insantiating the checkout lanes
//		for (int i=0; i<lane.length; i++)
//			lane[i] = new Checker();
//		
//		while (agenda.getCurrentTime() <= runTime) // running the simulation 
//			agenda.remove().run();
//		System.out.println(numOfLanes);
//		
//		Stat.displayStats(); //outputting the stats
//		Stat.reset();
//	}

} // ShopperSim class
