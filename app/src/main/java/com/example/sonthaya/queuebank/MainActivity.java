package com.example.sonthaya.queuebank;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView showvalue;
    int counter = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showvalue = (TextView)findViewById(R.id.queue);
    }

    public void count (View view){
        counter++;
        showvalue.setText(Integer.toString(counter));

//        AlertDialog dialog = new AlertDialog.Builder(this).setMessage("คิวของคุณ คือ  "+counter).show();
//        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
//        textView.setTextSize(40);

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => "+c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        // formattedDate have current date/time
//        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();


        // Now we display formattedDate value in TextView
//        TextView txtView = new TextView(this);
//        txtView.setText("Current Date and Time : "+formattedDate);
//        txtView.setGravity(Gravity.CENTER);
//        txtView.setTextSize(20);
//        setContentView(txtView);

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setCancelable(false);
        dialog.setTitle("คิวของท่าน คือ   "+counter);
        dialog.setMessage("เวลา "+formattedDate+ " โปรดรอจนกว่าจะถึงคิวของท่าน ขอบคุณที่ไว้วางใจธนาคารของเรา ");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //Action for "ok".
            }
        });

        final AlertDialog alert = dialog.create();
        alert.show();
    }

}
