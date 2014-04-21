package ua.com.amadeuusoft.imageloaders.transformations;

import android.graphics.Bitmap;

import com.bumptech.glide.resize.bitmap_recycle.BitmapPool;
import com.bumptech.glide.resize.load.Transformation;

import ua.com.amadeuusoft.imageloaders.BitmapUtils;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class GlideConfig565Transformation extends Transformation {

    @Override
    public Bitmap transform(Bitmap bitmap, BitmapPool pool, int outWidth, int outHeight) {
        return BitmapUtils.convertTo565(bitmap, true);
    }
}
