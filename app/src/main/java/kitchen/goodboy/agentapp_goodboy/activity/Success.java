package kitchen.goodboy.agentapp_goodboy.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import kitchen.goodboy.agentapp_goodboy.R;
import kitchen.goodboy.agentapp_goodboy.others.ApplicationUtility;

public class Success extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        boolean checkConnection = new ApplicationUtility().checkConnection(this);
        if (checkConnection) {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent i = new Intent(Success.this, MainActivity.class);
                    startActivity(i);
                }
            }, SPLASH_TIME_OUT);

        } else {

            Toast.makeText(getApplicationContext(), "Connection not Found... Kindly Check Connection",
                    Toast.LENGTH_LONG).show();

        }


    }
}