package ua.com.amadeuusoft.imageloaders.adapters.volley;

import android.content.Context;
import android.widget.ImageView;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.ui.widgets.VolleyRoundImageView;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class VolleyRoundImageAdapter extends BaseVolleyAdapter {

    public VolleyRoundImageAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected ImageView createImageView(){
        return new VolleyRoundImageView(context);
    }

}
