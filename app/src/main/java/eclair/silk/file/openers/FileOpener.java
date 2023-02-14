package eclair.silk.file.openers;

import android.content.Context;

import eclair.silk.beans.fileItem.AbstractFileItem;

public interface FileOpener {
    void open(Context context, AbstractFileItem file);
}
