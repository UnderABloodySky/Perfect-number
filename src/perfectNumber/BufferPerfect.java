package perfectNumber;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BufferPerfect {
	List<BigInteger> listPerfect = new ArrayList<>();
	
	public synchronized void addPerfect(BigInteger perf) {
		listPerfect.add(perf);
		
	}
	
	
	public List<BigInteger> listPerfect(){
		return listPerfect;
		
	}
}
