package eclair.silk.enums;

import static eclair.silk.utils.ResourceUtils.getDrawable;
import static eclair.silk.utils.ResourceUtils.getTextByLocale;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import eclair.silk.R;
import eclair.silk.file.openers.APKFileOpener;
import eclair.silk.file.openers.AudioFileOpener;
import eclair.silk.file.openers.FileOpener;
import eclair.silk.file.openers.PictureFileOpener;
import eclair.silk.file.openers.TextFileOpener;
import eclair.silk.file.openers.VideoFileOpener;
import eclair.silk.utils.ImageUtils;

public enum FileType {
    FOLDER(getDrawable(R.drawable.gray_file_type_folder), getTextByLocale(R.string.file_type_folder)),
    UNKNOWN(getDrawable(R.drawable.file_type_unknown), getTextByLocale(R.string.file_type_unknown)),
    TEXT(getDrawable(R.drawable.file_type_text), getTextByLocale(R.string.file_type_text), new TextFileOpener()),
    PICTURE(getDrawable(R.drawable.file_type_picture), getTextByLocale(R.string.file_type_picture), new PictureFileOpener()),
    VIDEO(getDrawable(R.drawable.file_type_video), getTextByLocale(R.string.file_type_video), new VideoFileOpener()),
    AUDIO(getDrawable(R.drawable.file_type_audio), getTextByLocale(R.string.file_type_audio), new AudioFileOpener()),
    APK(getDrawable(R.drawable.file_type_apk), getTextByLocale(R.string.file_type_apk), new APKFileOpener());

    private final Drawable icon;
    private final CharSequence displayName;
    private final FileOpener opener;

    FileType(Drawable icon, CharSequence displayName) {
        this(icon, displayName, null);
    }

    FileType(Drawable icon, CharSequence displayName, FileOpener opener) {
        this.icon = icon;
        this.displayName = displayName;
        this.opener = opener;
    }

    public Drawable getIcon() {
        return icon;
    }

    public Bitmap getIconBitmap() {
        return ImageUtils.drawable2Bitmap(icon);
    }

    public CharSequence getDisplayName() {
        return displayName;
    }

    public FileOpener getOpener() {
        return opener;
    }
}
