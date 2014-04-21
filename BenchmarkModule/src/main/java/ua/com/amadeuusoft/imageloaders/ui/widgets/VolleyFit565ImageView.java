package ua.com.amadeuusoft.imageloaders.ui.widgets;

import android.content.Context;
import android.graphics.Bitmap;

import ua.com.amadeuusoft.imageloaders.BitmapUtils;

/**
 * Created by Artem Manayenko on 13.04.2014.
 */
public class VolleyFit565ImageView extends VolleySquareImageView {

    public VolleyFit565ImageView(Context context) {
        super(context);
    }

    @Override
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            Bitmap result = BitmapUtils.getFittedBitmap(bitmap, this, false);
            result = BitmapUtils.convertTo565(result, false);
            super.setImageBitmap(result);
        }
    }
}
