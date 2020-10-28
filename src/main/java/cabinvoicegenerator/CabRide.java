package cabinvoicegenerator;

public enum CabRide {
	NORMAL(10, 1, 5), PREMIUM(15, 2, 20);

	private final double costPerKm;
	private final double costPerMin;
	private final double minFarePerRide;

	CabRide(double costPerKm, double costPerMin, double minFarePerRide) {
		this.costPerKm = costPerKm;
		this.costPerMin = costPerMin;
		this.minFarePerRide = minFarePerRide;
	}

	public double calCostOfCabRide(Ride ride) {
		return 0;
	}
}