package strings;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

	static Set<String> uniqueCombinations = new HashSet<String>();

	/**
	 * Move the first character to last in the string to form a new string and then check if the new string is not in the set.
	 * If it is not in the Set then add it to the Set.
	 * Repeat the process for newly formed string until newly formed string is not exists in the Set.
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		String input = "Test";
		permutation(input);
		System.out.println(uniqueCombinations);
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println("Difference in seconds " + Duration.between(startTime, endTime).getSeconds());
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
