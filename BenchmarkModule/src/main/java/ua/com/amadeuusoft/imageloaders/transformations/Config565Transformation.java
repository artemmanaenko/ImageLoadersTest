package ua.com.amadeuusoft.imageloaders.transformations;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

import ua.com.amadeuusoft.imageloaders.BitmapUtils;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class Config565Transformation implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {
        return BitmapUtils.convertTo565(source, true);
    }

    @Override
    public String key() {
        return "Config565Transformation";
    }
}
