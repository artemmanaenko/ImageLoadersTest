package ua.com.amadeuusoft.imageloaders.adapters;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class UILSquareFitAdapter extends BaseBenchmarkAdapter {

    private DisplayImageOptions options;

    public UILSquareFitAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(context);
        ImageLoader.getInstance().init(config);
        options = new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.EXACTLY)
                .resetViewBeforeLoading(true)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .build();
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
        ImageLoader.getInstance().displayImage(url, imageView, options);
    }
}
