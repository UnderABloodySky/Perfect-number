package perfectNumber;

public class ConvenientBarrier {
	 private int waiting;
	    private int limit;
	    public ConvenientBarrier(int _n){
	        waiting = 0;
	        limit = _n;
	    }

	    public synchronized void waiting(){
	        while(waiting < limit){
	            waiting++;
	            try{
	                wait();
	            }
	            catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            //notifyAll();
	        }
	        notifyAll();
	    }
}
