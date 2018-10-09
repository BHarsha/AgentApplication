package kitchen.goodboy.agentapp_goodboy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import kitchen.goodboy.agentapp_goodboy.R;

public class SubscriptionEntry extends AppCompatActivity {

    ImageView mycback;
    Button subscriptionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_enrty);

        mycback = (ImageView) findViewById(R.id.mycustomers_back);
        mycback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubscriptionEntry.this, MainActivity.class);
                startActivity(intent);
            }
        });

        subscriptionButton = (Button) findViewById(R.id.subscription_btn);
        subscriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubscriptionEntry.this, SubscriptionData.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
