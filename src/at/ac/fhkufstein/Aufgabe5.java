package at.ac.fhkufstein;

import at.ac.fhkufstein.Mapper.ObjectMapperWeather;
import at.ac.fhkufstein.Weather.Weather;
import at.ac.fhkufstein.Weather.Weather_Aufgabe5;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Aufgabe5 {
    public static void main(String[] args) throws JAXBException {

        File file = new File("src/at/ac/fhkufstein/weather.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Weather.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Weather weather = (Weather) unmarshaller.unmarshal(file);
        System.out.println(weather);

        Weather_Aufgabe5 w2 = new Weather_Aufgabe5(weather.getId(), weather.getMain(), weather.getDescription()
                , weather.getIcon());
        ObjectMapperWeather om = new ObjectMapperWeather();
        om.writeJson_Aufgabe5(w2);

    }
}
