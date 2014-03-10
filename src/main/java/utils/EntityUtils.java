package utils;

import cucumber.api.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityUtils {
    public static HashMap<String, String> entitiesToBeLoaded(DataTable entities) {
        List<Map<String,String>> entitiesToUse = entities.asMaps();
        HashMap<String, String> loadEntities = new HashMap<String, String>();
        for(Map<String,String> eachEntity: entitiesToUse){
            loadEntities.put(eachEntity.get("entity_type"), eachEntity.get("data_section_to_use"));
        }
        return loadEntities;
    }

}
