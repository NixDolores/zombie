/**
 *  The DataStore class acts as a intermediary between the system and the
 *  specific persistent data base type.
 */
package db;

import game.DataObject;
import java.lang.reflect.InvocationTargetException;

public class DataStore {

    private static final DBConnector connector = new MySQLConnector();

    /**
     * Given a DataObject, this method translates that DataObject into primitive
     * name-value pairs that can be used by a DBConnector class.
     * @param obj
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchFieldException
     */
    public static int createObject(DataObject obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // Send name-value pairs to the connector class. This class should
        // return a generated id number.
        int id = connector.createObject(obj.getProperties(), obj.getDataTable());
        // Associate this new id number with the object that was just saved.
        obj.setId(id);
        // Return the new id number.
        return id;
    }


    /**
     * @TODO Implement this process. Add conditional that allow for searching and
     * filtering objects from the Database.
     * @return DataObject
     */
    public static DataObject readObect() {
        return new DataObject();
    }


    /**
     * @TODO Implement this process. Updates an object already recorded in the
     * database with new property values.
     * @param obj
     * @return Boolean
     */
    public static Boolean updateObject(DataObject obj) {
        return true;
    }


    /**
     * @TODO Implement this process. Deletes an object from the database. Since
     * we never want to actually delete records, we'll need to add an "active"
     * property to the base DataObject class. This implementation will then set
     * the active value to 0.
     * @param obj
     * @return Boolean
     */
    public static Boolean deleteObject(DataObject obj) {
        return true;
    }

}
