// package car_repair;
import java.util.*;
/*
ABC-123 3h 100€
DEF-456 5h 120€
GHI-789 4h 80€
ZZZ-999 1h 50€
*/
public class Garage{	
	private Car[] cars;
	private int[][] profit;       // profit[i][j]    the maxium profit for first i items with a j capacity package.
	private int item_num;
	private int capacity;
	public Garage(String data, int availableHours){
		String[] lines = data.split("\n");
		item_num = lines.length;
		capacity = availableHours;
		cars = new Car[item_num];
		profit = new int[item_num+1][capacity+1];
		for (int i = 0; i < item_num; i++) {
			Car car = new Car(lines[i]);
			cars[i] = car;
		}
	}
	public  void print_talbe(int[][] table){
		for (int[] row : table) {
			for (int num : row) {
				System.out.print(num + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public String repair(){
		for (int i = 1; i <= item_num; i++) {
			for (int j = 1; j <= capacity ; j++) {
				if (j < cars[i-1].repairHours) {  // j hours not enough for this car
					profit[i][j] = profit[i-1][j];  // thus with this i cars and j hours max profit would be the same with i-1 cars and j hours
				}else {   // do not put ith car in, put it in choose the bigger profit
					profit[i][j] = Math.max(profit[i-1][j], profit[i-1][j-cars[i-1].repairHours] + cars[i-1].repairPrice);
				}
			}
			print_talbe(profit);
		}
		int j = capacity;
		// List<Car> result = new LinkedList<Car>();
		String result = "Cars chosen to repair:\n";
		for (int i = item_num; i != 0; i--) {
			if (profit[i][j] > profit[i-1][j]) {
				j -= cars[i-1].repairHours;
				result += cars[i-1].toString();
				result += "\n";
			}
		}
		result += "Total revenue:\n" + profit[item_num][capacity];
		System.out.println(result);
		return result;
	}
}