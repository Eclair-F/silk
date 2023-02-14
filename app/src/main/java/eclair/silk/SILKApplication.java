package eclair.silk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.LinkedList;
import java.util.List;

public class SILKApplication extends Application {
    private final List<Activity> activityList = new LinkedList<Activity>();
    private static SILKApplication instance;
    static Context context;
    static SharedPreferences sharedPreferences;

    public SILKApplication() {
    }

    public static SILKApplication getInstance() {
        if (null == instance) {
            instance = new SILKApplication();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static Context getContext() {
        return context;
    }
}
