package ua.com.amadeuusoft.imageloaders.ui.widgets;

import android.content.Context;

import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by Artem Manayenko on 13.04.2014.
 */
public class VolleySquareImageView extends NetworkImageView {

    public VolleySquareImageView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }

}
