package eclair.silk.file.openers;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import eclair.silk.R;
import eclair.silk.beans.fileItem.AbstractFileItem;
import eclair.silk.file.operations.FileOperationsDialogs;
import eclair.silk.utils.FileUtils;
import eclair.silk.utils.Utils;

public class APKFileOpener implements FileOpener {
    @Override
    public void open(Context context, AbstractFileItem file) {
        try {
            String path = file.getAbsolutePath();
            Drawable icon = context.getResources().getDrawable(R.drawable.file_type_apk);
            String name = "";
            String version = "0.0.0";
            int versionCode = 0;
            String packageName = "";
            String size = FileUtils.getFormatSize(file.length());
            PackageInfo packageInfo = Utils.getPackageInfo(context, path);
            if (packageInfo != null) {
                try {
                    PackageManager pm = context.getPackageManager();
                    version = packageInfo.versionName;
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    applicationInfo.sourceDir = path;
                    applicationInfo.publicSourceDir = path;
                    Drawable iconFromApk = pm.getApplicationIcon(applicationInfo);
                    if (iconFromApk != null) {
                        icon = iconFromApk;
                    }
                    versionCode = packageInfo.versionCode;
                    packageName = packageInfo.packageName;
                    name = pm.getApplicationLabel(applicationInfo).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, context.getText(R.string.message_failed_to_get_apk_information), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, context.getText(R.string.message_failed_to_get_apk_information), Toast.LENGTH_SHORT).show();
            }
            FileOperationsDialogs.showApkInformationDialog(context, file, icon, name, version, packageName, versionCode, size);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, context.getText(R.string.message_failed_to_open_file), Toast.LENGTH_SHORT).show();
        }
    }
}
