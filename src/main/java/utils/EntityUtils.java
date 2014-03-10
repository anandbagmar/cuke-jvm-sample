package utils;

import cucumber.api.DataTable;
import gherkin.deps.com.google.gson.internal.StringMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.FileUtils.loadJsonEntityFrom;

public class EntityUtils {
    private static HashMap<String, String> getListofJsonEntitiesToBeLoadedFrom(DataTable entities) {
        List<Map<String,String>> entitiesToUse = entities.asMaps();
        HashMap<String, String> loadEntities = new HashMap<String, String>();
        for(Map<String,String> eachEntity: entitiesToUse){
            loadEntities.put(eachEntity.get("entity_type"), eachEntity.get("data_section_to_use"));
        }
        return loadEntities;
    }

    private static HashMap<String, StringMap> loadSpecifcSectionsFromJson(HashMap<String, String> loadEntities) {
        HashMap<String, StringMap> loadedTestData = new HashMap<String, StringMap>();
        for (String jsonFile : loadEntities.keySet()) {
            StringMap loadedJson = (StringMap) loadJsonEntityFrom(jsonFile, loadEntities.get(jsonFile));
            loadedTestData.put(loadEntities.get(jsonFile), loadedJson);
//            for (Object key : loadedJson.keySet()) {
//                System.out.println("\t" + key.toString() + " : " + loadedJson.get(key));
//            }
        }
        return loadedTestData;
    }

    public static HashMap<String, StringMap>  getTestDataFromEntities(DataTable entities) {
        HashMap<String, String> loadEntities = EntityUtils.getListofJsonEntitiesToBeLoadedFrom(entities);
        return EntityUtils.loadSpecifcSectionsFromJson(loadEntities);
    }
}
