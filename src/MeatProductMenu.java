public class MeatProductMenu implements ProductMenu {

	public void showMenu(ClassProductList productList) {
		ProductIterator iter = new ProductIterator(productList);
		while(iter.hasNext()) {
			Product p = iter.next();
			if(p.getType() == 0) {
				System.out.println(p.getName());
			}
		}
	}


	public void showAddButton() {

	}

	public void showViewButton() {

	}

}
