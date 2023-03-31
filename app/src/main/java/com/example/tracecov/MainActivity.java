package com.example.tracecov;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracecov.api.ApiUtilities;
import com.example.tracecov.api.CovidData;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView total_recovered,today_recovered,total_confirmed,today_confirmed,active_today,total_deaths,today_deaths,total_tests,today_tests;

    private PieChart pieChart;

    private List<CovidData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        init();

        ApiUtilities.getApi().getCovidData().enqueue(new Callback<List<CovidData>>() {
            @Override
            public void onResponse(Call<List<CovidData>> call, Response<List<CovidData>> response) {
                list.addAll(response.body());

                for(int i=0;i<list.size();i++){
                    if(list.get(i).getDistrict_name().equals("Kolhapur")){
                        int confirm = Integer .parseInt(list.get(i).getConfirmed());
                        int active = Integer.parseInt(list.get(i).getActive());
                        int deaths = Integer.parseInt(list.get(i).getDeceased());
                        int recovered = Integer.parseInt(list.get(i).getRecovered());

                        active_today.setText(NumberFormat.getInstance().format(active));
                        total_confirmed.setText(NumberFormat.getInstance().format(confirm));
                        total_deaths.setText(NumberFormat.getInstance().format(deaths));
                        total_recovered.setText(NumberFormat.getInstance().format(recovered));

                        today_confirmed.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayConfirmed())));
                        today_recovered.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayRecovred())));
                        today_deaths.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayDeceased())));

                        pieChart.addPieSlice(new PieModel("Confirm",confirm, Color.parseColor("#C4A484")));
                        pieChart.addPieSlice(new PieModel("Active",active, Color.parseColor("blue")));
                        pieChart.addPieSlice(new PieModel("Recovered",deaths, getResources().getColor(R.color.pink)));
                        pieChart.addPieSlice(new PieModel("Deceased",recovered, getResources().getColor(R.color.yellow)));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CovidData>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error: "+t.getMessage(),Toast.LENGTH_LONG);
            }
        });
    }

    private void init(){
        total_recovered = findViewById(R.id.total_recovered);
        today_recovered = findViewById(R.id.today_recovered);

        total_confirmed = findViewById(R.id.total_confirmed);
        today_confirmed = findViewById(R.id.today_confirmed);

        active_today = findViewById(R.id.active_today);

        total_deaths = findViewById(R.id.total_deaths);
        today_deaths = findViewById(R.id.today_deaths);

        pieChart = findViewById(R.id.pieChart);

    }
}