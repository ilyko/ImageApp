package slava.imageapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity{

    private static final int NUM_PAGES = 2;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mPagerAdapter = new ScreenSlidePageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        Fragment mainFragment = getSupportFragmentManager()
                .findFragmentByTag(RecyclerViewFragment.class.getCanonicalName());
        if (mainFragment == null) {
            addFragment(this, new RecyclerViewFragment(), R.id.viewPager, false);
        }
    }

    @Override
    public void onBackPressed() {
        if(mViewPager.getCurrentItem()==0){
            super.onBackPressed();
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
        }
    }

    private class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePageAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return new PageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

    }

    public void addFragment(FragmentActivity activity, Fragment fragment, int container, boolean backStack){

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(container,fragment,fragment.getClass().getCanonicalName());
        if(backStack){
            transaction.addToBackStack(fragment.getClass().getCanonicalName());
        }
        transaction.commitAllowingStateLoss();
    }
}
