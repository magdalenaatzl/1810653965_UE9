package at.ac.fhkufstein;

import at.ac.fhkufstein.Weather.Weather;
import at.ac.fhkufstein.Mapper.ObjectMapperWeather;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class Aufgabe2
{
    public static void main(String[] args) {
        try {
            ObjectMapperWeather omw = new ObjectMapperWeather();
            Weather weather = omw.readJson("src/at/ac/fhkufstein/weather.json");
            //creating the JAXB context
            JAXBContext jaxbContext = JAXBContext.newInstance(Weather.class);
            //creating the marshaller Object
            Marshaller marshaller = jaxbContext.createMarshaller();
            //setting the porperty to show xml format output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //calling the marshall method
            marshaller.marshal(weather, new File("src/at/ac/fhkufstein/weather.xml"));

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
