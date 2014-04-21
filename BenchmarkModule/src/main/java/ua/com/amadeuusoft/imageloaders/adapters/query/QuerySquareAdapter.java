package ua.com.amadeuusoft.imageloaders.adapters.query;

import android.content.Context;
import android.widget.ImageView;

import com.androidquery.AQuery;
import com.androidquery.callback.ImageOptions;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem on 15.04.2014.
 */
public class QuerySquareAdapter extends BaseQueryAdapter {

    public QuerySquareAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected void loadImage(AQuery aq, ImageView imageView, String url) {
        ImageOptions options = new ImageOptions();
        aq.id(imageView).image(url, options);
    }

}
