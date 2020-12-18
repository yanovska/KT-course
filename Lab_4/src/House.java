import java.util.ArrayList;
import Loggers.Logger;
import Device.Lamp;
import Device.Functions;
import Console.Commands;
import Device.Teapot;
import Device.RobotVacuumCleaner;
import Device.KitchenHoods;
public class House implements Logger {
    private int RobotVacuumCleanerId = 0;
    private int washingMachineId = 0;
    private int lampId = 0;
    private int teapotId = 0;
    private Commands consoleHelper;
    private ArrayList<Functions> components;
    {
        consoleHelper = new Commands();
        components = new ArrayList<>();
    }
    private boolean addDevice(String component) {
        Functions newComponent;
        switch (component) {
            case "RobotVacuumCleaner":
                newComponent = new RobotVacuumCleaner(this, "RobotVacuumCleaner" + ++RobotVacuumCleanerId);
                break;
            case "KitchenHoods":
                newComponent = new KitchenHoods(this,"KitchenHoods" + ++washingMachineId);
                break;
            case "Lamp":
                newComponent = new Lamp(this,"Lamp" + ++lampId);
                break;
            case "Tearpot":
                newComponent = new Teapot(this,"Tearpot" + ++teapotId);
                break;
            default:
                return false;
        }
        components.add(newComponent);
        consoleHelper.print(newComponent.getName() + " has been added");
        return true;
    }
    private boolean removeComponent(String name) {
        Functions compToRemove = null;
        for (Functions component : components) {
            if (component.getName().equals(name)) {
                compToRemove = component;
            }
        }
        if (compToRemove != null) {components.remove(compToRemove);
            consoleHelper.print(name + " has been removed");
            return true;
        }
        return false;
    }
    private Functions findComponentByName(String name){
        for (Functions cmp : components) {
            if (cmp.getName().equals(name)) {
                return cmp;
            }
        }
        return null;
    }
    public void performCommand(String cmd){
        if (!consoleHelper.isCommandValid(cmd)){
            consoleHelper.printInfoAboutSuccess(false);
            return;
        }
        String[] cmdParts = cmd.split(" ");
        String action = cmdParts[0];
        boolean succeed = true;
        switch(action){
            case "add":
                String compType = cmdParts[1];
                succeed = addDevice(compType);
                break;
            case "delete":
                String compName = cmdParts[1];
                succeed = removeComponent(compName);
                break;
            case "on":
                compName = cmdParts[1];
                Functions component = findComponentByName(compName);
                if (component != null){
                    succeed = component.turnOnOff(true);
                }
                else {
                    succeed = false;
                }
                break;
            case "off":
                compName = cmdParts[1];
                component = findComponentByName(compName);
                if (component != null){
                    succeed = component.turnOnOff(false);
                }
                else {succeed = false;
                }
                break;

            case "mode" :
                compName = cmdParts[1];
                component = findComponentByName(compName);
                if (component != null && component.isTurnedOn()) {
                    int modeNumber = Integer.valueOf(cmdParts[2]);

                    if (component.getClass().equals(RobotVacuumCleaner.class)) {
                        succeed = ((RobotVacuumCleaner)component).setCurrMode(modeNumber);
                    }
                }
                else {
                    succeed = false;
                }
                break;
            case "info":
                consoleHelper.printDetailedInformation(components);
            case "help":
                consoleHelper.print( "Device: \n  RobotVacuumCleaner \n  KitchenHoods \n  Lamp\n  Tearpot\n"+"\nCommands: \n" +
                                " add name_device \n"+
                                " delete name_device\n" +
                        " on name_device \n" +
                        " off name_device \n" +
                                " mode name_RobotVacuumCleaner mode_number \n" +
                        " Mode: 1.Automatic\n  2.Local\n  3.Around perimeter\n  4.Max\n" +
                        " info -> information devices\n"
                );
                break;
        }
        consoleHelper.printInfoAboutSuccess(succeed);}
        @Override
    public void Log(String message) {
        consoleHelper.print(message);
    }
}
