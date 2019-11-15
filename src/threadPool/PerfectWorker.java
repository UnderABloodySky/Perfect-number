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
                
                aTask.run();
                aTask = (Task) aBuffer.read();
            }
           catch (PoisonException e){
                
                break;
            }
        }

        aBarrier.waiting();
        
    }

}

