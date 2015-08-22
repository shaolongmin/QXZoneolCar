package com.zoneol.qxcar;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.zoneol.qxcar.fragment.BaseFragment;
import com.zoneol.qxcar.fragment.IndexFragment;
import com.zoneol.qxcar.fragment.first.FirstFragment;
import com.zoneol.qxcar.fragment.five.FiveFragment;
import com.zoneol.qxcar.fragment.four.FourFragment;
import com.zoneol.qxcar.fragment.second.SecondFragment;
import com.zoneol.qxcar.fragment.seven.SevenFragment;
import com.zoneol.qxcar.fragment.six.SixFragment;
import com.zoneol.qxcar.fragment.three.ThreeFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener , BaseFragment.OnFragmentInteractionListener{
    private int fragmentAnimation = FragmentTransaction.TRANSIT_FRAGMENT_OPEN ;
    private int main_tab_selected ;
    private IndexFragment mIndexFragment = null;
    private FirstFragment mFirstFragment = null;
    private SecondFragment mSecondFragment = null ;
    private ThreeFragment mThreeFragment = null ;
    private FourFragment mFourFragment = null ;
    private FiveFragment mFiveFragment = null ;
    private SixFragment mSixFragment = null ;
    private SevenFragment mSevenFragment = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.main_fragment_container) != null ) {
            if (savedInstanceState != null) {
                return ;
            }

            this.initFragment();

            this.initClick();

            main_tab_selected = AppConstant.MAIN_TAB_INDEX ;

            // 将首页片段设定为当前显示的片段
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_container, mIndexFragment)
                    .commit();

        }

    }

    private void initFragment() {
        if (mIndexFragment == null) {
            mIndexFragment = new IndexFragment() ;
        }

        if (mFirstFragment == null) {
            mFirstFragment = new FirstFragment() ;
        }

        if (mSecondFragment == null) {
            mSecondFragment = new SecondFragment() ;
        }

        if (mThreeFragment == null) {
            mThreeFragment = new ThreeFragment() ;
        }

        if (mFourFragment == null) {
            mFourFragment = new FourFragment() ;
        }

        if (mFiveFragment == null) {
            mFiveFragment = new FiveFragment() ;
        }

        if (mSixFragment == null) {
            mSixFragment = new SixFragment() ;
        }

        if (mSevenFragment == null) {
            mSevenFragment = new SevenFragment() ;
        }
    }

    private void initClick() {
        findViewById(R.id.main_first_tab).setOnClickListener(this);
        findViewById(R.id.main_second_tab).setOnClickListener(this);
        findViewById(R.id.main_three_tab).setOnClickListener(this);
        findViewById(R.id.main_four_tab).setOnClickListener(this);
        findViewById(R.id.main_five_tab).setOnClickListener(this);
        findViewById(R.id.main_six_tab).setOnClickListener(this);
        findViewById(R.id.main_seven_tab).setOnClickListener(this);
    }

    private void setTabSelection(int index) {

        this.restoreLastImageTab();

        switch (index){
            case  AppConstant.MAIN_TAB_INDEX:
                break ;
            case AppConstant.MAIN_TAB_FIRST:
                switchToFirst();
                break ;
            case AppConstant.MAIN_TAB_SECOND:
                switchToSecond();
                break ;
            case AppConstant.MAIN_TAB_THREE:
                switchToThree();
                break ;
            case AppConstant.MAIN_TAB_FOUR:
                switchToFour();
                break ;
            case AppConstant.MAIN_TAB_FIVE:
                switchToFive();
                break;
            case AppConstant.MAIN_TAB_SIX:
                switchToSix();
                break ;
            case AppConstant.MAIN_TAB_SEVEN:
                switchToSeven();
                break ;
            default:
                try {
                    throw new Exception("the select tab unkonw error");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    }

    private void restoreLastImageTab() {
        ImageView tempImgView = null;

        // 开启一个Fragment事务用于切换片段
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        switch (main_tab_selected){
            case  AppConstant.MAIN_TAB_INDEX:
                if (mIndexFragment != null) {
                    transaction.hide(mIndexFragment) ;
                }
                break ;
            case AppConstant.MAIN_TAB_FIRST:
                if (mFirstFragment != null) {
                    transaction.hide(mFirstFragment);
                }
                tempImgView = (ImageView)findViewById(R.id.main_first_tab_image) ;
                tempImgView.setImageResource(R.drawable.main_first_tab_img);
                break ;
            case AppConstant.MAIN_TAB_SECOND:
                if (mSecondFragment != null) {
                    transaction.hide(mSecondFragment);
                }
                tempImgView = (ImageView)findViewById(R.id.main_first_tab_image) ;
                tempImgView.setImageResource(R.drawable.main_first_tab_img);
                break ;
            case AppConstant.MAIN_TAB_THREE:
                if (mThreeFragment != null) {
                    transaction.hide(mThreeFragment);
                }
                tempImgView = (ImageView)findViewById(R.id.main_first_tab_image) ;
                tempImgView.setImageResource(R.drawable.main_first_tab_img);
                break ;
            case AppConstant.MAIN_TAB_FOUR:
                if (mFourFragment != null) {
                    transaction.hide(mFourFragment);
                }
                tempImgView = (ImageView)findViewById(R.id.main_first_tab_image) ;
                tempImgView.setImageResource(R.drawable.main_first_tab_img);
                break ;
            case AppConstant.MAIN_TAB_FIVE:
                if (mFiveFragment != null) {
                    transaction.hide(mFiveFragment);
                }
                tempImgView = (ImageView)findViewById(R.id.main_first_tab_image) ;
                tempImgView.setImageResource(R.drawable.main_first_tab_img);
                break;
            case AppConstant.MAIN_TAB_SIX:
                if (mSixFragment != null) {
                    transaction.hide(mSixFragment);
                }
                tempImgView = (ImageView)findViewById(R.id.main_first_tab_image) ;
                tempImgView.setImageResource(R.drawable.main_first_tab_img);
                break ;
            case AppConstant.MAIN_TAB_SEVEN:
                if (mSevenFragment != null) {
                    transaction.hide(mSevenFragment);
                }
                tempImgView = (ImageView)findViewById(R.id.main_first_tab_image) ;
                tempImgView.setImageResource(R.drawable.main_first_tab_img);
                break ;
        }
    }

    private void switchToFirst() {
        main_tab_selected = AppConstant.MAIN_TAB_FIRST ;

        // 修改底部导航图片资源
        ImageView tempImgView = (ImageView) findViewById(R.id.main_first_tab_image);
        tempImgView.setImageResource(R.drawable.main_first_tab_img);

        // 开启一个Fragment事务用于切换片段
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.setTransition(fragmentAnimation);
        transaction.replace(R.id.main_fragment_container, mFirstFragment); // 切换片段

        transaction.commit();
    }

    private void switchToSecond() {
        main_tab_selected = AppConstant.MAIN_TAB_SECOND ;

        // 修改底部导航图片资源
        ImageView tempImgView = (ImageView) findViewById(R.id.main_first_tab_image);
        tempImgView.setImageResource(R.drawable.main_first_tab_img);

        // 开启一个Fragment事务用于切换片段
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.setTransition(fragmentAnimation);
        transaction.replace(R.id.main_fragment_container, mSecondFragment); // 切换片段

        transaction.commit();
    }

    private void switchToThree(){
        main_tab_selected = AppConstant.MAIN_TAB_THREE ;

        // 修改底部导航图片资源
        ImageView tempImgView = (ImageView) findViewById(R.id.main_first_tab_image);
        tempImgView.setImageResource(R.drawable.main_first_tab_img);

        // 开启一个Fragment事务用于切换片段
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.setTransition(fragmentAnimation);
        transaction.replace(R.id.main_fragment_container, mThreeFragment); // 切换片段

        transaction.commit();
    }

    private void switchToFour() {
        main_tab_selected = AppConstant.MAIN_TAB_FOUR ;

        // 修改底部导航图片资源
        ImageView tempImgView = (ImageView) findViewById(R.id.main_first_tab_image);
        tempImgView.setImageResource(R.drawable.main_first_tab_img);

        // 开启一个Fragment事务用于切换片段
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.setTransition(fragmentAnimation);
        transaction.replace(R.id.main_fragment_container, mFourFragment); // 切换片段

        transaction.commit();
    }

    private void switchToFive(){
        main_tab_selected = AppConstant.MAIN_TAB_FIVE ;

        // 修改底部导航图片资源
        ImageView tempImgView = (ImageView) findViewById(R.id.main_first_tab_image);
        tempImgView.setImageResource(R.drawable.main_first_tab_img);

        // 开启一个Fragment事务用于切换片段
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.setTransition(fragmentAnimation);
        transaction.replace(R.id.main_fragment_container, mFiveFragment); // 切换片段

        transaction.commit();
    }

    private void switchToSix(){
        main_tab_selected = AppConstant.MAIN_TAB_SIX ;

        // 修改底部导航图片资源
        ImageView tempImgView = (ImageView) findViewById(R.id.main_first_tab_image);
        tempImgView.setImageResource(R.drawable.main_first_tab_img);

        // 开启一个Fragment事务用于切换片段
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.setTransition(fragmentAnimation);
        transaction.replace(R.id.main_fragment_container, mSixFragment); // 切换片段

        transaction.commit();
    }

    private void switchToSeven(){
        main_tab_selected = AppConstant.MAIN_TAB_SEVEN ;

        // 修改底部导航图片资源
        ImageView tempImgView = (ImageView) findViewById(R.id.main_first_tab_image);
        tempImgView.setImageResource(R.drawable.main_first_tab_img);

        // 开启一个Fragment事务用于切换片段
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.setTransition(fragmentAnimation);
        transaction.replace(R.id.main_fragment_container, mSevenFragment); // 切换片段

        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId() ;
        if (id == R.id.main_first_tab) {
            if (main_tab_selected != AppConstant.MAIN_TAB_FIRST) {
                setTabSelection(AppConstant.MAIN_TAB_FIRST);
            }
        } else if (id == R.id.main_second_tab) {
            if (main_tab_selected != AppConstant.MAIN_TAB_SECOND) {
                setTabSelection(AppConstant.MAIN_TAB_SECOND);
            }
        } else if (id == R.id.main_three_tab) {
            if (main_tab_selected != AppConstant.MAIN_TAB_THREE) {
                setTabSelection(AppConstant.MAIN_TAB_THREE);
            }
        } else if (id == R.id.main_four_tab) {
            if (main_tab_selected != AppConstant.MAIN_TAB_FOUR) {
                setTabSelection(AppConstant.MAIN_TAB_FOUR);
            }
        } else if (id == R.id.main_five_tab) {
            if (main_tab_selected != AppConstant.MAIN_TAB_FIVE) {
                setTabSelection(AppConstant.MAIN_TAB_FIVE);
            }
        } else if (id == R.id.main_six_tab) {
            if (main_tab_selected != AppConstant.MAIN_TAB_SIX) {
                setTabSelection(AppConstant.MAIN_TAB_SIX);
            }
        } else if (id == R.id.main_seven_tab) {
            if (main_tab_selected != AppConstant.MAIN_TAB_SEVEN) {
                setTabSelection(AppConstant.MAIN_TAB_SEVEN);
            }
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
