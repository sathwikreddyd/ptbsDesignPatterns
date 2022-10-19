public class ProductIterator {

	private ClassProductList productList;

	private int presentIterator;

	public ProductIterator(ClassProductList productList) {
		this.productList = productList;
		this.presentIterator = 0;
	}

	public boolean hasNext() {
		if(presentIterator<productList.size()){
			return true;
		}
		return false;
	}

	public Product next() {
		return ProductList.get(this.presentIterator);
	}

	public void moveToHead() {
		this.presentIterator = 0;
	}

	public void remove() {
		productList.remove(this.presentIterator);
	}

}
