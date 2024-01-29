class PrintNameThread3 implements Runnable {
    Thread thread;

    PrintNameThread3(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    public void run() {
        String name = thread.getName();
        for (int i = 0; i < 100; i++) {
            System.out.print(name);
        }
    }
}

class TestThread3 {
    public static void main(String args[]) {
        PrintNameThread3 pnt1 = new PrintNameThread3("A");
        PrintNameThread3 pnt2 = new PrintNameThread3("B");
        PrintNameThread3 pnt3 = new PrintNameThread3("C");
        PrintNameThread3 pnt4 = new PrintNameThread3("D");
        System.out.println("Running threads...");
        try {
            pnt1.thread.join();
            pnt2.thread.join();
            pnt3.thread.join();
            pnt4.thread.join();
        } catch (InterruptedException ie) {
        }
        System.out.println("Threads killed."); // dicetak terakhir
    }
}
