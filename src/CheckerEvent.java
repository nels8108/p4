// adapted from class code Washer

public class CheckerEvent implements Event {
	
	public Checker c;
	public double servTime;

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
			//System.out.println(c.busy + " Busy");
			Stat.updateServiceTimeStats(servTime);
			Stat.updateBusyTimeStats(ShopperSim.agenda.getCurrentTime());
		} else
			// this instance invoked because a new Shopper arrived at idle wash
			Stat.updateIdleTimeStats(ShopperSim.agenda.getCurrentTime());

		if (c.waitline.length() == 0) {
			//System.out.println("Length is 0");
			c.busy = false; // do nothing until notified of a new Shopper arrival
		} 
		else 
		{
			c.busy = true; // start on next Shopper in queue
			Shopper =  (Shopper) c.waitline.remove();
			Stat.updateQueueStats(ShopperSim.agenda.getCurrentTime(), c.waitline.length());
			Stat.updateWaitTimeStats(ShopperSim.agenda.getCurrentTime(), Shopper.getArrivalTime());
//			System.out.println(ShopperSim.agenda.getCurrentTime() + " - " + Shopper.getArrivalTime());
			servTime = Shopper.getItemCount()*ShopperSim.getBaggingTime();
			ShopperSim.agenda.add(new CheckerEvent(c, servTime), servTime);
		}

	} // run method

} // CheckerEvent class
