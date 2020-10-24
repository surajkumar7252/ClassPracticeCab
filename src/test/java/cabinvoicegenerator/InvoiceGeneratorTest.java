package cabinvoicegenerator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class InvoiceGeneratorTest {
	InvoiceGenerator invoiceGenerator = null;

	@Before
	public void setUp() throws Exception {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);

		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceOrTime_ShouldReturnTotalMiNFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary(int NumOfRides, double totalFare) {

		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);

	}

}
