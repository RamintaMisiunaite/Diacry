package com.example.diacry;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.github.sundeepk.compactcalendarview.domain.Event;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calanderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calanderFragment extends Fragment {

    CompactCalendarView compactCalendar;
    Context context;
    TextView monthTv;
    ImageButton backBt, nextBt;
    long timeInMillis;

    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calanderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calanderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static calanderFragment newInstance(String param1, String param2) {
        calanderFragment fragment = new calanderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calander, container, false);

        backBt = view.findViewById(R.id.cal_back);
        nextBt = view.findViewById(R.id.cal_next);
        monthTv = view.findViewById(R.id.monthTv);

        compactCalendar = view.findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);
        SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
        SimpleDateFormat dateFormatForDay = new SimpleDateFormat("MMM dd", Locale.getDefault());
        SimpleDateFormat dateFormatForFullDate = new SimpleDateFormat("yyyy/MM/dd");



        //Set an event for Teachers' Professional Day 2016 which is 21st of October

        Event ev1 = new Event(Color.parseColor("#613DC1"), 1643556000000L, "Teachers' Professional Day");
        compactCalendar.addEvent(ev1);




        monthTv.setText(dateFormatForMonth.format(compactCalendar.getFirstDayOfCurrentMonth()));


        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {

            @Override
            public void onDayClick(Date dateClicked) {
                String date = dateFormatForDay.format(dateClicked);
                String fullDateStr = dateFormatForFullDate.format(dateClicked);
                try {
                    Date fullDate = dateFormatForFullDate.parse(fullDateStr);
                    timeInMillis = fullDate.getTime();

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(getActivity(),DayActivity.class);
                intent.putExtra("date",date);
                intent.putExtra("dateInMills", timeInMillis);
                startActivity(intent);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                monthTv.setText(dateFormatForMonth.format(firstDayOfNewMonth));
            }
        });

        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compactCalendar.scrollLeft();
            }
        });

        nextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compactCalendar.scrollRight();
            }
        });


        return view;
    }


}
