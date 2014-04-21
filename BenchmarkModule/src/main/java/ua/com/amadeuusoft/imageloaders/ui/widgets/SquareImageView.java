package ua.com.amadeuusoft.imageloaders.ui.widgets;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class SquareImageView extends ImageView {

    public SquareImageView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}
