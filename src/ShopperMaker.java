// adapted from class code Shopper

public class ShopperMaker implements Event {

	// constructor

	public ShopperMaker(double intval, int[] itmDist) {
		interval = intval;
		itemDist = new int[itmDist.length];
		System.arraycopy(itmDist, 0, itemDist, 0, itmDist.length);
	}

	// methods

	private int intRandomInterval(double low, double high) {
		return (int) Math.floor((high - low) * Math.random() + low + 0.5);
	}

	private int selectItemCount() {
		int temp = itemDist[intRandomInterval(0, 29)];
		return intRandomInterval(temp - 9, temp);
	}

	public void run() {
		ShopperSim.agenda.add(new ShopperMaker(interval, itemDist),intRandomInterval(0, 2 * interval));
		Shopper newShopper = new Shopper(ShopperSim.agenda.getCurrentTime(), selectItemCount());// shopper adds itself to the checker queue when initiated
	}

	private double interval;
	private int[] itemDist;

} // ShopperMaker class