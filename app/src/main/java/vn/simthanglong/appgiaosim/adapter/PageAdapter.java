package vn.simthanglong.appgiaosim.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import vn.simthanglong.appgiaosim.fragment.AssignedFragment;
import vn.simthanglong.appgiaosim.fragment.CancelFragment;
import vn.simthanglong.appgiaosim.fragment.DoneFragment;
import vn.simthanglong.appgiaosim.fragment.WaitFragment;

/**
 * Created by LongBui on 8/22/17.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    private final int mNumOfTabs;
    private WaitFragment tab0;
    private AssignedFragment tab1;
    private DoneFragment tab2;
    private CancelFragment tab3;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (tab0 == null)
                    tab0 = new WaitFragment();
                return tab0;
            case 1:
                if (tab1 == null)
                    tab1 = new AssignedFragment();
                return tab1;
            case 2:
                tab2 = new DoneFragment();
                return tab2;
            case 3:
                if (tab3 == null)
                    tab3 = new CancelFragment();
                return tab3;
            default:
                return new WaitFragment();
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

//    public void onRefreshTab(int pos) {
//        if (pos == 0 && tab1 != null) {
//            tab1.onRefresh();
//        } else if (pos == 1 && tab2 != null) {
//            tab2.onRefresh();
//        } else if (pos == 2 && tab3 != null) tab3.onRefresh();
//
//    }
//
//
//    public void resetState(int pos) {
//        if (pos == 0) {
//            tab1.endlessRecyclerViewScrollListener.resetState();
//        } else if (pos == 2) {
//            tab3.endlessRecyclerViewScrollListener.resetState();
//        }
//
//    }

}
