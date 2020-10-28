package cabinvoicegenerator;

public class Ride {
	public double distance;
	public final int time;
	public final CabRide ride;

	public Ride(CabRide ride, double distance, int time) {
		this.ride = ride;
		this.distance = distance;
		this.time = time;
	}
}