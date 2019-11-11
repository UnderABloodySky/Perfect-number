package perfectNumber;

import java.math.BigInteger;
import java.util.List;

public class PerfectNumberTaskFactory {
	private SearcherPerfectNumber mySearcherPerfectNumber;
	
	public PerfectNumberTaskFactory(SearcherPerfectNumber _searcherPerfectNumber) {
		mySearcherPerfectNumber = _searcherPerfectNumber;
		
	}
	
	public void createPerfectNumberTask(List<BigInteger> result, BigInteger numberToPerfect) {
		PerfectNumberTask task = new PerfectNumberTask(result, numberToPerfect);
		mySearcherPerfectNumber.launchPerfectNumberTask(task);
		
	}
}
