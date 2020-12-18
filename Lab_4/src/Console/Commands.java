package Console;
import java.util.ArrayList;
import Device.Functions;
public class Commands {
    public boolean isCommandValid(String cmd) {
        String[] cmdParts = cmd.split(" ");
        String action = cmdParts[0];
        int len = cmdParts.length;
        if (len > 3){
            return false;
        }
        switch(action){
            case "add":
            case "delete":
            case "on":
                case "off":

            case "info":
            case "help":
            case "ListMode":

                return true;
            case "mode":
                if (len != 3){
                    return false;
                }
                try {
                    int value = Integer.parseInt(cmdParts[2]);
                    if (value < 0){
                        return false;
                    }
                }
                catch (NumberFormatException e){
                    return false;
                }
                return true;
            default:
                return false;
        }
    }
    public void printStrArr(String[] arr, String desc) {
        System.out.println(desc);
        for(String s : arr){
            System.out.println(s);}
    }
    public void printInfoAboutSuccess(boolean isSucceed){
        if (!isSucceed){
            System.out.println("Command failed.");
        }
    }
    public void printDetailedInformation(ArrayList<Functions> components){
        for (Functions cmp : components){
            System.out.println(cmp.getState());
        }
    }
    public void print(String description){
        System.out.println(description);
    }
}
