package com.luteh.utilshelper.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.balysv.materialripple.MaterialRippleLayout;
import com.luteh.utilshelper.R;
import com.luteh.utilshelper.utils.Tools;

import java.util.List;

/**
 * Created by Luthfan Maftuh on 5/9/2019.
 * Email luthfanmaftuh@gmail.com
 */
public class ImageSliderAdapter extends PagerAdapter {

    private Activity act;
    private List<String> items;

    private OnItemClickListener onItemClickListener;

    private interface OnItemClickListener {
        void onItemClick(View view, String imgUrl);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    // constructor
    public ImageSliderAdapter(Activity activity, List<String> items) {
        this.act = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    public String getItem(int pos) {
        return items.get(pos);
    }

    public void setItems(List<String> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final String imgUrl = items.get(position);
        LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slider_image_item, container, false);

        ImageView image = (ImageView) v.findViewById(R.id.iv_slider_image_item);
        ProgressBar progressBar = v.findViewById(R.id.pb_slider_image_item);
        MaterialRippleLayout lyt_parent = (MaterialRippleLayout) v.findViewById(R.id.layout_slider_image_item);
        Tools.displayImageOriginal(act, image, imgUrl, progressBar);
        lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, imgUrl);
                }
            }
        });

        ((ViewPager) container).addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

}
