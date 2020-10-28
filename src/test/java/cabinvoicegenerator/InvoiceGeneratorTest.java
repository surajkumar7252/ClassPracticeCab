package cabinvoicegenerator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class InvoiceGeneratorTest {
	InvoiceService invoiceService = null;
	private RideRepository rideRepository = null;
	Ride[] rides = null;
	InvoiceSummary expectedInvoiceSummary = null;

	@Before
	public void setUp() throws Exception {
		invoiceService = new InvoiceService();
		rideRepository = new RideRepository();
		invoiceService.setRideRepository(rideRepository);
		Ride[] rides = new Ride[] { new Ride(CabRide.NORMAL, 2.0, 5), new Ride(CabRide.PREMIUM, 0.1, 1) };
		expectedInvoiceSummary = new InvoiceSummary(2, 45);
	}

	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		Assert.assertEquals(expectedInvoiceSummary, summary);

	}

	@Test
	public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
		String userId = "a@b.com";
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);

	}

}
