package ua.com.amadeuusoft.imageloaders.adapters.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem on 13.04.2014.
 */
public class GlideSquareAdapter extends BaseBenchmarkAdapter {

    public GlideSquareAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
        Glide.load(url)
                .centerCrop()
                .into(imageView);
    }
}
