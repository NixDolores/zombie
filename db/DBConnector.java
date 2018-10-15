package db;

import java.util.Map;

/**
 * @author ike
 */
public interface DBConnector {
    
    public abstract Boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table);
    
    public abstract int createObject(Map<String,String> _keyValuePairs, String _table);
    
    public abstract Map<String,String> readObject(Map<String,String> _keyValuePairs);
    
    public abstract Boolean deleteObject(String uuid);

}
