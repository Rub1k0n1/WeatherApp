package weather;


import lombok.SneakyThrows;
import org.json.simple.parser.ParseException;
import parser.JsonParser;

public class Weather {
    private JsonParser jsonParser;
    String city;

    public Weather(String city) {
        jsonParser = new JsonParser(city);
        this.city = city;
    }

    public String cityName() throws ParseException {
        return jsonParser.parseCityName();
    }

    public String countryName() throws ParseException {
        return jsonParser.parseCountryName();
    }

    public Double temperature() throws ParseException {
        return jsonParser.parseTemperature();
    }

    public Double minTemp() throws ParseException {
        return jsonParser.parseMinTemp();
    }

    public Double maxTemp() throws ParseException {
        return jsonParser.parseMaxTemp();
    }

    public String weatherConditions() throws ParseException {
        return jsonParser.parseWeatherConditions();
    }

    public String pressure() {
        return "null";
    }

    public String windSpeed() {
        return "null";
    }

    public String humidity() {
        return "null";
    }


    @SneakyThrows
    @Override
    public String toString() {
        return "Погода - \n" +
                "Город: " + cityName() + '\n' +
                "Страна: " + countryName() + '\n' +
                "Температура: " + temperature() + '\n' +
                "Мин.темп.: " + minTemp() + '\n' +
                "Макс.темп.: " + maxTemp() + '\n' +
                "Погодные условия: " + weatherConditions() + '\n' +
                "pressure: " + pressure() + '\n' +
                "Скорость ветра: " + windSpeed() + '\n' +
                "Влажность: " + humidity() + '\n';

    }

}
