import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Voting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] votes = new String[] { "Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary",
				"Mary" };
		electionWinner(votes);
	}

	static String electionWinner(String[] votes) {
		int maxNumberOfVotes = 0;
		Map<Integer, String> result = new HashMap<Integer, String>();
		List<String> votesList = Arrays.asList(votes);
		Set<String> uniqueVoters = new HashSet<>(votesList);
		for (String voter : uniqueVoters) {
			int numberOfVotes = Collections.frequency(votesList, voter);
			if (numberOfVotes > maxNumberOfVotes) {
				maxNumberOfVotes = numberOfVotes;
			}
			if (result.containsKey(numberOfVotes)) {
				result.put(numberOfVotes,
						new StringBuilder().append(result.get(numberOfVotes)).append(",").append(voter).toString());
			} else {
				result.put(numberOfVotes, new StringBuilder().append(voter).toString());
			}
		}
		System.out.println(result);
		System.out.println(maxNumberOfVotes);
		List<String> winnerList = Arrays.asList(result.get(maxNumberOfVotes).split(","));
		System.out.println(winnerList);
		Collections.sort(winnerList);
		Collections.reverse(winnerList);
		System.out.println(winnerList.get(0));
		return null;
	}

}
