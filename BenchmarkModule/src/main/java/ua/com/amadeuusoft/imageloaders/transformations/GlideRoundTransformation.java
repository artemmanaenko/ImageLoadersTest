package ua.com.amadeuusoft.imageloaders.transformations;

import android.graphics.Bitmap;

import com.bumptech.glide.resize.bitmap_recycle.BitmapPool;
import com.bumptech.glide.resize.load.Transformation;

import ua.com.amadeuusoft.imageloaders.BitmapUtils;

/**
 * Created by Artem on 13.04.2014.
 */
public class GlideRoundTransformation extends Transformation {

    @Override
    public Bitmap transform(Bitmap bitmap, BitmapPool pool, int outWidth, int outHeight) {
        return BitmapUtils.convertToCircle(bitmap, false);
    }

}
