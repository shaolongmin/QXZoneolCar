package com.zoneol.qxcar.fragment.six;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zoneol.qxcar.R;
import com.zoneol.qxcar.fragment.BaseFragment;
import com.zoneol.qxcar.fragment.six.setting.SixSettingFourFragment;
import com.zoneol.qxcar.fragment.six.setting.SixSettingOneFragment;
import com.zoneol.qxcar.fragment.six.setting.SixSettingThreeFragment;
import com.zoneol.qxcar.fragment.six.setting.SixSettingTwoFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SixFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SixFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SixFragment extends BaseFragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //select index
    private static final int SIX_SETTING_ONE = 0 ;
    private static final int SIX_SETTING_TWO = 1 ;
    private static final int SIX_SETTING_THREE = 2 ;
    private static final int SIX_SETTING_FOUR = 3 ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //fragment list
    private SixSettingOneFragment mSixSettingOneFragment = null ;
    private SixSettingTwoFragment mSixSettingTwoFragment = null ;
    private SixSettingThreeFragment mSixSettingThreeFragment = null ;
    private SixSettingFourFragment mSixSettingFourFragment = null ;

    //six select position
    private int sixSelectPosition ;

    //left button list
    private Button mSettingOneBtn , mSettingTwoBtn , mSettingThreeBtn , mSettingFourBtn ;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SixFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SixFragment newInstance(String param1, String param2) {
        SixFragment fragment = new SixFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SixFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        this.initSixFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_six, container, false);

        this.initView(view);

        sixSelectPosition = SIX_SETTING_ONE ;

        // 将首页片段设定为当前显示的片段
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.six_left_contain, mSixSettingOneFragment)
                .commit();

        return view;
    }

    private void initView(View view) {
        mSettingOneBtn = (Button)view.findViewById(R.id.six_right_one_btn) ;
        mSettingTwoBtn = (Button)view.findViewById(R.id.six_right_two_btn) ;
        mSettingThreeBtn = (Button)view.findViewById(R.id.six_right_three_btn) ;
        mSettingFourBtn = (Button)view.findViewById(R.id.six_right_four_btn) ;

        mSettingOneBtn.setOnClickListener(this);
        mSettingTwoBtn.setOnClickListener(this);
        mSettingThreeBtn.setOnClickListener(this);
        mSettingFourBtn.setOnClickListener(this);

    }

    private void initSixFragment() {
        if (mSixSettingOneFragment == null) {
            mSixSettingOneFragment = new SixSettingOneFragment();
        }

        if (mSixSettingTwoFragment == null) {
            mSixSettingTwoFragment = new SixSettingTwoFragment() ;
        }

        if (mSixSettingThreeFragment == null) {
            mSixSettingThreeFragment = new SixSettingThreeFragment() ;
        }

        if (mSixSettingFourFragment == null) {
            mSixSettingFourFragment = new SixSettingFourFragment() ;
        }
    }

    private void restoreTxtColor() {

        FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                .beginTransaction();

        if (sixSelectPosition == SIX_SETTING_ONE) {

            transaction.hide(mSixSettingOneFragment);
        }else if (sixSelectPosition == SIX_SETTING_TWO) {

            transaction.hide(mSixSettingTwoFragment);
        }else if(sixSelectPosition == SIX_SETTING_THREE) {

            transaction.hide(mSixSettingThreeFragment);
        }else if(sixSelectPosition == SIX_SETTING_FOUR) {

            transaction.hide(mSixSettingFourFragment);
        }
    }

    private void swithLeftContain(int index) {
        this.restoreTxtColor();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        Fragment fragment = null ;
        if (index == SIX_SETTING_ONE) {
            sixSelectPosition = SIX_SETTING_ONE ;

            fragment = mSixSettingOneFragment ;
        }else if (index == SIX_SETTING_TWO) {
            sixSelectPosition = SIX_SETTING_TWO ;

            fragment = mSixSettingTwoFragment ;
        }else if(index == SIX_SETTING_THREE) {
            sixSelectPosition = SIX_SETTING_THREE ;

            fragment = mSixSettingThreeFragment ;
        }else if(index == SIX_SETTING_FOUR) {
            sixSelectPosition = SIX_SETTING_FOUR ;

            fragment = mSixSettingFourFragment ;
        }

        transaction.replace(R.id.six_left_contain , fragment).commit() ;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId() ;
        if (id == R.id.six_right_one_btn) {
            swithLeftContain(SIX_SETTING_ONE) ;
        } else  if (id == R.id.six_right_two_btn) {
            swithLeftContain(SIX_SETTING_TWO) ;
        } else  if (id == R.id.six_right_three_btn) {
            swithLeftContain(SIX_SETTING_THREE) ;
        } else  if (id == R.id.six_right_four_btn) {
            swithLeftContain(SIX_SETTING_FOUR) ;
        }
    }
}
