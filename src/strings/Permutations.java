package strings;

import java.util.HashSet;
import java.util.Set;

public class Permutations {

	static Set<String> uniqueCombinations = new HashSet<String>();

	public static void main(String[] args) {
		String input = "Bala";
		permutation(input);
		System.out.println(uniqueCombinations);
	}

	private static void permutation(String input) {
		if (!uniqueCombinations.contains(input)) {
			uniqueCombinations.add(input);
			for (int i = 0; i < input.length(); i++) {
				String alteredString = moveCharacterAtGivenPosToLast(input, i);
				permutation(alteredString);
			}
		}
	}

	private static String moveCharacterAtGivenPosToLast(String value, int i) {
		return value.substring(0, i) + value.substring(i + 1) + value.charAt(i);
	}
}
