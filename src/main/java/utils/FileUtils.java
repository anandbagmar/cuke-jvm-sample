package utils;

import gherkin.deps.com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.util.HashMap;

public class FileUtils extends BaseUtils {
    public static String convertStringToJsonString(String xmlSource) {
        JSONObject xmlJSONObj;
        String jsonPrettyPrintString = "";
        try {
            if (!xmlSource.startsWith("<?xml ")) {
                xmlSource = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xmlSource);
            }
            xmlJSONObj = XML.toJSONObject(xmlSource);
            jsonPrettyPrintString = xmlJSONObj.toString(4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonPrettyPrintString;
    }

    public static Object loadJsonEntityFrom(String jsonFile, String section) {
        HashMap jsonFileContent = getJsonFileContent(jsonFile);
        return jsonFileContent.get(section);
    }

    public static String getNormalisedFileName(String name) {
        name = name.replaceAll("[^[^a-zA-Z0-9]*]", "");
        return name.length()>50 ? name.substring(0,50) : name;
    }

//    public static String getAbsolutePathForEntity(String fileName) {
//        File f;
//        String path = "";
//
//        try {
//            f = new File(fileName);
//            if (f.exists()) {
//                path = f.getAbsolutePath();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("\tAbsolute path for File: " + fileName + "\n\tAbsolute Path: " + path);
//        return path;
//    }

    private static HashMap getJsonFileContent(String fileName) {
        fileName = "src/test/entities/" + fileName + ".json";
        HashMap loadedJson = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            Gson gson = new Gson();
            loadedJson = gson.fromJson(bufferedReader, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedJson;
    }
}
