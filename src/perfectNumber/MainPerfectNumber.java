package perfectNumber;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainPerfectNumber {
	private static long tInicio;
	private static long tFin;
	private static long tiempo;
	
	

	public static SearcherPerfectNumber searcher;
	public static List<BigInteger> listToSearch;
	
	public static void main(String[] args) {
		tInicio=System.currentTimeMillis();
		listToSearch = generatePossiblePerfects(); 
		System.out.print(listToSearch.toString());
		
		searcher = new SearcherPerfectNumber(10,10);
		List<BigInteger> perfectList = searcher.search(listToSearch);
		System.out.println("numeros perfectos");
		System.out.println(perfectList.toString());
		tFin=System.currentTimeMillis();
	    tiempo=tFin-tInicio;
	    System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);

	}

	private static List<BigInteger> generatePossiblePerfects() {
		BigInteger firstPerfect = new BigInteger("6");
		BigInteger secondPerfect = new BigInteger("28");
		BigInteger thirdPerfect = new BigInteger("496");
		BigInteger fourthPerfect = new BigInteger("8128");
		BigInteger fifthPerfect = new BigInteger("33550336");
		BigInteger sixthPerfect = new BigInteger("8589869056");
		BigInteger seventhPerfect = new BigInteger("137438691328"); 
		Random ran = new Random();
		List<BigInteger> result = new ArrayList<>();
		int cant ;
		Set<BigInteger> aux = new HashSet<BigInteger>();
		for(cant=0;cant<193;cant++) {
			aux.add(new BigInteger(20,ran));
		}
		aux.add(firstPerfect);
		aux.add(secondPerfect);
		aux.add(thirdPerfect);
		aux.add(fourthPerfect);
		aux.add(fifthPerfect);
		aux.add(sixthPerfect);
		aux.add(seventhPerfect);
		result.addAll(aux);
		return result;
	}

}
