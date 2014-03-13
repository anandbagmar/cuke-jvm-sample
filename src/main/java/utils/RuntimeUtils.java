package utils;

import java.util.HashMap;

public class RuntimeUtils {
    private static HashMap<String, Object> state = new HashMap<String, Object>();

    private RuntimeUtils() {}

    public static void saveState(String key, Object value) {
        state.put(key, value);
    }

    public static Object retrieveState(String key) {
        return state.get(key);
    }
}
