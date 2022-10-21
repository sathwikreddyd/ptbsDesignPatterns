import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;

public class Trading {

	private Person person;

	private Product product;

	private OfferingList offeringList;

	public Trading(Person person, Product product) {
		this.person = person;
		this.product = product;
		this.offeringList = new OfferingList();
		this.storeTradingInfo();
	}

	public void storeTradingInfo() {
		try {
			FileWriter fw = new FileWriter("input/Trading.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(person.getName() + ":" + product.getName()+"\n");
			bw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void accept(NodeVisitor visitor) {

	}

}
