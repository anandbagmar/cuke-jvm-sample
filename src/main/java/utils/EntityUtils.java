package utils;

import cucumber.api.DataTable;
import gherkin.deps.com.google.gson.internal.StringMap;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

import static utils.FileUtils.loadJsonEntityFrom;

public class EntityUtils {
    public static HashMap<String, StringMap>  getTestDataFromEntities(DataTable entities) {
        HashMap<String, StringMap> loadedTestData = EntityUtils.loadSpecifcSectionsFromJson(entities);
        loadedTestData = EntityUtils.randomizeEntities(entities, loadedTestData);
        displayLoadedAndRandomizedTestData(loadedTestData);
        return loadedTestData;
    }

    private static void displayLoadedAndRandomizedTestData(HashMap<String, StringMap> loadedTestData) {
        System.out.println("Loaded / Randomized Test Data: ");
        for (String key : loadedTestData.keySet()) {
            System.out.println("\t" + key + " : " + loadedTestData.get(key));
        }
    }

    private static HashMap<String, String> getListofJsonEntitiesToBeLoadedFrom(DataTable entities) {
        List<Map<String,String>> entitiesToUse = entities.asMaps();
        HashMap<String, String> loadEntities = new HashMap<String, String>();
        for(Map<String,String> eachEntity: entitiesToUse){
            loadEntities.put(eachEntity.get("entity_type"), eachEntity.get("data_section_to_use"));
        }
        return loadEntities;
    }

    private static HashMap<String, StringMap> loadSpecifcSectionsFromJson(DataTable entities) {
        HashMap<String, String> loadEntities = EntityUtils.getListofJsonEntitiesToBeLoadedFrom(entities);
        HashMap<String, StringMap> loadedTestData = new HashMap<String, StringMap>();
        for (String jsonFile : loadEntities.keySet()) {
            StringMap loadedJson = (StringMap) loadJsonEntityFrom(jsonFile, loadEntities.get(jsonFile));
            loadedTestData.put(loadEntities.get(jsonFile), loadedJson);
        }
        return loadedTestData;
    }

    private static HashMap<String, StringMap> randomizeEntities(DataTable entities, HashMap<String, StringMap> loadedTestData) {
        HashMap<String, StringMap> randomizedTestData = loadedTestData;
        StringMap entityToRandomize = null;
        StringMap randomizedEntity = null;
        ArrayList<String> randomizeEntityList = EntityUtils.getListofJsonEntitiesToBeRandomized(entities);
        for (int randomizeEntityNumber=0; randomizeEntityNumber<randomizeEntityList.size(); randomizeEntityNumber++) {
            entityToRandomize = loadedTestData.get(randomizeEntityList.get(randomizeEntityNumber));
            randomizedEntity = randomize(entityToRandomize);
            loadedTestData.put(randomizeEntityList.get(randomizeEntityNumber),randomizedEntity);
        }
        return randomizedTestData;
    }

    private static StringMap randomize(StringMap<String> randomizeTestData) {
        for (String key: randomizeTestData.keySet()) {
            String randomizedValue = randomizeTestData.get(key);
            if(key.toLowerCase().contains("name") || key.toLowerCase().contains("street")) {
                randomizedValue = randomizeString(randomizedValue);
            } else if (key.toLowerCase().contains("phone")) {
                randomizedValue = randomizePhoneNumber(randomizedValue);
            }
            randomizeTestData.put(key, randomizedValue);
        }
        return randomizeTestData;
    }

    private static String randomizePhoneNumber(String toBeRandomized) {
        String randomizedString = toBeRandomized;
        try {
            String subsetToBeRandomized = toBeRandomized.substring(toBeRandomized.length()/2);
            Long randomizedNumber = Long.parseLong(subsetToBeRandomized);
            Random random = new Random(randomizedNumber);
            do {
                randomizedString = toBeRandomized.substring(0,subsetToBeRandomized.length()-1)
                        + (new Long(random.nextLong()).toString().substring(0,subsetToBeRandomized.length()));
            } while (randomizedString.contains("-"));
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number to be randomized: " + toBeRandomized + "\n" + nfe.toString());
        }
        return randomizedString;
    }

    private static String randomizeString(String toBeRandomized) {
        String randomizedString = RandomStringUtils.random(toBeRandomized.length(), toBeRandomized);
        return randomizedString;
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
