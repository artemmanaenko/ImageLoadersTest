package ua.com.amadeuusoft.imageloaders.ui.widgets;

import android.content.Context;
import android.graphics.Bitmap;

import ua.com.amadeuusoft.imageloaders.BitmapUtils;

/**
 * Created by Artem Manayenko on 13.04.2014.
 */
public class VolleyRoundImageView extends VolleySquareImageView {

    public VolleyRoundImageView(Context context) {
        super(context);
    }

    @Override
    public void setImageBitmap(Bitmap bitmap) {
        if(bitmap != null  && !bitmap.isRecycled()){
            super.setImageBitmap(BitmapUtils.convertToCircle(bitmap, false));
        }
    }
}
