package utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class FileUtils {
    public static String convertStringToJsonString(String xmlSource) {
        JSONObject xmlJSONObj = null;
        String jsonPrettyPrintString = "";
        try {
            if (!xmlSource.startsWith("<?xml ")) {
                xmlSource = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xmlSource);
            }
            xmlJSONObj = XML.toJSONObject(xmlSource);
            jsonPrettyPrintString = xmlJSONObj.toString(4);
//            System.out.println(jsonPrettyPrintString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonPrettyPrintString;
    }
}
