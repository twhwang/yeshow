package com.example.project_005;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class themeGallery extends BaseAdapter {

    Context context;
    public themeGallery(Context c) {
        context = c;
    }

    Integer [] imgArr = {
            R.drawable.theme_01, R.drawable.theme_02, R.drawable.theme_03, R.drawable.theme_04,
            R.drawable.theme_05, R.drawable.theme_06
    };
    String [] imgCaption = {
            "한식", "이탈리안", "중식", "일식", "타이", "프랑스"
    };

    @Override
    public int getCount() {
        return imgArr.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView themeV = new ImageView(context);
        themeV.setLayoutParams(new Gallery.LayoutParams(1000, 800));
        themeV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        themeV.setImageResource(imgArr[i]);

        return themeV;
    }
}
