package perfectNumber;

import java.math.BigInteger;
import java.util.List;

public class MainPerfectNumber {

	public static SearcherPerfectNumber searcher;
	public static List<BigInteger> listToSearch;
	
	public static void main(String[] args) {
		searcher = new SearcherPerfectNumber(10,1);
		List<BigInteger> perfectList = searcher.search(listToSearch);

	}

}
