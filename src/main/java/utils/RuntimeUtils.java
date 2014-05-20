package utils;

import java.util.HashMap;

public class RuntimeUtils extends BaseUtils {
    private static HashMap<String, Object> state = new HashMap<String, Object>();

    private RuntimeUtils() {}

    public static Object saveState(String key, Object value) {
        state.put(key, value);
        return value;
    }

    public static Object retrieveState(String key) {
        return state.get(key);
    }
}
