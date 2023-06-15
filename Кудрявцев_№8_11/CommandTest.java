import java.util.Scanner;
import java.util.concurrent.TimeUnit;

interface Command {
    void execute() throws InterruptedException;
}
class Order {
    public void start_order() {
        System.out.println("Принять заказ");
    }

    public void stop_order() {
        System.out.println("Отменить заказ");
    }

    public void wait_order() throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Хотите отменить заказ?");
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        if (answer.equals("Да")){
            stop_order();
        }
        else
            for (int i = 10; i < 30; i++) {
                System.out.println(i);
                TimeUnit.SECONDS.sleep(1);
            }
    }
}
class Start_Restarant implements Command {
    Order order;
    public Start_Restarant(Order order) {
        this.order = order;
    }
    public void execute() {
        order.start_order();
    }
}
class Stop_Restarant implements Command {
    Order order;
    public Stop_Restarant(Order order) {
        this.order = order;
    }
    public void execute() {
        order.stop_order();
    }
}
class Wait_Restarant implements Command{
    Order order;
    public Wait_Restarant(Order order) {
        this.order = order;
    }
    public void execute() throws InterruptedException {
        order.wait_order();
    }
}

class ResInvoker {
    public Command command;
    public ResInvoker(Command command){
        this.command = command;
    }
    public void execute() throws InterruptedException {
        this.command.execute();
    }
}

public class CommandTest {//тест
    public static void main(String[] args) throws InterruptedException {
        Order order = new Order();
        Start_Restarant start_res = new Start_Restarant(order);
        Stop_Restarant stop_res = new Stop_Restarant(order);
        Wait_Restarant wait_res = new Wait_Restarant(order);
        ResInvoker resInvoker = new ResInvoker(start_res);
        resInvoker.execute();
        ResInvoker resInvoker1 = new ResInvoker(wait_res);
        resInvoker1.execute();
    }
}