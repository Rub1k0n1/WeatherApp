package parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import reader.JsonReader;

public class JsonParser {
    private JsonReader jsonReader;
    private String city;
    private JSONParser jsonParser;
    private JSONObject jsonObject;
    private JSONArray jsonArray;

    public JsonParser(String city) {
        this.city = city;
        jsonReader = new JsonReader(city);
    }

    public String parseCityName() throws ParseException {
        jsonParser = new JSONParser();
        jsonObject = (JSONObject) jsonParser.parse(jsonReader.read());
        return (String) jsonObject.get("name");
    }

    public String parseCountryName() throws ParseException {
        jsonParser = new JSONParser();
        jsonObject = (JSONObject) jsonParser.parse(jsonReader.read());
        return (String) jsonObject.get("country");
    }

    public Double parseTemperature() throws ParseException {
        jsonParser = new JSONParser();
        jsonObject = (JSONObject) jsonParser.parse(jsonReader.read());
        return (Double) jsonObject.get("temp");
    }

    public Double parseMinTemp() throws ParseException {
        jsonParser = new JSONParser();
        jsonObject = (JSONObject) jsonParser.parse(jsonReader.read());
        return (Double) jsonObject.get("temp_min");
    }

    public Double parseMaxTemp() throws ParseException {
        jsonParser = new JSONParser();
        jsonObject = (JSONObject) jsonParser.parse(jsonReader.read());
        return (Double) jsonObject.get("temp_max");
    }

    public String parseWeatherConditions() throws ParseException {
        jsonParser = new JSONParser();
        jsonObject = (JSONObject) jsonParser.parse(jsonReader.read());
        jsonArray = (JSONArray) jsonObject.get("weather");
        JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);
        return (String) jsonObject1.get("description");
    }

    public static void main(String[] args) throws ParseException {
        JsonParser jsonParser = new JsonParser("Kyiv");
        JsonReader jsonReader = new JsonReader("Kyiv");
        System.out.println(jsonReader.read());
        System.out.println(jsonParser.parseCityName());
        System.out.println(jsonParser.parseCountryName());
        System.out.println(jsonParser.parseTemperature());
        System.out.println(jsonParser.parseMinTemp());
        System.out.println(jsonParser.parseMaxTemp());
        System.out.println(jsonParser.parseWeatherConditions());
    }
}


