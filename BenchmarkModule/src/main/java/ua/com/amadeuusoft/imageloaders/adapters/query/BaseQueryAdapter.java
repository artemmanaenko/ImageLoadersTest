package ua.com.amadeuusoft.imageloaders.adapters.query;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidquery.AQuery;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.ui.widgets.SquareImageView;

/**
 * Created by Artem Manayenko 13.04.2014.
 */
public abstract class BaseQueryAdapter extends BaseBenchmarkAdapter {


    public BaseQueryAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = createImageView();
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else
            imageView = (ImageView) convertView;
        imageView.setImageDrawable(null);
        String uri = getItem(position);
        AQuery aq = new AQuery(convertView);
        loadImage(aq, imageView, uri);
        return imageView;
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
    }

    protected ImageView createImageView(){
        return new SquareImageView(context);
    }

    protected abstract void loadImage(AQuery aq, ImageView imageView, String url);

}