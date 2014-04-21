package ua.com.amadeuusoft.imageloaders.adapters.picasso;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class PicassoSquareAdapter extends BaseBenchmarkAdapter {

    public PicassoSquareAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
        Picasso.with(context).load(url).into(imageView);
    }
}
