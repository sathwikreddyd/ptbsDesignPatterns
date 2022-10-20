public class Facade {

	private int userType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public Facade() {
		String login = this.login();
	}

	public String login() {
		return false;
	}

	public void addTrading() {
		if(theSelectedProduct) {
			Trading trading = new Trading(thePerson,theSelectedProduct);
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
		List<String> strings = Files.readAllLines(Paths.get("inputs/ProductInfo.txt"));
		this.theProductList = new ClassProductList(stings);
	}

	public void attachProductToUser() {

	}

	public void selectProduct() {

	}

	public void productOperation() {

	}

	public static void main(String[] args) {
		Facade facade = new Facade();
	}

}
