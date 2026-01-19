package java8;

import java.util.Scanner;

public class UserFinder {
    public static void main(String[] args) {
        while(true) {
            findUser();
            System.out.println("Accepting another user to find by not blocking ");
        }



    }

    private static void findUser() {
        System.out.println("Please enter username ");
        Scanner scanner = new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("Entered name: "+name);

        Runnable userJob= () -> {
            try {
                System.out.println("Finding User"+name);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

           ResultPrinter printer= (result)-> System.out.println("found user "+result+"from database");
            printer.showResult(name);
        };

        new Thread(userJob).start();
    }
}
