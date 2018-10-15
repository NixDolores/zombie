package game;

import db.DataStore;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * @author ike
 */
public class DataObject extends DynamicData {

    protected final String dataTable = "test_table";
    protected String name;
    protected String uuid;
    protected int id;

    public DataObject() {
        this.setUuid(DataObject.generateUuid());
    }

    public Boolean save() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        DataStore.createObject(this);
        return true;
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

    protected static String generateUuid() {
        return UUID.randomUUID().toString();
    }

}
