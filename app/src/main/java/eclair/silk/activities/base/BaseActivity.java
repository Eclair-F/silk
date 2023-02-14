package eclair.silk.activities.base;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;


import java.util.Locale;

import eclair.silk.R;
import eclair.silk.activities.FileManagerActivity;
import eclair.silk.SILKApplication;
import eclair.silk.utils.SystemUtils;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(this);
        init();
    }

    protected abstract void init();

    public static SharedPreferences getSharedPreferences() {
        return SILKApplication.getSharedPreferences();
    }

    public static void init(Activity activity) {
        SILKApplication.getInstance().addActivity(activity);
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (activity instanceof FileManagerActivity) {
            initTheme(activity, R.style.Theme_Silk_Dark_NoActionBar, R.style.Theme_Silk_NoActionBar);
        } else {
            initTheme(activity, R.style.Theme_Silk_Dark, R.style.Theme_Silk);
        }
        String language = sharedPreferences.getString("language", "auto");
        String[] languageAndCountry2 = new String[]{"en", "US"};
        if (language.equals("auto")) {
            languageAndCountry2 = new String[]{Locale.getDefault().getLanguage(), Locale.getDefault().getCountry().toUpperCase()};
        } else {
            try {
                languageAndCountry2 = language.split("_");
            } catch (Throwable ignored) {
            }
        }
        SystemUtils.setLanguage(activity, languageAndCountry2[0], languageAndCountry2[1]);
    }

    public static void initTheme(Context context, @StyleRes int dark, @StyleRes int notDark) {
        boolean darkTheme = getSharedPreferences().getBoolean("darkTheme", false);
        if (darkTheme) {
            context.setTheme(dark);
        } else {
            context.setTheme(notDark);
        }
    }
}
