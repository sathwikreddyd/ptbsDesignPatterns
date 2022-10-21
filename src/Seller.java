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
			while(iter.hasNext()) {
				Product p = iter.next();
				if(p.getType() == 0) {
					System.out.println(p.getName());
				}
			}
		}
		else if(c==2) {
			while(iter.hasNext()) {
				Product p = iter.next();
				if(p.getType() == 1) {
					System.out.println(p.getName());
				}
			}
		}
	}

	public ProductMenu createProductMenu() {
		return null;
	}

}
