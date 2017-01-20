package StableMatch;

import java.util.Map;

public class StableMatch {
    public Map<String,Entity> dataMap;

    public StableMatch(Map data) {
        this.dataMap = data;
    }


    public void proposalStage() {
        System.out.println(dataMap.get("1").getName());

    }

}
