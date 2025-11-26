import java.io.Serializable;
//import java.util.x

public class Rental implements Serializable {
	private static int nextContractNumber = 1;

	private long contract;
	private int time;
	private double price;
	private Equipment equipment;

	public Rental(int time, Equipment equipment) {
		this.contract = nextContractNumber++;
		this.time = time;
		this.equipment = equipment;
		calculatePrice();
	}


	private void calculatePrice() {
		double basicRate = equipment.getEquipmentAndValues().getBasicTax();
		double hourlyRate = equipment.getEquipmentAndValues().getTaxPerHour();
		double lessonCost = equipment.getEquipmentAndValues().canHaveLesson() ? 20.0 : 0.0;
		//double lessonCost = equipment.getEquipmentAndValues().canHaveLesson();

		this.price = basicRate + (hourlyRate * time) + lessonCost;
	}

	public double totalPrice() {
		return price;
	}




	public String toString() {
		return "Contrato = " + contract + "\nTempo = " + time + "\nPreço = " + price + "\nEquipamento = "
				+ equipment.getType() + " - " + equipment.getDescription() + "\n";
	}
}
