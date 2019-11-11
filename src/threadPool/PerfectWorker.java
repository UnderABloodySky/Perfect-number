package threadPool;

import buffer.Buffer;

public class PerfectWorker extends Thread {
    private Buffer aBuffer;

    public PerfectWorker(Buffer _buffer){
        aBuffer = _buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task aTask = (Task) aBuffer.read();
                aTask.run();
            }
            catch (PoisonException e){
                //e.printStackTrace();
                break;
            }
        }
    }
}

