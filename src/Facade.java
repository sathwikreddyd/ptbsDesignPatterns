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
		this.login();
	}

	public void login() {
		Login l = new Login();
		l.LoginWindow();
		l.waitTime();
		if(l.getUserType() == 0) {
			this.thePerson = new Buyer(l.getUserType(),l.getName());
		} else if (l.getUserType() == 1) {
			this.thePerson = new Seller(l.getUserType(),l.getName());
		}
	}

	public void addTrading() {
		System.out.println("Select Product");
		this.createProductList();
		ProductIterator iter = new ProductIterator(theProductList);
		int c = 0;
		List<Product> items = new ArrayList<Product>();
		while(iter.hasNext()) {
			items.add(iter.next());
			System.out.println(new Integer(c+1).toString() + "." + items.get(c).getName());
			c+=1;
		}
		System.out.println("Enter number");
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		if(s>0 && s<c) {
			Trading trading = new Trading(thePerson,items.get(s-1));
		}
		else {
			System.out.println("no selected product");
		}

	}

	public void viewTrading() {

	}
	public void decideBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userInfoItem) {

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

	public static void main(String[] args) {
		Facade facade = new Facade();
		//facade.login();
		//facade.createProductList();
		facade.addTrading();
	}

}
