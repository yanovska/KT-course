package Device;
import Loggers.Logger;
import java.util.ArrayList;

public class KitchenHoods extends Functions {
    private int currMode = 1;
    private ArrayList<String> modes;
    public KitchenHoods(Logger logger, String name) {
        super(logger, name);
    }

}