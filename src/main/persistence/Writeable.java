package persistence;

import org.json.JSONObject;

// Source - JSON Serialization Demo by CPSC210 team

public interface Writeable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
