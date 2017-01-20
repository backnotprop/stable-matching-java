package codes.ramos;

import java.io.File;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.HashMap;

import StableMatch.Entity;
import StableMatch.StableMatch;


public class App
{
    public static void main( String[] args )
    {

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Map> dataRead;
        Map<String, Entity> parsedMap = new HashMap<String, Entity>();

        try {
            dataRead = mapper.readValue(new File("data.json"), new TypeReference<Map>() {});

            for(Map.Entry<String,Map> entity: dataRead.entrySet()) {
                parsedMap.put(entity.getKey(), new Entity(entity.getValue()));
            }

            StableMatch sm = new StableMatch(parsedMap);
            sm.proposalStage();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
