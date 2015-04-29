
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
