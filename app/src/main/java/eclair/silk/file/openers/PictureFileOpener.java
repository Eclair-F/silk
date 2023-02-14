package eclair.silk.file.openers;

import android.content.Context;

import eclair.silk.beans.fileItem.AbstractFileItem;
import eclair.silk.utils.Utils;
import eclair.silk.viewer.activities.PictureViewerActivity;

public class PictureFileOpener implements FileOpener {
    @Override
    public void open(Context context, AbstractFileItem file) {
        Utils.startActivityWithAFI(context, PictureViewerActivity.class, file);
    }
}
