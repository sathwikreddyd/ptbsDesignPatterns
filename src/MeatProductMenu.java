import java.util.*;

public class MeatProductMenu implements ProductMenu {
	//FACTORY METHOD

	public List<String> showMenu(ClassProductList productList) {
		List<String> items = new ArrayList<>();
		ProductIterator iter = new ProductIterator(productList);
		while(iter.hasNext()) {
			Product p = iter.next();
			if(p.getType() == 0) {
				//System.out.println(p.getName());
				items.add(p.getName());
			}
		}
		return items;
	}


	public void showAddButton() {

	}

	public void showViewButton() {

	}

}
