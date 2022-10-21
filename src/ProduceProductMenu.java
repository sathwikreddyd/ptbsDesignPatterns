public class ProduceProductMenu implements ProductMenu {

	public void showMenu(ClassProductList productList) {
		ProductIterator iter = new ProductIterator(productList);
		while(iter.hasNext()) {
			Product p = iter.next();
			if(p.getType() == 1) {
				System.out.println(p.getName());
			}
		}
	}

	public void showViewButton() {

	}

	public void showAddButton() {

	}

}
