package perfectNumber;

import java.math.BigInteger;
import java.util.List;

import threadPool.ThreadPool;

public class SearcherPerfectNumber {
	private ThreadPool myThreadPool;
    private int quantityThreads;
    
    public SearcherPerfectNumber (int bufferSize, int _quantityThreads) {
    	myThreadPool = new ThreadPool(bufferSize, _quantityThreads);
        quantityThreads = _quantityThreads;    	
    }
    
    public List<BigInteger> search (List<BigInteger> listToSearch) {
    	int numbers = listToSearch.size();
    	BufferPerfect result= new BufferPerfect();
    	PerfectNumberTaskFactory factory = new PerfectNumberTaskFactory(this);
    	for (int num = 0; num < numbers; num++) {
    		factory.createPerfectNumberTask(result,listToSearch.get(num));
    	}
    	//aca tiene q ir el stop para todos los threads
    	myThreadPool.stop(result);
    	return result.listPerfect(); 
    }

	public void launchPerfectNumberTask(PerfectNumberTask task) {
		myThreadPool.launch(task);
		
	}
}
