public class Facade {

	private int userType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public boolean login() {
		return false;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

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

}
