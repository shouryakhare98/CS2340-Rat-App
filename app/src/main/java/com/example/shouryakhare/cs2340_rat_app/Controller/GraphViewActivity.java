package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shouryakhare.cs2340_rat_app.Model.DatabaseHandshake;
import com.example.shouryakhare.cs2340_rat_app.Model.RatSighting;
import com.example.shouryakhare.cs2340_rat_app.Model.SimpleModel;
import com.example.shouryakhare.cs2340_rat_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Activity to show a line graph of rat-data.
 */
public class GraphViewActivity extends AppCompatActivity {

    private GraphView graph;
    private String[] xAxisValues;
    private int[] yAxisValues;
    private final SimpleModel model = SimpleModel.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_view);

        graph = (GraphView) findViewById(R.id.graphView_lineChart);
        graph.setBackgroundColor(Color.WHITE);

        Button home;
        home = (Button) findViewById(R.id.graphView_homeButton);

        model.reset();
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        mRootRef.child("rat_data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    RatSighting temp = child.getValue(RatSighting.class);
                    model.addItem(temp);
                }
                DatabaseHandshake.readFile(getApplicationContext());

                getXAxisValues();
                getYAxisValues();
                plotData();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(GraphViewActivity.this,
                        NewLoginSuccessfulActivity.class);
                startActivity(homeIntent);
            }
        });
    }

    /**
     * Method to get labels for the X-Axis of the graph.
     */
    public void getXAxisValues() {
        Bundle bundle = getIntent().getExtras();
        int from = bundle.getInt("fromYear");
        int till = bundle.getInt("tillYear");

        int year = from;
        int month = 1;

        xAxisValues = new String[(till - from + 1) * 12];
        for (int i = 0; i < xAxisValues.length; i++) {
            xAxisValues[i] = month + "/" + year;

            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        }
    }

    /**
     * Method to get Y-Axis values.
     */
    public void getYAxisValues() {
        Bundle bundle = getIntent().getExtras();
        int from = bundle.getInt("fromYear");
        int till = bundle.getInt("tillYear");

        yAxisValues = new int[(till - from + 1) * 12];

        for (RatSighting sighting : model.getItems()) {
            int year = Integer.parseInt(sighting.getCreatedDate().split(" ")[0].split("/")[2]);
            int month = Integer.parseInt(sighting.getCreatedDate().split(" ")[0].split("/")[0]);

            if (year >= from && year <= till) {
                yAxisValues[(year - from) * 12 + month - 1]++;
            }
        }
    }

    /**
     * Method to plot data on screen.
     */
    private void plotData() {
        Bundle bundle = getIntent().getExtras();
        int from = bundle.getInt("fromYear");
        int till = bundle.getInt("tillYear");

        DataPoint[] dataPoints = new DataPoint[(till - from + 1) * 12];

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = new DataPoint(i, yAxisValues[i]);
        }

        LineGraphSeries<DataPoint> lineGraphSeries = new LineGraphSeries<>(dataPoints);
        lineGraphSeries.setColor(Color.RED);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    return xAxisValues[(int) value];
                } else {
                    return Integer.toString((int) value);
                }
            }
        });

        graph.getGridLabelRenderer().setNumHorizontalLabels((till - from + 1) * 2);
        graph.getViewport().setScalable(true);
        graph.addSeries(lineGraphSeries);
    }

    /**
     * Method to return xAxisValues
     * @return Array of X-Axis values.
     */
    public String[] returnXAxisValues() {
        return xAxisValues;
    }

    /**
     * Method to return yAxisValues
     * @return Array of Y-Axis values.
     */
    public int[] returnYAxisValues() {
        return yAxisValues;
    }
}
