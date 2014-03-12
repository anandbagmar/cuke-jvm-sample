package utils;

import cucumber.api.DataTable;
import gherkin.deps.com.google.gson.internal.StringMap;

import java.util.*;

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
        HashMap<String, StringMap> loadedTestData = EntityUtils.loadSpecifcSectionsFromJson(loadEntities);
        loadedTestData = EntityUtils.randomizeEntities(entities, loadedTestData);
        return loadedTestData;
    }

    private static HashMap<String, StringMap> randomizeEntities(DataTable entities, HashMap<String, StringMap> loadedTestData) {
        HashMap<String, StringMap> randomizedTestData = loadedTestData;
        ArrayList<String> randomizeEntityList = EntityUtils.getListofJsonEntitiesToBeRandomized(entities);
        for (int randomizeEntityNumber=0; randomizeEntityNumber<randomizeEntityList.size(); randomizeEntityNumber++) {
            loadedTestData.put(randomizeEntityList.get(randomizeEntityNumber),
                    randomize(loadedTestData.get(randomizeEntityList.get
                            (randomizeEntityNumber))));
        }
        return randomizedTestData;
    }

    private static StringMap randomize(StringMap randomizeTestData) {
        System.out.println ("*** Randomize this: " + randomizeTestData);
        return randomizeTestData;
    }

    private static ArrayList<String> getListofJsonEntitiesToBeRandomized(DataTable entities) {
        ArrayList<String> randomizeEntityList = new ArrayList<String>();
        List<Map<String, String>> entitiesToUse = entities.asMaps();
        for (int numberOfEntities=0; numberOfEntities<entitiesToUse.size(); numberOfEntities++) {
            Map eachEntity = (Map) entitiesToUse.get(numberOfEntities);

            if(eachEntity.get("randomize")!= null && eachEntity.get("randomize").equals("true")) {
                randomizeEntityList.add((String) eachEntity.get("data_section_to_use"));
            }
        }
        return randomizeEntityList;
    }
}
