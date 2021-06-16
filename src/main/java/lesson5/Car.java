package lesson5;

import java.util.concurrent.BrokenBarrierException;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            MainClass.countDownLatch.countDown();
            System.out.println(this.name + " готов");
            MainClass.cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try {
            if (MainClass.lock.tryLock()) {
                System.out.println(this.name + " выиграл гонку");
                MainClass.countDownLatchEnd.countDown();
                MainClass.cyclicBarrier.await();
                MainClass.lock.unlock();
            } else {
                MainClass.countDownLatchEnd.countDown();
                MainClass.cyclicBarrier.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
