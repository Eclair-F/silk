package eclair.silk.utils;

import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import java.util.Locale;

import eclair.silk.BuildConfig;
import eclair.silk.SILKApplication;

public class ResourceUtils {
    public static Drawable getDrawable(@DrawableRes int id) {
        return SILKApplication.getContext().getResources().getDrawable(id);
    }

    public static String getString(@StringRes int id) {
        return SILKApplication.getContext().getResources().getString(id);
    }

    public static CharSequence getText(@StringRes int id) {
        return SILKApplication.getContext().getResources().getText(id);
    }

    public static CharSequence getTextByLocale(@StringRes int idRes) {
        String language = SILKApplication.getSharedPreferences().getString("language", "auto");
        String[] languageAndCountry2 = new String[]{"en", "US"};
        if (language.equals("auto")) {
            languageAndCountry2 = new String[]{Locale.getDefault().getLanguage(), Locale.getDefault().getCountry().toUpperCase()};
        } else {
            try {
                languageAndCountry2 = language.split("_");
            } catch (Throwable ignored) {
            }
        }
        return getTextByLocale(idRes, languageAndCountry2[0], languageAndCountry2[1]);
    }

    public static CharSequence getTextByLocale(@StringRes int stringId, String language, String country) {
        Resources resources = getApplicationResource(SILKApplication.getContext().getApplicationContext().getPackageManager(),
                BuildConfig.APPLICATION_ID, new Locale(language, country));
        if (resources == null) {
            return "";
        } else {
            try {
                return resources.getText(stringId);
            } catch (Exception e) {
                return "";
            }
        }
    }

    private static Resources getApplicationResource(PackageManager pm, String pkgName, Locale l) {
        Resources resourceForApplication = null;
        try {
            resourceForApplication = pm.getResourcesForApplication(pkgName);
            Configuration config = resourceForApplication.getConfiguration();
            config.locale = l;
            resourceForApplication.updateConfiguration(config, null);
        } catch (PackageManager.NameNotFoundException ignored) {

        }
        return resourceForApplication;
    }
}
