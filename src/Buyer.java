import java.util.List;
import java.util.Scanner;

public class Buyer extends Person {

	public Buyer(int type, String name) {
		this.name = name;
		this.personType = type;
	}

	public String getName() {
		return name;
	}

	public String showMenu(ClassProductList productList) {
		MenuGUIBuyer mg = new MenuGUIBuyer();
		mg.MenuGUIForProductTypes();
		mg.waitTime();
		//System.out.println("Enter you choice of menu\n1. Meat\n2.Produce\n");
		//Scanner sc = new Scanner(System.in);
		//int c = sc.nextInt();
		if(mg.productType==0) {
			MeatProductMenu m = new MeatProductMenu();
			List<String> k = m.showMenu(productList);
			MenuGUIBuyer mk = new MenuGUIBuyer();
			mk.MenuGUIforProducts(k);
			mk.waitTime();
		}
		else if(mg.productType==1) {
			ProduceProductMenu p = new ProduceProductMenu();
			List<String> k = p.showMenu(productList);
			MenuGUIBuyer mk = new MenuGUIBuyer();
			mk.MenuGUIforProducts(k);
			mk.waitTime();
		}
		return mg.product;
	}

	public ProductMenu createProductMenu() {
		return null;
	}

}
