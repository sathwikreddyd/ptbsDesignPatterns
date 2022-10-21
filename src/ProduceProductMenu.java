import java.util.ArrayList;
import java.util.List;

public class ProduceProductMenu implements ProductMenu {

	public List<String> showMenu(ClassProductList productList) {
		List<String> items = new ArrayList<>();
		ProductIterator iter = new ProductIterator(productList);
		while(iter.hasNext()) {
			Product p = iter.next();
			if(p.getType() == 1) {
				System.out.println(p.getName());
				items.add(p.getName());
			}
		}
		return items;
	}

	public void showViewButton() {

	}

	public void showAddButton() {

	}

}
