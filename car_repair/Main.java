import java.util.*;
/*
ABC-123 3h 100€
DEF-456 5h 120€
GHI-789 4h 80€
ZZZ-999 1h 50€
*/
public class Main {
	public static void main(String[] args) {
		String raw = "ABC-123 3 100\nDEF-456 5 120\nGHI-789 4 80\nZZZ-999 1 50";
		MyGarage garage = new MyGarage(raw, 8);
		garage.repair();
	}
}