import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;

import static javafx.application.Platform.exit;


public class Facade {

	private int userType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public Facade() {
		boolean flag = true;
		while(flag) {
			flag = login();
		}
	}

	public boolean login() {
		Login l = new Login();
		l.LoginWindow();
		l.waitTime();
		if(l.flag==0) return true;
		if(l.getUserType() == 0) {
			this.thePerson = new Buyer(l.getUserType(),l.getName());
		} else if (l.getUserType() == 1) {
			this.thePerson = new Seller(l.getUserType(),l.getName());
		}
		return false;
	}

	public void addTrading() {
		System.out.println("Select Product");
		this.createProductList();
		ProductIterator iter = new ProductIterator(theProductList);
		int c = 0;
		List<Product> items = new ArrayList<Product>();
		while(iter.hasNext()) {
			items.add(iter.next());
			System.out.println((c+1) + "." + items.get(c).getName());
			c+=1;
		}
		System.out.println("Enter number");
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		if(s>0 && s<c+1) {
			Trading trading = new Trading(thePerson,items.get(s-1));
		}
		else {
			System.out.println("no selected product");
		}

	}

	public void viewTrading() {
		try {
			List<String> l = Files.readAllLines(Paths.get("input/Trading.txt"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public void decideBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}


	public void createProductList() {
		try {
			List<String> strings = Files.readAllLines(Paths.get("input/ProductInfo.txt"));
			System.out.println(strings.toString());
			System.out.println("Done");
			this.theProductList = new ClassProductList(strings);
			System.out.println(theProductList.toString());
			System.out.println("DOne2");
		}
		catch(java.io.IOException e){
			System.out.println("File read failed");
			exit();
		}
	}

	public void attachProductToUser() {

	}

	public void selectProduct() {

	}

	public void productOperation() {

	}

	public void showMenu() {
		this.createProductList();
		this.thePerson.showMenu(this.theProductList);
	}

	public static void main(String[] args) {
		Facade facade = new Facade();
		//facade.addTrading();
		facade.showMenu();
	}

}
