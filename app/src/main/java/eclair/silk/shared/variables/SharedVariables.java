package eclair.silk.shared.variables;

import android.Manifest;
import android.net.Uri;

import eclair.silk.enums.FileViewer;

public class SharedVariables {
    public static String[] getPermissions() {
        return new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE,
                Manifest.permission.REQUEST_INSTALL_PACKAGES};
    }

    public static FileViewer[] getFileViewers() {
        return new FileViewer[]{FileViewer.TEXT_EDITOR,
                FileViewer.PICTURE_VIEWER,
                FileViewer.AUDIO_PLAYER,
                FileViewer.APK,
                //FileViewer.HEX_EDITOR,
                FileViewer.MORE,
                FileViewer.MORE_ALL_TYPES};
    }




    public static String getFileProviderPackageName() {
        return "eclair.silk";
    }
}
