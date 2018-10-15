/**
 *  The DataStore class acts as a intermediary between the system and the 
 *  specific persistent data base type.
 */
package db;

import game.DataObject;
import java.lang.reflect.InvocationTargetException;

public class DataStore {

    private static DBConnector connector = new MySQLConnector();
    
    public static int createObject(DataObject obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // Turn properties into Name Value Pairs.
        return connector.createObject(obj.getProperties(), obj.getDataTable());
    }

    public static DataObject readObect() {
        return new DataObject();
    }

    public static Boolean updateObject(DataObject obj) {
        return true;
    }
    
    public static Boolean deleteObject(DataObject obj) {
        return true;
    }

}
