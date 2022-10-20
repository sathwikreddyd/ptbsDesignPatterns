import java.util.ArrayList;
import java.util.List;

public class ClassProductList {

	public List<Product> product;

	private ReminderVisitor reminderVisitor;

	public ClassProductList(List<String> products) {
		product = new ArrayList<Product>();
		for(int i=0; i<products.size();i++) {
			Product p = new Product(products.get(i).split(":")[0],products.get(i).split(":")[1]);
			System.out.println("calling done");
			System.out.println(p.getName());
			this.product.add(p);
			System.out.println(i);
		}
		System.out.println(this.product.toString());
	}

	public void accept(NodeVisitor visitor) {

	}

}
