package perfectNumber;

import java.math.BigInteger;
import java.util.List;

import threadPool.Task;

public class PerfectNumberTask extends Task implements Runnable {
	private List<BigInteger> result;
	private BigInteger numberPerf;
	
	public PerfectNumberTask(List<BigInteger> _result, BigInteger numberToPerfect) {
		result = _result;
		numberPerf = numberToPerfect;
	}

	//implementar aca lo de la operacion de ver si es perfect
	@Override
	public void run() {
		this.perfectNumber(result, numberPerf);
		
	}
	
	private void perfectNumber(List<BigInteger> result, BigInteger numberToPerfect) {
		BigInteger cero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger divs = new BigInteger("0");
		
		for (BigInteger div= one; div.compareTo(numberToPerfect)<0; div=div.add(one)) {
			if(numberToPerfect.mod(div) == cero) {
				divs=divs.add(div);
			}
		}
		if(divs == numberToPerfect) {
			result.add(numberToPerfect);//ver si esta bien esto,si podria darse un error en la lista
		}
	}
	
}
