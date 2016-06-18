package visacheckout.util;

import java.util.HashMap;
import java.util.Iterator;

import atg.json.JSONException;
import atg.json.JSONObject;

public class CFIUtil {
	
	public static HashMap<String, String> jsonToMap(String t) throws JSONException {

        HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jObject = new JSONObject(t);
        Iterator<?> keys = jObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = jObject.getString(key); 
            map.put(key, value);

        }
        
		return map;

    }

}
