<<<<<<< HEAD
import java.io.FileWriter;
import java.io.IOException;

public class MultipleSim {
	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("results.csv");
			writer.append("Total lanes");
			writer.append(',');
			writer.append("Express lanes");
			writer.append(',');
			writer.append("Bagging");
			writer.append(',');
			writer.append("Average interval");
			writer.append('\n');
			writer.append("");
			writer.append(',');
			writer.append(""+ShopperSim.expressLanes);
			writer.append(',');
			if (ShopperSim.baggingTime == 9)
				writer.append("Shopper");
			else writer.append("Employee");
			writer.append(',');
			writer.append(""+ShopperSim.intervalTime);
			writer.append('\n');
			writer.append('\n');
			writer.append("Simulation Time");
			writer.append(',');
			writer.append("Idle Time");
			writer.append(',');
			writer.append("Busy Time");
			writer.append(',');
			writer.append("Busy Based on Service");
			writer.append(',');
			writer.append("Maximum Queue Length");
			writer.append(',');
			writer.append("Avg. Queue Length");
			writer.append(',');
			writer.append("Maximum Waiting Time");
			writer.append(',');
			writer.append("Avg. Waiting Time");
			writer.append(',');
			writer.append("Avg. Service Time");
			writer.append(',');
			writer.append("Shopper Count");
			writer.append('\n');
			for (int i = 10; i < 60; i++) {
				ShopperSim n = new ShopperSim();
				n.setNumOfLanes(i);
				n.run();
				writer.append("" + Stat.totalTime);
				writer.append(',');
				writer.append("" + Stat.idleTime);
				writer.append(',');
				writer.append("" + Stat.busyTime);
				writer.append(',');
				writer.append("" + Stat.averageServiceTime);
				writer.append(',');
				writer.append("" + Stat.maxQLength);
				writer.append(',');
				writer.append("" + (Stat.averageQLength / Stat.totalTime));
				writer.append(',');
				writer.append("" + Stat.maxWait);
				writer.append(',');
				writer.append("" + (Stat.averageWait / Stat.count));
				writer.append(',');
				writer.append("" + (Stat.averageServiceTime / Stat.count));
				writer.append(',');
				writer.append("" + Stat.count);
				writer.append("\n");
				Stat.reset();
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// // ShopperSim n = new ShopperSim();
	// ShopperSim m = new ShopperSim();
	//
	// n.setNumOfLanes(7);
	// m.setNumOfLanes(8);
	//
	//
	// System.out.println("Stats for ShopperSim n");
	// System.out.println();
	// n.run();
	// System.out.println();
	// System.out.println("Stats for ShopperSim m:");
	// m.run();

}
=======

public class MultipleSim {
	public static void main(String[] args){
		for(int i = 3; i < 13; i++){
			ShopperSim n = new ShopperSim();
			n.setNumOfLanes(i);
			n.run();
		}
////		ShopperSim n = new ShopperSim();
//		ShopperSim m = new ShopperSim();
//		
//		n.setNumOfLanes(7);
//		m.setNumOfLanes(8);
//		
//		
//		System.out.println("Stats for ShopperSim n");
//		System.out.println();
//		n.run();
//		System.out.println();
//		System.out.println("Stats for ShopperSim m:");
//		m.run();
		
		
		}
	}
>>>>>>> origin/master
