// adapted from class code Washer

public class CheckerEvent implements Event {
	
	public Checker c;
	public double servTime;

	// constructors
	
	public CheckerEvent() {
		servTime = 0;
	}
	
	public CheckerEvent(Checker c, double st) {
		this.c = c;
		servTime = st;
	}

	public void run() {

		Shopper Shopper;
		
		if (c.busy) { 
			// keep busy stats when checker remains busy
			Stat.updateServiceTimeStats(servTime);
			Stat.updateBusyTimeStats(ShopperSim.agenda.getCurrentTime());
		} else
			// this instance invoked because a new Shopper arrived at idle wash
			Stat.updateIdleTimeStats(ShopperSim.agenda.getCurrentTime());

		if (c.waitline.length() == 0) {
			c.busy = false; // do nothing until notified of a new Shopper arrival
		} else {
			c.busy = true; // start on next Shopper in queue
			Shopper =  (Shopper) c.waitline.remove(); // remove a shopper from queue and update stats
			Stat.updateQueueStats(ShopperSim.agenda.getCurrentTime(), c.waitline.length());
			Stat.updateWaitTimeStats(ShopperSim.agenda.getCurrentTime(), Shopper.getArrivalTime());
			servTime = Shopper.getItemCount()*ShopperSim.getBaggingTime(); // get service time by number of items * bagging time
			ShopperSim.agenda.add(new CheckerEvent(c, servTime), servTime);
		}

	} // run method

} // CheckerEvent class
