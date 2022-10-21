public class ReminderVisitor implements NodeVisitor {

	private ClassProductList classProductList;

	public void visitProduct(Product product) {
		System.out.println(product.getName());
	}

	public void visitTrading(Trading trading) {
		System.out.println(trading.toString());
	}

	public void visitFacade(Facade facade) {
		System.out.println(facade.toString());
	}

}
