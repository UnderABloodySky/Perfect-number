package threadPool;



import buffer.Buffer;
import perfectNumber.ConvenientBarrier;

public class PerfectWorker extends Thread {
    private Buffer aBuffer;
    private ConvenientBarrier aBarrier;
    

    public PerfectWorker(ConvenientBarrier _Barrier, Buffer _buffer){
        aBuffer = _buffer;
        aBarrier = _Barrier;
    }

    @Override
    public void run() {
    	Task aTask = (Task) aBuffer.read();
    	
        while (!(aTask.isNegative())) {
           try {
                //Task aTask = (Task) aBuffer.read();
                aTask.run();
                aTask = (Task) aBuffer.read();
            }
           catch (PoisonException e){
                //e.printStackTrace();
                break;
            }
        }
//        System.out.print("termine");
        aBarrier.waiting();
        
//        PoisonPill stoped = new PoisonPill();
//        stoped.run();
//        
    }

//	private boolean isNegative() {
//		BigInteger oneNeg = new BigInteger("-1");
//		boolean result =aBuffer.read().equals(oneNeg);	
//		return result;
//	}
}

