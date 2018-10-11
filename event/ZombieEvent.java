package event;

import java.util.EventObject;


public class ZombieEvent extends EventObject {

    private final ZombieMessage _message;

    public ZombieEvent(Object source, ZombieMessage message) {
        super(source);
        this._message = message;
    }

    public ZombieMessage getMessage() {
        return _message;
    }

}
