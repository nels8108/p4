// code adapted from the class code Washer

public class Checker {

	public boolean busy;

	public Q1 waitline = new Q1();

	public void enter(Shopper s) {
		waitline.add(s);
		Stat.updateQueueStats(ShopperSim.agenda.getCurrentTime(),waitline.length());
	}

	public boolean isBusy() {
		return busy;
	}
//	public Object checkout(){
//		
//		Object temp  = waitline.remove();
//		return temp;
//	}
	
}