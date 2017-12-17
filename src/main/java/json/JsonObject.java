package json;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private List<JsonPair> jsonPairs;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = new LinkedList<>();
        for (JsonPair jsonPair: jsonPairs){
            for (JsonPair pair : this.jsonPairs) {
                if (pair.key.equals(jsonPair.key)) {
                    int index = this.jsonPairs.indexOf(pair);
                    this.jsonPairs.set(index, jsonPair);
                    return;
                }
            }
            this.jsonPairs.add(jsonPair);
        }

    }

    @Override
    public String toJson() {
        return "{\n"+getJsonObjectBody()+"\n}";
    }

    private String getJsonObjectBody(){
        String jsonObjStr = "";
        Iterator<JsonPair> jsonPairIterator = jsonPairs.iterator();
        while (jsonPairIterator.hasNext()) {
            JsonPair pair = jsonPairIterator.next();
            jsonObjStr += " '"+pair.key + "': " + pair.value.toJson();
            if (jsonPairIterator.hasNext()){
                jsonObjStr += ",\n";
            }
        }
        return jsonObjStr;
    }

    public void add(JsonPair jsonPair) {
        for (JsonPair pair : jsonPairs) {
            if (pair.key.equals(jsonPair.key)){
                int index = jsonPairs.indexOf(pair);
                jsonPairs.set(index, jsonPair);
                return;
            }
        }
        this.jsonPairs.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair jsonPair: jsonPairs) {
            if (jsonPair.key.equals(name)){
                return jsonPair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObject = new JsonObject();
        for (String name : names) {
            Iterator<JsonPair> jsonPairIterator = jsonPairs.iterator();
            while (jsonPairIterator.hasNext()) {
                JsonPair pair = jsonPairIterator.next();
                if (pair.key.equals(name)){
                    jsonObject.add(pair);
                }
            }
        }
        return jsonObject;
    }
}
