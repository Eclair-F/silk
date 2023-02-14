package eclair.silk.shared;

import org.json.JSONObject;

import eclair.silk.SILKApplication;
import eclair.silk.utils.FileUtils;

public class FileTypesFile {
    public static JSONObject fileTypesJsonObject;

    public static JSONObject getJSONObject() {
        if (fileTypesJsonObject == null) {
            try {
                fileTypesJsonObject = new JSONObject(FileUtils.getString(SILKApplication.getContext().getAssets().open("fileTypes.json")));
            } catch (Exception e) {
                e.printStackTrace();
                fileTypesJsonObject = new JSONObject();
            }
        }
        return fileTypesJsonObject;
    }
}
