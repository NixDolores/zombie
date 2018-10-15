/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ike
 */
public class DynamicData {

    protected final String dataTable = "";
    
    public Map getProperties() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        // A transport data object for name-value pairs.
        Map<String,String> pairs = new HashMap<>();
        Class<?> c = this.getClass();
        while (!c.getName().equals("java.lang.Object")) {
            Field[] fields = c.getDeclaredFields();
            // Iterate through each.
            for(Field f : fields) {
                String fieldName = f.getName();
                // If the field isn't part of the do-not-include array.
                int mods = f.getModifiers();
                if (!Modifier.isPublic(mods) && !Modifier.isStatic(mods) && !Modifier.isFinal(mods)) {
                    String fieldValue = f.get(this).toString();
                    // Add the name value pair to the map.
                    pairs.put(fieldName, fieldValue);
                }
            }
            c = c.getSuperclass();
        }
        return pairs;
    }

    public String getDataTable() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Class<?> c = this.getClass();
        Field f = c.getDeclaredField("dataTable");
        return f.get(this).toString();
    }

}
