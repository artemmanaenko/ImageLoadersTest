package ua.com.amadeuusoft.imageloaders.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.List;

import ua.com.amadeuusoft.imageloaders.ui.widgets.SquareImageView;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem Manayenko 30.03.2014.
 */
public abstract class BaseBenchmarkAdapter extends BaseAdapter implements ListAdapter{

    protected Context context;
    private List<String> uriList;

    public BaseBenchmarkAdapter(Context context, IUrlListContainer urlListContainer) {
        this.context = context;
        this.uriList = urlListContainer.getUrlList();
    }

    @Override
    public int getCount() {
        return uriList.size();
    }

    @Override
    public String getItem(int position) {
        return uriList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return uriList.hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SquareImageView imageView;
        if (convertView == null) {
            imageView = new SquareImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else
            imageView = (SquareImageView) convertView;

        String uri = getItem(position);
        loadImage(imageView, uri);
        return imageView;
    }

    protected abstract void loadImage(ImageView imageView, String url);

}
