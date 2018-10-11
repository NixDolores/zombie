/*
 * This is the base class for any object that will throw or catch events being
 * fired.
 */
package actors;

import event.ZombieEvent;
import event.ZombieEventListenerInterface;
import event.ZombieMessage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author riquigley
 */
public class ZombieGameObject implements ZombieEventListenerInterface {

    private final List listeners = new ArrayList();

   /*
    * Register a listener to be called upon when an event is fired.
    * @param ZombieEventListenerInterface listener the object that is called upon.
    */
    public synchronized void addSRegisterListener(ZombieEventListenerInterface listener) {
        listeners.add(listener);
    }

   /*
    * Unregister an event from being called upon.
    * @param ZombieEventListenerInteface listener the object to unregister.
    */
    public synchronized void removeSRegisterListener(ZombieEventListenerInterface listener) {
        listeners.remove(listener);
    }

   /*
    * When an event is fired, this method iterates through the events and fires off
    * their messageReceived method. We translate the listener array to an object array
    * while iterating in order to avoid Concurrent Access errors.
    * @param ZombieEvent event - the event that caused this to be fired.
    */
    protected synchronized void fireEvent(int _eventCode) {
        ZombieMessage mess = new ZombieMessage(_eventCode);
        ZombieEvent evt = new ZombieEvent(this, mess);
        this.fireEvent(evt);
    }

   /*
    * When an event is fired, this method iterates through the events and fires off
    * their messageReceived method. We translate the listener array to an object array
    * while iterating in order to avoid Concurrent Access errors.
    * @param ZombieEvent event - the event that caused this to be fired.
    */
    protected synchronized void fireEvent(ZombieEvent _event) {
        // Clone the active listeners.
        Object[] temp_list = this.listeners.toArray();
        for (Object temp_list1 : temp_list) {
            ZombieEventListenerInterface temp_obj = (ZombieEventListenerInterface) temp_list1;
            temp_obj.messageReceived(_event);
        }
    }

    @Override
    public void messageReceived(ZombieEvent event) {
        System.out.println("Message Received has not been implemented for this class");
    }

}
