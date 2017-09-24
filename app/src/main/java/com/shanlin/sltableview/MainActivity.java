package com.shanlin.sltableview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.shanlin.sltableview.fragment.DefaultFragment;
import com.shanlin.sltableview.fragment.DouyuFollowFragment;
import com.shanlin.sltableview.fragment.DouyuFragment;
import com.shanlin.sltableview.fragment.GroupHeaderFragment;
import com.shanlin.sltableview.fragment.GroupStickyHeaderFragment;
import com.shanlin.sltableview.fragment.StickyHeaderClickFragment;
import com.shanlin.sltableview.fragment.StickyHeaderFragment;
import com.shanlin.sltableview.fragment.UserInfoFragment;

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
                    return new DouyuFollowFragment();
                case 2:
                    return new UserInfoFragment();
                case 3:
                    return new DefaultFragment();
                case 4:
                    return new StickyHeaderFragment();
                case 5:
                    return new StickyHeaderClickFragment();
                case 6:
                    return new GroupHeaderFragment();
                case 7:
                    return new GroupStickyHeaderFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "DouyuDemo";
                case 1:
                    return "DouyuFollow";
                case 2:
                    return "UserInfo";
                case 3:
                    return "DefaultHeader";
                case 4:
                    return "StickyHeader";
                case 5:
                    return "StickyHeaderClick";
                case 6:
                    return "GroupHeader";
                case 7:
                    return "GroupStickyHeader";

                default:
                    return null;
            }
        }
    }
}
