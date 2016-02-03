package com.example.testviewpager;

import java.io.File;
import java.util.ArrayList;

import com.bumptech.glide.Glide;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.LinearLayout.LayoutParams;

public class ViewPagerAdapter extends PagerAdapter{
  
  private Context context;
  private ArrayList<String> fileNames = new ArrayList<String>(); //本地图片路径

  public ViewPagerAdapter(Context context, ArrayList<String> fileNames) {
    super();
    this.context = context;
    this.fileNames = fileNames;
  }

  @Override
  public int getCount() {
    return fileNames.size();
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }
  
  @Override
  public View instantiateItem(ViewGroup container, int position) {
    ImageView imageView = new ImageView(context);
    Glide.with(context).load(fileNames.get(position)).centerCrop().into(imageView);
    container.addView(imageView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    return imageView;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
  }
  
  //解决数据不刷新的问题
  @Override  
  public int getItemPosition(Object object) {  
      return POSITION_NONE;  
  }  
}
