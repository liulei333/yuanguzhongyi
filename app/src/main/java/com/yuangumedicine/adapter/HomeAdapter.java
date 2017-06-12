package com.yuangumedicine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class HomeAdapter extends FragmentPagerAdapter {
 
    private List<Fragment> fragments;
    public HomeAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        // TODO Auto-generated constructor stub
        this.fragments=fragments;
    } 
 
    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return fragments.get(arg0);
    }
 
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fragments.size();
    }
     @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    	// TODO Auto-generated method stub
//    	super.destroyItem(container, position, object);
    }
}
