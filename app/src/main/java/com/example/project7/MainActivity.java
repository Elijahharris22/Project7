package com.example.project7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicket = 34.00;
    int numberOfTickets;
    double totalCost;
    String groupChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tickets =(EditText) findViewById(R.id.txtTickets);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener(){
            final TextView result = (android.widget.TextView)findViewById(R.id.txtResult);
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                totalCost = costPerTicket * numberOfTickets;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Cost for " + groupChoice + " is " + currency.format(totalCost));
            }
        });
    }

}