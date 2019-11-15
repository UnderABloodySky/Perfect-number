package perfectNumber;

import java.math.BigInteger;
import java.util.List;

import threadPool.Task;

public class PerfectNumberTask extends Task implements Runnable {
	private BufferPerfect result;
	private BigInteger numberPerf;
	
	public PerfectNumberTask(BufferPerfect _result, BigInteger numberToPerfect) {
		result = _result;
		numberPerf = numberToPerfect;
	}

	
	@Override
	public void run() {
		this.perfectNumber(result, numberPerf);
		
	}
	
	private void perfectNumber(BufferPerfect result, BigInteger numberToPerfect) {
		BigInteger cero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger divs = new BigInteger("0");
		
		for (BigInteger div= one; div.compareTo(numberToPerfect)<0; div=div.add(one)) {
			
			if((numberToPerfect.mod(div)).equals(cero)) {
				divs=divs.add(div);
				
			}
			
		}
			
			if(divs.equals(numberToPerfect)) {
			result.addPerfect(numberToPerfect);
			
		}
				
	}
	
	public boolean isNegative() {
		BigInteger oneNeg = new BigInteger("-1");
		boolean result= numberPerf.equals(oneNeg);
		return result;
	}
	
}


