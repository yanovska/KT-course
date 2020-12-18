import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        House house = new House();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter \"help\" ");
        for (;;) {
            String cmd = scanner.nextLine();
            house.performCommand(cmd);
        }
    }


}
