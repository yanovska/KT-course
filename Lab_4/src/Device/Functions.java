package Device;
import Loggers.Logger;
public class Functions {

    private String _name;
    public Logger logger;
    private boolean _isTurnedOn = false;
    public Functions(Logger logger, String name){
        this.logger = logger;
        this._name = name;
    }
    public boolean turnOnOff(boolean on) {
        if (_isTurnedOn == on) return false;
        _isTurnedOn = on;
        logger.Log(_name + " has turned " + (on ? "on" : "off"));
        return true;
    }
    public boolean isTurnedOn() {
        return _isTurnedOn;
    }
    public String getName() {
        return _name;
    }

    public String getState() {
        String state = "Name: " + this._name +
                "\nState: " + (this._isTurnedOn ? "On" : "Of") ;

        return state;
    }

}
