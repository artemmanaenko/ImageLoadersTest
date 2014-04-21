package ua.com.amadeuusoft.imageloaders.adapters.uil;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem on 19.04.2014.
 */
public abstract class BaseUILAdapter extends BaseBenchmarkAdapter {

    private DisplayImageOptions options;

    public BaseUILAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(context);
        ImageLoader.getInstance().init(config);
        options = getDisplayImageOptions();
    }

    @Override
    protected void loadImage(final ImageView imageView, final String url) {
        imageView.post(new Runnable() {
            @Override
            public void run() {
                ImageLoader.getInstance().displayImage(url, imageView, options);
            }
        });
    }

    protected abstract DisplayImageOptions getDisplayImageOptions();
}
