package kitchen.goodboy.agentapp_goodboy.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import kitchen.goodboy.agentapp_goodboy.R;
import kitchen.goodboy.agentapp_goodboy.others.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    ImageView settings;
    final Context context = this;
    RelativeLayout freesample, mycustomers, wallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = (ImageView) findViewById(R.id.settings_icon);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.settings_dialog);

                Button profile = (Button) dialog.findViewById(R.id.profile);
                Button help = (Button) dialog.findViewById(R.id.help);
                Button logout = (Button) dialog.findViewById(R.id.logout);

                profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Profile.class);
                        startActivity(intent);
                    }
                });

                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Help.class);
                        startActivity(intent);
                    }
                });
                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        logout();
                    }
                });


                ImageView close = (ImageView) dialog.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(MainActivity.this, Login.class));
        }



        SharedPreferences.Editor editor = getSharedPreferences("default", MODE_PRIVATE).edit();
        editor.putBoolean("isLoggedIn", true);
        editor.commit();

        freesample = (RelativeLayout) findViewById(R.id.rel1);
        freesample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SampleEntry.class);
                startActivity(intent);
            }
        });

        mycustomers = (RelativeLayout) findViewById(R.id.rel2);
        mycustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubscriptionEntry.class);
                startActivity(intent);
            }
        });

        wallet = (RelativeLayout) findViewById(R.id.rel3);
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Wallet.class);
                startActivity(intent);
            }
        });
    }

    private void logout() {
        finish();
        SharedPrefManager.getInstance(getApplicationContext()).logout();
    }

    @Override
    public void onBackPressed() {
    }
}
