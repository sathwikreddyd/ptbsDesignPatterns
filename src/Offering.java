import java.nio.channels.SelectableChannel;

public class Offering {

	private OfferingList offeringList;

	private Person person;

	private int price;

	public Offering(OfferingList offeringList, Person person, int price) {
		this.offeringList = offeringList;
		this.person = person;
		this.price = price;
		
	}

	public void getBestOffering() {
		
	}

}
