package quick.brick;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);

        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine().trim();
        while (!cmd.equals("exit")) {
            orderService.userListener(cmd);
            cmd = scanner.nextLine().trim();
        }

        scanner.close();
        context.close();
    }

}
