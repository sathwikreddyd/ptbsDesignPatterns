public class Trading {

	private Person person;

	private Product product;

	private OfferingList offeringList;

	public Trading(Person person, Product product) {
		this.person = person;
		
		this.product = product;
	}

	public void accept(NodeVisitor visitor) {

	}

}
