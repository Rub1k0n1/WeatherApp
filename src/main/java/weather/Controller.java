package weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class Controller {
    @GetMapping("/")
    public String weatherNow() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Weather weather = new Weather(reader.readLine());
        return weather.toString();
    }
}
