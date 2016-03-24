package mockapp.yashas.com.mocks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mahesh on 3/23/16.
 */
public class NetworkResponse {

    public class Entry {
        String title;
        String imgUrl;

        public Entry() {
        }

        public Entry(String pTitle, String pImgUrl) {
            title = pTitle;
            imgUrl = pImgUrl;
        }
    }

    public ArrayList<Entry> entries;


    public NetworkResponse() {

    }

    public NetworkResponse(JSONObject json) {

    }


    public void parse(JSONObject json) {

        try {
            JSONArray dataJSON = json.getJSONObject("data").getJSONArray("children");
            entries = new ArrayList<>();
            Entry entry;
            for (int i = 0; i < dataJSON.length(); i++) {
                JSONObject eachJSONObject = dataJSON.getJSONObject(i).getJSONObject("data");
                entry = new Entry();
                entry.title = getJSONValue("title", eachJSONObject, "");
                entry.imgUrl = getJSONValue("thumbnail", eachJSONObject, "");
                entries.add(entry);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getJSONValue(String key, JSONObject json, String defaultValue) {
        try {
            return json.getString(key);
        } catch (JSONException ex) {
        }
        return defaultValue;
    }


    public ArrayList<Entry> getMockData() {
        ArrayList<Entry> samplentries = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            samplentries.add(new Entry("Title " + i, "http://b.thumbs.redditmedia.com/_wyd7bK1uMKo0K2kZRWTpFuGmcSqqC9o30F-dkgnnkc.jpg"));
        }
        return samplentries;
    }

}
