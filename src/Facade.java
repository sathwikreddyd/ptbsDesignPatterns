import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;

import static javafx.application.Platform.exit;


public class Facade {

	//FACADE PATTERN

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


	public void addTrading(String p) {
		Trading trading = new Trading(thePerson,p);
		System.out.println(thePerson.getName()+":"+p+" is added to trading menu");
	}

	public void viewTrading(String p) {
		try {
			List<String> trades = Files.readAllLines(Paths.get("input/UserProduct.txt"));
			List<String> buyers = Files.readAllLines(Paths.get("input/BuyerInfo.txt"));
			List<String> sellers = Files.readAllLines(Paths.get("input/SellerInfo.txt"));

			//String selected = this.selectProduct();
			String selected = p;

			List<String> usersWithTrade = new ArrayList<String>();

			List<String> finalUsers = new ArrayList<String>();


			if(this.thePerson.personType == 0) {
				for (String k : trades) {
					if(k.length() != 0 && k.split(":")[1].equals(selected)) {
						usersWithTrade.add(k.split(":")[0]);
					}
				}

				for (String h : usersWithTrade) {
					for (String j : sellers) {
						if (j.length() != 0 && h.equals(j.split(":")[0])) {
							finalUsers.add(h);
						}
					}
				}
			}

			if(this.thePerson.personType == 1) {
				for (String k : trades) {
					if(k.split(":")[1].equals(selected)) {
						usersWithTrade.add(k.split(":")[0]);
					}
				}

				for (String h : usersWithTrade) {
					for (String j : buyers) {
						if (h.equals(j.split(":")[0])) {
							finalUsers.add(h);
						}
					}
				}
			}
			if(finalUsers.size() == 0) {
				System.out.println("No users to trade");
			}
			for (String g : finalUsers) {
				System.out.println(g);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}


	public void createProductList() {
		try {
			List<String> strings = Files.readAllLines(Paths.get("input/ProductInfo.txt"));
			//System.out.println(strings.toString());
			this.theProductList = new ClassProductList(strings);
			//System.out.println(theProductList.toString());
		}
		catch(java.io.IOException e){
			System.out.println("File read failed");
			exit();
		}
	}


	public String selectProduct() {
		/*System.out.println("Select Product");
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
		if(s>0 && s<c+1)
			return items.get(s-1);
		System.out.println("Wrong choice");
		return null;*/
		return this.showMenu();
	}


	public String showMenu() {
		this.createProductList();
		return this.thePerson.showMenu(this.theProductList);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visitFacade(this);
	}

	public static void main(String[] args) {
		Facade facade = new Facade();
		String pro = facade.selectProduct();
		String opt;
		if(facade.thePerson.personType == 0) {
			MenuGUIBuyer b = new MenuGUIBuyer();
			b.MenuGUIForTradingOptions();
			b.waitTime();
			opt = b.option;
		}
		else{
			MenuGUI b = new MenuGUI();
			b.MenuGUIForTradingOptions();
			b.waitTime();
			opt = b.option;
		}
		if(opt.equals("add")) {
			facade.addTrading(pro);
		}
		else if(opt.equals("list")) {
			facade.viewTrading(pro);
		}
		exit();
	}

}
