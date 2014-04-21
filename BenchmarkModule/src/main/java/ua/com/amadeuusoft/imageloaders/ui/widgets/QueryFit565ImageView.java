package ua.com.amadeuusoft.imageloaders.ui.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.androidquery.util.RatioDrawable;

import ua.com.amadeuusoft.imageloaders.BitmapUtils;

/**
 * Created by Artem Manayenko on 13.04.2014.
 */
public class QueryFit565ImageView extends SquareImageView {

    public QueryFit565ImageView(Context context) {
        super(context);
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        if(drawable != null){
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            Bitmap result = BitmapUtils.convertTo565(bitmap, false);
            drawable = new RatioDrawable(getResources(), result, this, 1, 0);
        }
        super.setImageDrawable(drawable);
    }
}
