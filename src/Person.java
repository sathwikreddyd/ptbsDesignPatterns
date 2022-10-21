public abstract class Person {

	private ProductMenu theProductMenu;

	private ProductMenu productMenu;

	public int personType;

	protected String name;

	/*public Person(int type) {
		this.personType = type;
	}*/

	public abstract String showMenu(ClassProductList productList);

	public abstract String getName();


	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public abstract ProductMenu createProductMenu();


}
