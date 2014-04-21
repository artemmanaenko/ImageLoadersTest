package ua.com.amadeuusoft.imageloaders.adapters.query;

import android.content.Context;
import android.widget.ImageView;

import com.androidquery.AQuery;
import com.androidquery.callback.ImageOptions;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.ui.widgets.SquareImageView;

/**
 * Created by Artem on 15.04.2014.
 */
public class QueryRoundImageAdapter extends BaseQueryAdapter {

    public QueryRoundImageAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected void loadImage(AQuery aq, ImageView imageView, String url) {
        ImageOptions options = new ImageOptions();
        options.ratio = 1;
        options.round = Integer.MAX_VALUE;
        aq.id(imageView).image(url, options);
    }

    @Override
    protected ImageView createImageView(){
        return new SquareImageView(context);
    }

}
