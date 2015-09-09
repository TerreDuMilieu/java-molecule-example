package primeFactor;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static int[] primesOf(int num) {
		
		List<Integer> listReturn = new ArrayList<Integer>();
		int [] primesArray = new int[] {2, 3, 5, 7, 11, 13, 17, 19};
		for (int prime : primesArray) {
			while (num%prime == 0) {
				num = num/prime;
				listReturn.add(prime);
			}
		}
		int[] tabReturn = new int[listReturn.size()];
		for (int j = 0; j < tabReturn.length; j++) {
			tabReturn[j] = listReturn.get(j);
		}
		
		return tabReturn;
	}
		


}
