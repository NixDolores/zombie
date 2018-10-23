package game;

import db.DataStore;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author ike
 */
public class DataObject extends DynamicData {

    protected final String dataTable = "test_table";
    protected String name;
    protected String uuid;
    protected int id;
    protected int active = 1;

    public DataObject() {
        this.setUuid(DataObject.generateUuid());
    }

    public static DataObject loadById(int _id) {
        HashMap map = new HashMap<String, String>();
        map.put("id", Integer.toString(_id));
        DataStore.readObect(map, "zombie_table");
        return new DataObject();
    }

    public static DataObject loadByUuid() {
        return new DataObject();
    }
    
    public static DataObject loadByCondition(String _name, String _value) {
        return new DataObject();
    }

    public Boolean save() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        DataStore.createObject(this);
        return true;
    }
    
    public Boolean delete() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        return DataStore.deleteObject(this);
    }

    public String getName() {
        return this.name;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setUuid(String _uuid) {
        this.uuid = _uuid;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void makeActive() {
        this.active = 1;
    }
    
    public void makeInactive() {
        this.active = 0;
    }

    protected static String generateUuid() {
        return UUID.randomUUID().toString();
    }

}
