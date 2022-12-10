package EatingPhilosophers;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable{
    int meals = 0;
    String name;
    Semaphore sem;

    public Philosopher(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        while (meals < 5) {
            try {
                sem.acquire();
                System.out.println(name + " sits at the table");
                Thread.sleep(200);
                meals++;
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(name + " leaves the table");
            sem.release();
        }
    }
}
