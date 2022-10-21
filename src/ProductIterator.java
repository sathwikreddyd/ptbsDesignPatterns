public class ProductIterator {

	//ITERATOR PATTERN

	private ClassProductList productList;

	private int presentIterator;

	public ProductIterator(ClassProductList productList) {
		this.productList = productList;
		this.presentIterator = 0;
	}

	public boolean hasNext() {
		if(presentIterator < productList.product.size()){
			return true;
		}
		return false;
	}

	public Product next() {
		return productList.product.get(this.presentIterator++);
	}

	public void moveToHead() {
		this.presentIterator = 0;
	}

	public void remove() {
		productList.product.remove(this.presentIterator);
	}

}
