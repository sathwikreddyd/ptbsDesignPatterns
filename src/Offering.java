import java.nio.channels.SelectableChannel;

public class Offering {

	private Buyer buyer;

	private Seller seller;

	private int price;

	public Offering(Buyer buyer, Seller seller, int price) {
		this.buyer = buyer;
		this.seller = seller;
		this.price = price;
	}

}
