package eclair.silk.utils;

import eclair.silk.SILKApplication;
import eclair.silk.enums.SortMethod;

public class SharedPreferencesGetter {
    public static String getFileDateFormat() {
        return "yyyy-MM-dd HH:mm:ss";
    }

    public static String getSortMethod() {
        return SILKApplication.getSharedPreferences().getString("sort", SortMethod.BY_NAME.getName());
    }

    public static boolean getGetRoot() {
        return SILKApplication.getSharedPreferences().getBoolean("getRoot", false);
    }
}
