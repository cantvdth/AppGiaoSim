package vn.simthanglong.appgiaosim.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.simthanglong.appgiaosim.R;
import vn.simthanglong.appgiaosim.adapter.PageAdapter;
import vn.simthanglong.appgiaosim.view.TextViewCustom;

/**
 * Created by CanTran on 8/10/18.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private TextViewCustom tvTab1, tvTab2, tvTab3, tvTab4, tvCountTab1, tvCountTab2, tvCountTab3, tvCountTab4;
    private ViewPager viewPager;
    private int position = 0;
    private PagerAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initViewPager();

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void resumeData() {

    }

    private void initViewPager() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_wait)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_assigned)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_done)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_cancel)));
        final ViewGroup test = (ViewGroup) (tabLayout.getChildAt(0));//tabs is your Tablayout
        int tabLen = test.getChildCount();
        for (int i = 0; i < tabLen; i++) {
            View v = test.getChildAt(i);
            v.setPadding(0, 0, 0, 0);
        }
        @SuppressLint("InflateParams") View headerView = getSystemService(Context.LAYOUT_INFLATER_SERVICE) != null ? ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.layout_custom_tabs, null, false) : null;
        tabLayout.getTabAt(0).setCustomView(headerView.findViewById(R.id.ll1));
        tabLayout.getTabAt(1).setCustomView(headerView.findViewById(R.id.ll2));
        tabLayout.getTabAt(2).setCustomView(headerView.findViewById(R.id.ll3));
        tabLayout.getTabAt(3).setCustomView(headerView.findViewById(R.id.ll4));
        tvTab1 = (TextViewCustom) findViewById(R.id.tv_tab1);
        tvTab2 = (TextViewCustom) findViewById(R.id.tv_tab2);
        tvTab3 = (TextViewCustom) findViewById(R.id.tv_tab3);
        tvTab4 = (TextViewCustom) findViewById(R.id.tv_tab4);

        tvCountTab1 = (TextViewCustom) findViewById(R.id.tv_count_tab1);
        tvCountTab2 = (TextViewCustom) findViewById(R.id.tv_count_tab2);
        tvCountTab3 = (TextViewCustom) findViewById(R.id.tv_count_tab3);
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (viewPager != null)
                    viewPager.setCurrentItem(position);
                if (tab.getPosition() == 0) {
                    tvTab1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                    tvTab2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                    tvTab3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                    tvTab4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                } else if (tab.getPosition() == 1) {
                    tvTab1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                    tvTab2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                    tvTab3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                    tvTab4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));


                } else if (tab.getPosition() == 2) {
                    tvTab1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                    tvTab2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                    tvTab3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                    tvTab4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));


                } else if (tab.getPosition() == 3) {
                    tvTab1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                    tvTab2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                    tvTab3.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.setting_text));
                    tvTab4.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}
