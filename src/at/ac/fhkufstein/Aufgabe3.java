package at.ac.fhkufstein;

import at.ac.fhkufstein.Weather.Weather;
import at.ac.fhkufstein.Mapper.ObjectMapperWeather;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Aufgabe3
{
    public static void main(String[] args)
    {
        try {
            //getting the xml file to read
            File file = new File("src/at/ac/fhkufstein/weather.xml");
            //creating the JAXB context
            JAXBContext jaxbContext = JAXBContext.newInstance(Weather.class);
            //creating the unmarshall object
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            //calling the unmarshall method
            Weather weather = (Weather) unmarshaller.unmarshal(file);
            System.out.println(weather);

            ObjectMapperWeather om = new ObjectMapperWeather();
            om.writeJson(weather);
        }
        catch (JAXBException ex){
            ex.printStackTrace();
        }
    }
}
