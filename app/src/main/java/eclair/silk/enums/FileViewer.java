package eclair.silk.enums;

import eclair.silk.R;
import eclair.silk.file.openers.APKFileOpener;
import eclair.silk.file.openers.AudioFileOpener;
import eclair.silk.file.openers.FileOpener;
import eclair.silk.file.openers.MoreOpenersAllTypes;
import eclair.silk.file.openers.MoreOpenersDefaultType;
import eclair.silk.file.openers.PictureFileOpener;
import eclair.silk.file.openers.TextFileOpener;
import eclair.silk.utils.ResourceUtils;

public enum FileViewer {
    TEXT_EDITOR(ResourceUtils.getTextByLocale(R.string.file_viewer_text_editor), new TextFileOpener()),
    PICTURE_VIEWER(ResourceUtils.getTextByLocale(R.string.file_viewer_picture_viewer), new PictureFileOpener()),
    AUDIO_PLAYER(ResourceUtils.getTextByLocale(R.string.file_viewer_audio_player), new AudioFileOpener()),
    APK(ResourceUtils.getTextByLocale(R.string.file_viewer_apk), new APKFileOpener()),
    MORE(ResourceUtils.getTextByLocale(R.string.file_viewer_more), new MoreOpenersDefaultType()),
    MORE_ALL_TYPES(ResourceUtils.getTextByLocale(R.string.file_viewer_more_all_types), new MoreOpenersAllTypes());

    private final CharSequence displayName;
    private final FileOpener opener;

    FileViewer(CharSequence displayName, FileOpener opener) {
        this.displayName = displayName;
        this.opener = opener;
    }

    public CharSequence getDisplayName() {
        return displayName;
    }

    public FileOpener getOpener() {
        return opener;
    }
}
