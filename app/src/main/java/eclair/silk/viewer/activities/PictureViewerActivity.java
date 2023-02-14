package eclair.silk.viewer.activities;

import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;

import eclair.silk.beans.fileItem.AbstractFileItem;
import eclair.silk.utils.ImageUtils;
import eclair.silk.viewer.activities.base.BaseViewerActivity;
import eclair.silk.viewer.widgets.ProfessionalImageView;

public class PictureViewerActivity extends BaseViewerActivity {
    private ImageView image;

    @Override
    protected void init() {
        initViews();
        super.init();
    }

    private void initViews() {
        LinearLayout mainLayout = new LinearLayout(context);
        image = new ProfessionalImageView(context);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        image.setLayoutParams(llp);
        mainLayout.setLayoutParams(llp);
        mainLayout.addView(image);
        setContentView(mainLayout);
    }

    @Override
    protected void loadData(AbstractFileItem file) throws IOException, OutOfMemoryError {
        image.setImageDrawable(ImageUtils.bytes2Drawable(file.getFileBytes()));
        //if(image.getDrawable()==null) Toast.makeText(context, R.string.message_failed_to_load_picture, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void backNoFinish() {
        finish();
    }
}
