package at.ac.fhkufstein.Mapper;


import at.ac.fhkufstein.Weather.Weather;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ObjectMapperWeather {
    public Weather readJson(String path) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();

        Weather weather = mapper.readValue(new File(path), Weather.class);

        return weather;
    }

    public void writeJson(Weather w){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(w);
            System.out.println("JSON String: " + jsonString);
        } catch(JsonGenerationException e){
            e.printStackTrace();
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
