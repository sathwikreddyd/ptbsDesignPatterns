public abstract class Person {

	private ProductMenu theProductMenu;

	private ProductMenu productMenu;

	protected int personType;

	protected String name;

	/*public Person(int type) {
		this.personType = type;
	}*/

	public abstract void showMenu();

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public abstract ProductMenu createProductMenu();

}
