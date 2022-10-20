public class OfferingInterator {

	private OfferingList offeringList;

	private int presentIterator;

	public OfferingInterator(OfferingList offeringList) {
		this.offeringList = offeringList;
		presentIterator = 0;
	}

	public boolean hasNext() {
		return this.presentIterator < this.offeringList.offering.size();
	}

	public Offering next() {

		return this.offeringList.offering.get(this.presentIterator++);
	}

	public void moveToHead() {
		this.presentIterator = 0;
	}

	public void remove() {
		this.offeringList.offering.remove(this.presentIterator);
	}

}
