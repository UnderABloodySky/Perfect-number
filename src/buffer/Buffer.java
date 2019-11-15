package buffer;

public class Buffer {
        private Object[] slots;
        private int toWrite;
        private int toRead;
        private int capacity;
        private int count;

        public Buffer(int _capacity) {
            slots = new Object[_capacity];
            toWrite = 0;
            toRead = 0;
            count = 0;
            capacity = _capacity;
        }

        public synchronized void write(Object _object) {
            while (this.isFull()) {
                try {
        
                    wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
       
            count++;
            slots[toWrite] = _object;
            toWrite = this.nextStep(toWrite);
            notifyAll();
        }

        public synchronized Object read() {
            while (this.dataNotAvailable()) {
                try {
        
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            Object element = slots[toRead];
        
            slots[toRead] = null;
            toRead = nextStep(toRead);
            notifyAll();
            return element;
        }

        protected boolean isFull(){
            return count == capacity;
        }

        protected boolean dataNotAvailable(){
            return count == 0;
        }

        protected int nextStep(int n) {
            return (n + 1) % capacity;
        }
}
