package eclair.silk.file.openers;

import android.content.Context;

import eclair.silk.beans.fileItem.AbstractFileItem;
import eclair.silk.file.operations.FileOperations;

public class VideoFileOpener implements FileOpener {
    @Override
    public void open(Context context, AbstractFileItem file) {
        FileOperations.openFileByOtherApplication(context, file);
    }
}
