package cabinvoicegenerator;

public class InvoiceService {
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final double MINIMUM_FARE = 5;
    private RideRepository rideRepository=null;
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}
	public InvoiceService() {
		this.rideRepository=new RideRepository();
	}
	public double calculateFare1(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return totalFare;

	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length,totalFare);

	}

	public void addRides(String userId, Ride[] rides) {
	     rideRepository.addRides(userId,rides);	
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		// TODO Auto-generated method stub
		return this.calculateFare(rideRepository.getRides(userId));
	}
	
}
