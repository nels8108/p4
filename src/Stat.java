// Priority Queue and Simulation

// Statistics class for Car Simulation

public class Stat {

	// public methods

	public static void updateQueueStats(double time, int qlen) {

		if (qlen > maxQLength)
			maxQLength = qlen;
		averageQLength += oldQLength * (time - lastQUpdateTime);
		totalTime += time - lastQUpdateTime;
		lastQUpdateTime = time;
		oldQLength = qlen;
	}

	public static void updateBusyTimeStats(double time) {

		busyTime += time - lastUpdateTime;
		lastUpdateTime = time;
	}

	public static void updateIdleTimeStats(double time) {

		idleTime += time - lastUpdateTime;
		lastUpdateTime = time;
	}

	public static void updateServiceTimeStats(double st) {

		averageServiceTime += st;
	}

	public static void updateWaitTimeStats(double time, double enterTime) {

		double wait = time - enterTime;
		if (wait > maxWait)
			maxWait = wait;
		averageWait += wait;
		count++; // another leaves the waiting queue
	}

	public static void displayStats() {
		System.out.println("\n** Simulation Results **\n");
		System.out.println(" Calculated Simulation Time: " + totalTime);
		System.out.println(" Idle Time: " + idleTime);
		System.out.println(" Busy Time: " + busyTime);
		System.out.println(" (Busy Time based on service time: "
				+ averageServiceTime + ")\n");
		System.out.println(" Maximum Queue Length: " + maxQLength);
		System.out.println(" Avg. Queue Length: " + averageQLength / totalTime);
		System.out.println(" Maximum Waiting Time: " + maxWait);
		System.out.println(" Avg. Waiting Time for shoppers through the queue: "
				+ averageWait / (count));
		System.out.println(" Avg. Service Time: " + averageServiceTime /( count ));
		System.out.println(" Number of shoppers through system: " + count);
		System.out.println("\n");
		//System.out.print(totalTime + " " + idleTime + " " + busyTime + " " + averageServiceTime + " " +maxQLength + " " + averageQLength/totalTime + " " + maxWait + " " + averageWait/count + " " + averageServiceTime/count + " " + count);

	} // displayStats
	public static void reset(){
		lastUpdateTime = 0;
		oldQLength = 0;
		lastQUpdateTime = 0;
		count =0;
		totalTime = 0;
		busyTime = 0;
		idleTime =0;
		maxWait = 0;
		averageWait = 0;
		maxQLength = 0;
		averageQLength = 0;
		averageServiceTime = 0;
	}

	// private variables

	 static double lastUpdateTime;
	 static int oldQLength;
	 static double lastQUpdateTime;

	 static int count;
	 static double totalTime;
	 static double busyTime;
	 static double idleTime;
	 static double maxWait;
	 static double averageWait;
	 static int maxQLength;
	 static double averageQLength;
	 static double averageServiceTime;

} // Stat class
