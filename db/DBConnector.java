package db;

import java.util.Map;

/**
 * The DBConnector interface describes the methods that must be implemented for
 * any database class that is expected to work with this system.
 * The basic CRUD operations are detailed below, but more advanced features,
 * including loading by name, uuid, id or type can be added.
 * @author ike
 */
public interface DBConnector {

    public abstract int createObject(Map<String,String> _keyValuePairs, String _table);

    public abstract Map<String,String> readObject(Map<String,String> _keyValuePairs);

    public abstract Boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table);

    public abstract Boolean deleteObject(String uuid);

}
