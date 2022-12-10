package EatingPhilosophers;

import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);

        Thread[] philosophers = new Thread[5];
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Thread(new Philosopher(sem, "Philosopher " + (i+1)));
        }

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i].start();
        }

        for (int i = 0; i < philosophers.length; i++) {
            try {
                philosophers[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
