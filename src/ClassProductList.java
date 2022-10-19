public class ClassProductList {

	private List<Product> product;

	private ReminderVisitor reminderVisitor;

	public ClassProductList(List<String> products) {
		for(int i=0; i<products.size();i++) {
			product.add(Product(products.get(i).split(':')[0],prodcuts.get(i).split(':')[1]));
		}
	}

	public void accept(NodeVisitor visitor) {

	}

}
