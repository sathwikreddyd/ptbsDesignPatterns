import java.util.List;

public interface ProductMenu {
	//FACTORY METHOD

	public final Person person = null;

	public abstract List<String> showMenu(ClassProductList productList);

	public abstract void showAddButton();

	public abstract void showViewButton();

}
