package com.shanlin.sltableview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.shanlin.sltableview.fragment.DefaultFragment;
import com.shanlin.sltableview.fragment.DouyuFragment;
import com.shanlin.sltableview.fragment.GroupHeaderFragment;
import com.shanlin.sltableview.fragment.GroupStickyHeaderFragment;
import com.shanlin.sltableview.fragment.StickyHeaderFragment;

public class MainActivity extends AppCompatActivity {

    private Activity context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        HeaderPagerAdapter adapter = new HeaderPagerAdapter(this.getSupportFragmentManager());

        ViewPager pager = (ViewPager) this.findViewById(R.id.pager);
        pager.setAdapter(adapter);
    }

    class HeaderPagerAdapter extends FragmentPagerAdapter {

        public HeaderPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new DouyuFragment();
                case 1:
                    return new DefaultFragment();
                case 2:
                    return new StickyHeaderFragment();
                case 3:
                    return new GroupHeaderFragment();
                case 4:
                    return new GroupStickyHeaderFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "DouyuDemo";
                case 1:
                    return "DefaultHeader";

                case 2:
                    return "StickyHeader";
                case 3:
                    return "GroupHeader";
                case 4:
                    return "GroupStickyHeader";

                default:
                    return null;
            }
        }
    }
}
