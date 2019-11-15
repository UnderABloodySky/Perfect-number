package threadPool;
import java.math.BigInteger;

import buffer.Buffer;
import perfectNumber.BufferPerfect;
import perfectNumber.ConvenientBarrier;
import perfectNumber.PerfectNumberTask;

public class ThreadPool {
    private Buffer myBuffer;
    private int quantityWorkers;
    private ConvenientBarrier myBarrier;

    public ThreadPool(int capacityBuffer, int _quantityWorkers){
        myBuffer = new Buffer(capacityBuffer);
        myBarrier = new ConvenientBarrier(_quantityWorkers);
        quantityWorkers = _quantityWorkers;
        this.createWorkers(myBarrier, quantityWorkers);
    }

        private synchronized void createWorkers(ConvenientBarrier _myBarrier, int _quantityWorker){
            for(int i = 0; i < _quantityWorker; i++){
                PerfectWorker aWorker = new PerfectWorker(_myBarrier, myBuffer);
                aWorker.start();
            }
        
        }    
        public synchronized void launch(Runnable aTask){
            myBuffer.write(aTask);
        }
        
//        ver si no tiene q esperar aca el thread principal
        public synchronized void stop(BufferPerfect result){
            this.addNeg(result);
            myBarrier.waiting();
        }

		private void addNeg(BufferPerfect result) {
			
			for(int i=0; i<quantityWorkers;i++) {
				BigInteger neg = new BigInteger("-1");
				PerfectNumberTask negTask = new PerfectNumberTask(result, neg);
				myBuffer.write(negTask);
			}
		}
}






