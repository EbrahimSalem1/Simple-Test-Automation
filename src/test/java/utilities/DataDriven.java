package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataDriven {
    public static class JsonClass {

       // try this with both [JSON with on object, and array of objects]
        public static String readJson(String filePath, String key) {
            JSONArray jsonArray = null;
            try {
                // Parse the JSON file
                jsonArray = (JSONArray) new JSONParser().parse(new FileReader(filePath));
            } catch (IOException e) {
                throw new RuntimeException("JSON file path not found!", e);
            } catch (ParseException e) {
                throw new RuntimeException("Cannot parse JSON file!", e);
            }

            // Iterate through the array to find the key
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                if (jsonObject.containsKey(key)) {
                    return (String) jsonObject.get(key);
                }
            }

            throw new RuntimeException("Invalid key entered!");
        }




//            JSONObject jsonObject = null;
//            try {
//                jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filePath));
//            } catch (IOException e) {
//                throw new RuntimeException("JsonFile Path not found!");
//            } catch (ParseException e) {
//                throw new RuntimeException("Cannot Parse Key entered!");
//            }
//
//            if (jsonObject.get(key) == null) {
//                throw new RuntimeException("Invalid Key Entered!");
//            }
//            return (String) jsonObject.get(key);
//        }

    }
}