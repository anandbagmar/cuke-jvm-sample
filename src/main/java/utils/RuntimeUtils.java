package utils;

import java.util.HashMap;
import java.util.Map;

public class RuntimeUtils {
    private static HashMap<String, Object> state = new HashMap<String, Object>();
    private RuntimeUtils() {}

    public static void saveState(String key, Object value) {
        state.put(key, value);
    }

    public static Object retrieveState(String key) {
        return state.get(key);
    }

    public static String loadfile(Map<String, String> entity){
        return entity.get("entity_type");
    }
    public static String retrieveEntitySection(Map<String, String> entity){
        return entity.get("data_section_to_use");
    }
}
