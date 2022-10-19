public class Trading {

	private Product product;

	private OfferingList offeringList;

	public Trading(Product product, OfferingList offeringList) {
		this.product = product;
		this.offeringList = offeringList;
	}

	public void accept(NodeVisitor visitor) {

	}

}
