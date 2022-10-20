public class Product {

	private Trading trading;

	private int type;

	private String item;

	//private ClassProductList classProductList;

	public Product(String type, String name) {
		if(type.equals("Meat")) {
			this.type = 0;
		}
		else {
			this.type = 1;
		}
		this.item = name;
		System.out.println("product init");
	}

	public String getName() {
		return this.item;
	}

	public int getType() {
		return this.type;
	}

}
