package vn.simthanglong.appgiaosim.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.Stack;

import vn.simthanglong.appgiaosim.Constants;
import vn.simthanglong.appgiaosim.activity.BaseActivity;
import vn.simthanglong.appgiaosim.utils.TransitionScreen;

/**
 * Created by cantran on 4/12/17.
 */
public abstract class BaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void resumeData();

    private View view;
    //    public SwipeRefreshLayout swipeRefreshLayout;
    private final Stack<StackEntry> fragmentsStack = new Stack<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }

        try {
            view = inflater.inflate(getLayout(), container, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        initView();
        initData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        resumeData();
    }

    public View findViewById(int id) {
        return view.findViewById(id);
    }

//    public void createSwipeToRefresh() {
//        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swpRefresh);
//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.setColorSchemeResources(R.color.hozo_bg, R.color.hozo_red, R.color.blue_2);
//    }
//
//    @Override
//    public void onRefresh() {
//        if (swipeRefreshLayout.isRefreshing()) return;
//        swipeRefreshLayout.setRefreshing(true);
//    }
//
//    public void onStopRefresh() {
//        swipeRefreshLayout.setRefreshing(false);
//    }

    protected void startActivity(Class<?> cls, Bundle bundle, TransitionScreen transitionScreen) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        startActivity(intent, transitionScreen);
    }

    public void startActivity(Intent intent, TransitionScreen transitionScreen) {
        intent.putExtra(Constants.TRANSITION_EXTRA, transitionScreen);
        startActivity(intent);
        TransitionScreen.overridePendingTransition(getActivity(), transitionScreen);
    }

    public void startActivity(Class<?> cls, TransitionScreen transitionScreen) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent, transitionScreen);
    }


    public void startActivityForResult(Intent intent, int requestCode, TransitionScreen transitionScreen) {
        intent.putExtra(Constants.TRANSITION_EXTRA, transitionScreen);
        startActivityForResult(intent, requestCode);
        TransitionScreen.overridePendingTransition(getActivity(), transitionScreen);
    }

    public void startActivityAndClearAllTask(Intent intent, TransitionScreen transitionScreen) {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent, transitionScreen);
    }

    public void openFragment(int resId, Class<? extends Fragment> fragmentClazz, boolean addBackStack, Bundle args, TransitionScreen transitionScreen) {
        Activity activity = getActivity();
        if (activity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) activity;
            baseActivity.openFragmentBundle(resId, fragmentClazz, args, addBackStack, transitionScreen);
        }
    }

    public void openFragment(int resId, Class<? extends Fragment> fragmentClazz, boolean addBackStack, TransitionScreen transitionScreen) {
        openFragment(resId, fragmentClazz, addBackStack, null, transitionScreen);
    }

    public void showChildFragment(int resLayout, Class<?> newFragClass,
                                  boolean putStack, Bundle bundle, TransitionScreen transitionScreen) {

        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        TransitionScreen.setCustomAnimationsFragment(transaction, transitionScreen);

        try {
            Fragment newFragment;
            String newTag = null;
            if (newFragClass != null)
                newTag = newFragClass.getName();

            Fragment lastFragment = getLastFragment();
            if (lastFragment != null) {
                transaction.hide(lastFragment);
            }

//            LogUtils.d(TAG, "showFragment , resLayout : " + resLayout + " , newFragClass.getName() : " + newFragClass.getName());

            // find the fragment in fragment manager
            newFragment = manager.findFragmentByTag(newTag);
            if (newFragment != null && !newFragment.isRemoving()) {
                transaction.show(newFragment).commit();
            } else {
                try {
                    Fragment nFrag = (Fragment) newFragClass.newInstance();
                    nFrag.setArguments(bundle);

                    if (putStack) {
                        transaction.add(resLayout, nFrag, newTag)
                                .addToBackStack(newTag).commit();
                    } else {
                        transaction.add(resLayout, nFrag, newTag).commit();
                    }

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            fragmentsStack.push(new StackEntry(newTag));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Fragment getLastFragment() {
        if (fragmentsStack.isEmpty())
            return null;
        String fragTag = fragmentsStack.peek().getFragTag();
        return getChildFragmentManager().findFragmentByTag(
                fragTag);
    }

    private static class StackEntry implements Serializable {
        private String fragTag = null;

        public StackEntry(String fragTag) {
            super();
            this.fragTag = fragTag;
        }

        public String getFragTag() {
            return fragTag;
        }
    }

}
