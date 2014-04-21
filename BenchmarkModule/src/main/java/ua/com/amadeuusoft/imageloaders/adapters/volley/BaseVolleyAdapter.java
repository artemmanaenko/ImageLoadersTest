package ua.com.amadeuusoft.imageloaders.adapters.volley;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.nostra13.universalimageloader.utils.L;

import java.io.File;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.ui.widgets.VolleySquareImageView;

/**
 * Created by Artem Manayenko 13.04.2014.
 */
public class BaseVolleyAdapter extends BaseBenchmarkAdapter {

    private static final String DEFAULT_CACHE_DIR = "photos";
    private static final int DEFAULT_DISK_USAGE_BYTES = 25 * 1024 * 1024;

    protected ImageLoader imageLoader;

    public BaseVolleyAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
        imageLoader = new ImageLoader(newRequestQueue(context), new BitmapLruCache(getDefaultLruCacheSize()));
    }

    private RequestQueue newRequestQueue(Context context) {
        File rootCache = context.getExternalCacheDir();
        if (rootCache == null) {
            L.w("Can't find External Cache Dir, "
                    + "switching to application specific cache directory");
            rootCache = context.getCacheDir();
        }

        File cacheDir = new File(rootCache, DEFAULT_CACHE_DIR);
        cacheDir.mkdirs();
        HttpStack stack = new HurlStack();
        Network network = new BasicNetwork(stack);
        DiskBasedCache diskBasedCache = new DiskBasedCache(cacheDir, DEFAULT_DISK_USAGE_BYTES);
        RequestQueue queue = new RequestQueue(diskBasedCache, network);
        queue.start();
        return queue;
    }

    public int getDefaultLruCacheSize() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;
        return cacheSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = createImageView();
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else
            imageView = (VolleySquareImageView) convertView;
        imageView.setImageDrawable(null);
        String uri = getItem(position);
        loadImage(imageView, uri);
        return imageView;
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
        VolleySquareImageView volleyImageView = (VolleySquareImageView) imageView;
        volleyImageView.setImageUrl(url, imageLoader);
    }

    protected ImageView createImageView(){
        return new VolleySquareImageView(context);
    }

}