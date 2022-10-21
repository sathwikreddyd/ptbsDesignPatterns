import java.awt.*;
import java.util.*;
import java.util.List;

public class Seller extends Person {

	public Seller(int type, String name) {
		this.name = name;
		this.personType = type;
	}

	public String getName() {
		return name;
	}

	public String showMenu(ClassProductList productList) {
		MenuGUI mg = new MenuGUI();
		mg.MenuGUIForProductTypes();
		mg.waitTime();
		//System.out.println("Enter you choice of menu\n1. Meat\n2.Produce\n");
		//Scanner sc = new Scanner(System.in);
		//int c = sc.nextInt();
		if(mg.productType==0) {
			MeatProductMenu m = new MeatProductMenu();
			List<String> k = m.showMenu(productList);
			MenuGUI mk = new MenuGUI();
			mk.MenuGUIforProducts(k);
			mk.waitTime();
			return mk.product;
		}
		else if(mg.productType==1) {
			ProduceProductMenu p = new ProduceProductMenu();
			List<String> k = p.showMenu(productList);
			MenuGUI mk = new MenuGUI();
			mk.MenuGUIforProducts(k);
			mk.waitTime();
			return mk.product;
		}
		return "";
	}

	public ProductMenu createProductMenu() {
		return null;
	}

}
