import java.util.*;

public class Seller extends Person {

	public Seller(int type, String name) {
		this.name = name;
		this.personType = type;
	}

	public String getName() {
		return name;
	}

	public void showMenu(ClassProductList productList) {
		System.out.println("Enter you choice of menu\n1. Meat\n2.Produce\n");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		ProductIterator iter = new ProductIterator(productList);
		if(c==1) {
			MeatProductMenu m = new MeatProductMenu();
			m.showMenu(productList);
		}
		else if(c==2) {
			ProduceProductMenu p = new ProduceProductMenu();
			p.showMenu(productList);
		}
	}

	public ProductMenu createProductMenu() {
		return null;
	}

}
