// package car_repair;
import java.util.*;

public class Car {
	public int repairHours;
	public int repairPrice;
	private String ID;
	public String getRegistrationNumber(){
		return ID;
	}
	public Car(String line){
		// "ABC-123 3 100"
		String[] tokens = line.split(" ");
		ID = tokens[0];
		repairHours = Integer.parseInt(tokens[1]);
		repairPrice = Integer.parseInt(tokens[2]);
	}
	public String toString(){
		return String.format("%s %dh %d€", ID, repairHours, repairPrice);
	}
}