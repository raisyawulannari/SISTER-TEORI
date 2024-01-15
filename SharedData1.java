class SharedData1 {
    int data;

    synchronized void set(int value) {
        System.out.println("Generate " + value);
        data = value;
    }

    synchronized int get() {
        System.out.println("Get " + data);
        return data;
    }
}

class Producer implements Runnable {
    SharedData1 sd;

    Producer(SharedData1 sd) {
        this.sd = sd;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.set((int) (Math.random() * 100));
        }
    }
}

class Consumer implements Runnable {
    SharedData1 sd;

    Consumer(SharedData1 sd) {
        this.sd = sd;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.get();
        }
    }
}

class TestProducerConsumer {
    public static void main(String args[]) throws Exception {
        SharedData1 sd = new SharedData1();
        new Producer(sd);
        new Consumer(sd);
    }
}
