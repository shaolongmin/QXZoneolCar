package com.zoneol.qxcar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoneol.qxcar.R;
import com.zoneol.qxcar.fragment.index.IndexBatteryFragment;
import com.zoneol.qxcar.fragment.index.IndexControlTearFragment;
import com.zoneol.qxcar.fragment.index.IndexControlTemperatureFragment;
import com.zoneol.qxcar.fragment.index.IndexDoorPressureFragment;
import com.zoneol.qxcar.fragment.index.IndexMotorFragment;
import com.zoneol.qxcar.fragment.index.IndexPressureFragment;
import com.zoneol.qxcar.fragment.index.IndexSlipFragment;
import com.zoneol.qxcar.fragment.index.IndexWheelHeightFragment;
import com.zoneol.qxcar.fragment.index.IndexWheelMotorFragment;
import com.zoneol.qxcar.fragment.index.IndexWheelTemperatureFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IndexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndexFragment extends BaseFragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //select index
    private static final int INDEX_CONTROL_TEMPERATURE = 0 ;
    private static final int INDEX_CONTROL_TEAR = 1 ;
    private static final int INDEX_WHEEL_HEIGHT = 2 ;
    private static final int INDEX_WHEEL_TEMPERATURE = 3 ;
    private static final int INDEX_SLIP = 4 ;
    private static final int INDEX_PRESSURE = 5 ;
    private static final int INDEX_DOOR_PRESSURE = 6 ;
    private static final int INDEX_BATTERY = 7 ;
    private static final int INDEX_WHEEL_MOTOR = 8 ;
    private static final int INDEX_MOTOR = 9 ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //right fragment list
    private IndexControlTemperatureFragment indexControlTemperatureFragment = null;
    private IndexControlTearFragment indexControlTearFragment = null ;
    private IndexWheelHeightFragment indexWheelHeightFragment = null ;
    private IndexWheelTemperatureFragment indexWheelTemperatureFragment = null ;
    private IndexSlipFragment indexSlipFragment = null ;
    private IndexPressureFragment indexPressureFragment = null ;
    private IndexDoorPressureFragment indexDoorPressureFragment = null ;
    private IndexBatteryFragment indexBatteryFragment = null ;
    private IndexWheelMotorFragment indexWheelMotorFragment = null ;
    private IndexMotorFragment indexMotorFragment = null ;

    //index select position
    private int indexSelectPosition ;

    //index textView list
    private TextView index_txt_control_temperature ;
    private TextView index_txt_control_tear ;
    private TextView index_txt_wheel_height ;
    private TextView index_txt_wheel_temperature ;
    private TextView index_txt_slip ;
    private TextView index_txt_pressure ;
    private TextView index_txt_door_pressure ;
    private TextView index_txt_battery ;
    private TextView index_txt_motor ;
    private TextView index_txt_wheel_motor ;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndexFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IndexFragment newInstance(String param1, String param2) {
        IndexFragment fragment = new IndexFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public IndexFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        this.initIndexFragment() ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);

        this.initView(view);

        indexSelectPosition = INDEX_CONTROL_TEMPERATURE ;

        // 将首页片段设定为当前显示的片段
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.index_right_contain, indexControlTemperatureFragment)
                .commit();

        return view;
    }

    private void initView(View view) {
        index_txt_control_temperature = (TextView)view.findViewById(R.id.index_txt_control_temperature);
        index_txt_control_tear = (TextView)view.findViewById(R.id.index_txt_control_tear);
        index_txt_wheel_height = (TextView)view.findViewById(R.id.index_txt_wheel_height);
        index_txt_wheel_temperature = (TextView)view.findViewById(R.id.index_txt_wheel_temperature);
        index_txt_slip = (TextView)view.findViewById(R.id.index_txt_slip);
        index_txt_pressure = (TextView)view.findViewById(R.id.index_txt_pressure);
        index_txt_door_pressure = (TextView)view.findViewById(R.id.index_txt_door_pressure);
        index_txt_battery = (TextView)view.findViewById(R.id.index_txt_battery);
        index_txt_motor = (TextView)view.findViewById(R.id.index_txt_motor);
        index_txt_wheel_motor = (TextView)view.findViewById(R.id.index_txt_wheel_motor);

        index_txt_control_temperature.setOnClickListener(this);
        index_txt_control_tear.setOnClickListener(this);
        index_txt_wheel_height.setOnClickListener(this);
        index_txt_wheel_temperature.setOnClickListener(this);
        index_txt_slip.setOnClickListener(this);
        index_txt_pressure.setOnClickListener(this);
        index_txt_door_pressure.setOnClickListener(this);
        index_txt_battery.setOnClickListener(this);
        index_txt_motor.setOnClickListener(this);
        index_txt_wheel_motor.setOnClickListener(this);

    }

    private void initIndexFragment() {
        if (indexControlTemperatureFragment == null) {
            indexControlTemperatureFragment = new IndexControlTemperatureFragment() ;
        }

        if (indexControlTearFragment == null) {
            indexControlTearFragment = new IndexControlTearFragment() ;
        }

        if (indexWheelHeightFragment == null) {
            indexWheelHeightFragment = new IndexWheelHeightFragment() ;
        }

        if (indexWheelTemperatureFragment == null) {
            indexWheelTemperatureFragment = new IndexWheelTemperatureFragment() ;
        }

        if (indexSlipFragment == null) {
            indexSlipFragment = new IndexSlipFragment() ;
        }

        if (indexPressureFragment == null) {
            indexPressureFragment = new IndexPressureFragment() ;
        }

        if (indexDoorPressureFragment == null) {
            indexDoorPressureFragment = new IndexDoorPressureFragment() ;
        }

        if (indexBatteryFragment == null) {
            indexBatteryFragment = new IndexBatteryFragment() ;
        }

        if (indexWheelMotorFragment == null) {
            indexWheelMotorFragment = new IndexWheelMotorFragment() ;
        }

        if (indexMotorFragment == null) {
            indexMotorFragment = new IndexMotorFragment() ;
        }
    }

    private void restoreTxtColor() {

        FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                .beginTransaction();

        if (indexSelectPosition == INDEX_CONTROL_TEMPERATURE) {
            index_txt_control_temperature.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexControlTemperatureFragment);
        }else if (indexSelectPosition == INDEX_CONTROL_TEAR) {
            index_txt_control_tear.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexControlTearFragment);
        }else if(indexSelectPosition == INDEX_WHEEL_HEIGHT) {
            index_txt_wheel_height.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexWheelHeightFragment);
        }else if(indexSelectPosition == INDEX_WHEEL_TEMPERATURE) {
            index_txt_wheel_temperature.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexWheelTemperatureFragment);
        }else if(indexSelectPosition == INDEX_SLIP) {
            index_txt_slip.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexSlipFragment);
        }else if(indexSelectPosition == INDEX_PRESSURE) {
            index_txt_pressure.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexPressureFragment);
        }else if(indexSelectPosition == INDEX_BATTERY) {
            index_txt_battery.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexBatteryFragment);
        }else if(indexSelectPosition == INDEX_DOOR_PRESSURE) {
            index_txt_door_pressure.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexDoorPressureFragment);
        }else if(indexSelectPosition == INDEX_MOTOR) {
            index_txt_motor.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexMotorFragment);
        }else if(indexSelectPosition == INDEX_WHEEL_MOTOR) {
            index_txt_wheel_motor.setTextColor(getResources().getColor(R.color.white));
            transaction.hide(indexWheelMotorFragment);
        }
    }

    private void swithRightContain(int index) {
        this.restoreTxtColor();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        Fragment fragment = null ;
        if (indexSelectPosition == INDEX_CONTROL_TEMPERATURE) {
            indexSelectPosition = INDEX_CONTROL_TEMPERATURE ;
            index_txt_control_temperature.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexControlTemperatureFragment ;
        }else if (indexSelectPosition == INDEX_CONTROL_TEAR) {
            indexSelectPosition = INDEX_CONTROL_TEAR ;
            index_txt_control_tear.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexControlTearFragment ;
        }else if(indexSelectPosition == INDEX_WHEEL_HEIGHT) {
            indexSelectPosition = INDEX_WHEEL_HEIGHT ;
            index_txt_wheel_height.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexWheelHeightFragment ;
        }else if(indexSelectPosition == INDEX_WHEEL_TEMPERATURE) {
            indexSelectPosition = INDEX_WHEEL_TEMPERATURE ;
            index_txt_wheel_temperature.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexWheelTemperatureFragment ;
        }else if(indexSelectPosition == INDEX_SLIP) {
            indexSelectPosition = INDEX_SLIP ;
            index_txt_slip.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexSlipFragment ;
        }else if(indexSelectPosition == INDEX_PRESSURE) {
            indexSelectPosition = INDEX_PRESSURE ;
            index_txt_pressure.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexPressureFragment ;
        }else if(indexSelectPosition == INDEX_BATTERY) {
            indexSelectPosition = INDEX_BATTERY ;
            index_txt_battery.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexBatteryFragment ;
        }else if(indexSelectPosition == INDEX_DOOR_PRESSURE) {
            indexSelectPosition = INDEX_DOOR_PRESSURE ;
            index_txt_door_pressure.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexDoorPressureFragment ;
        }else if(indexSelectPosition == INDEX_MOTOR) {
            indexSelectPosition = INDEX_MOTOR ;
            index_txt_motor.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexMotorFragment ;
        }else if(indexSelectPosition == INDEX_WHEEL_MOTOR) {
            indexSelectPosition = INDEX_WHEEL_MOTOR ;
            index_txt_wheel_motor.setTextColor(getResources().getColor(R.color.yellow));
            fragment = indexWheelMotorFragment ;
        }

        transaction.replace(R.id.index_right_contain , fragment).commit() ;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId() ;
        if (id == R.id.index_txt_control_temperature) {
            swithRightContain(INDEX_CONTROL_TEMPERATURE) ;
        } else if (id == R.id.index_txt_control_tear) {
            swithRightContain(INDEX_CONTROL_TEAR) ;
        } else if (id == R.id.index_txt_wheel_height) {
            swithRightContain(INDEX_WHEEL_HEIGHT) ;
        } else if (id == R.id.index_txt_wheel_temperature) {
            swithRightContain(INDEX_WHEEL_TEMPERATURE) ;
        } else if (id == R.id.index_txt_slip) {
            swithRightContain(INDEX_SLIP) ;
        } else if (id == R.id.index_txt_pressure) {
            swithRightContain(INDEX_PRESSURE) ;
        } else if (id == R.id.index_txt_door_pressure) {
            swithRightContain(INDEX_DOOR_PRESSURE) ;
        } else if (id == R.id.index_txt_battery) {
            swithRightContain(INDEX_BATTERY) ;
        } else if(id == R.id.index_txt_motor) {
            swithRightContain(INDEX_MOTOR) ;
        } else if (id == R.id.index_txt_wheel_motor) {
            swithRightContain(INDEX_WHEEL_MOTOR) ;
        }
    }
}
