import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class task {
    private static HashSet<Person> guys = new HashSet<Person>();
    private static ArrayList<String> people = new ArrayList<>();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static volatile int buf = 0;
    private static void methodThatModifiesMap(String str) {
        reentrantReadWriteLock.writeLock().lock();
        try {
            people.add(str);
            people.add(str);
            people.add(str);
        }
        finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
    private static void methodThatJustReadsmap(int n) {
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(people.get(n));
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
    private static void task1(String str, int n){
        methodThatModifiesMap(str);
        for (int i = 0; i < 3; i++) {
            methodThatJustReadsmap(n);
        }
    }
    synchronized static void add_inc(Person n){
        guys.add(n);
        guys.add(n);
    }
    synchronized static void increment(int number) {
        buf++;
        for(Person p : guys){
            System.out.println("Thread m" + number + " : " + p.getName());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Person test1 = new Person("hi");
        Person test2 = new Person("hello");

        Thread first = new Thread(()->{
            task1("A", 1);
        });
        Thread second = new Thread(()->{
            task1("B", 3);
        });
        Thread fourth = new Thread(()->{
            add_inc(test1);
            for (int i = 0; i < 3; i++) {
                increment(1);
            }
            buf = 0;
        });
        Thread fifth = new Thread(()->{
            add_inc(test2);
            for (int i = 0; i < 3; i++) {
                increment(2);
            }
            buf = 0;
        });
        first.start();
        second.start();
        Thread.sleep(3000);
        fourth.start();
        fifth.start();
    }
}

