import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KeyPad {

	/**
	 * I am using 2 dimensional 3X3 array concept for this problem. Below is the i &
	 * j position of 3X3 2 dimensional array.
	 * 
	 * 00 01 02 
	 * 10 11 12 
	 * 20 21 22
	 * 
	 * First converts the given input keypad string into 2 dimensional array and
	 * stored into hashmap of key as number and i&j positions as value. For example
	 * lets say keypad string is 261793584, the hashmap would be {2=[0, 0], 6=[0,
	 * 1], 1=[0, 2], 7=[1, 0], 9=[1, 1], 3=[1, 2], 5=[2, 0], 8=[2, 1], 4=[2, 2]}
	 * 
	 * Now iterate the given input string by character and apply the below logic.
	 * 
	 * Check if the prevX == currX && prevY == currY then timeTaken = timeTaken + 0
	 * Otherwise check if difference between (PrevX and CurrX) and (PrevY and CurrY)
	 * is less than or equal to 1 then timeTaken = timeTaken + 1 Otherwise timeTaken
	 * = timeTaken + 2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "96985729134";
		String keypad = "261793584";
		System.out.println("Total Time taken = " + timeTaken(input, keypad));
	}

	private static int timeTaken(String input, String keypad) {
		Map<Integer, List<Integer>> mapNumberAndArrayIndex = new LinkedHashMap<>();

		int i = 0;
		int j = 0;
		for (int l = 0; l < keypad.length(); l++) {
			List<Integer> pos = new ArrayList<>();
			pos.add(i);
			pos.add(j);
			mapNumberAndArrayIndex.put(Character.getNumericValue(keypad.charAt(l)), pos);
			j++;
			if (j == 3) {
				j = 0;
				i++;
			}
		}
		System.out.println("mapNumberAndArrayIndex --> " + mapNumberAndArrayIndex);
		int timeTaken = 0;
		int prevX = -1;
		int prevY = -1;
		int currX;
		int currY;
		for (int l = 0; l < input.length(); l++) {
			int num = Character.getNumericValue(input.charAt(l));
			currX = mapNumberAndArrayIndex.get(num).get(0);
			currY = mapNumberAndArrayIndex.get(num).get(1);
			if (l > 0) {
				if (prevX == currX && prevY == currY) {
					timeTaken += 0;
				} else if (Math.abs(prevX - currX) <= 1 && Math.abs(prevY - currY) <= 1) {
					timeTaken += 1;
				} else {
					timeTaken += 2;
				}
			}
			prevX = currX;
			prevY = currY;
		}
		return timeTaken;
	}

}
