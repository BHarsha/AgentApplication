package kitchen.goodboy.agentapp_goodboy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import kitchen.goodboy.agentapp_goodboy.R;

public class Wallet extends AppCompatActivity {

    ImageView walletback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        walletback = (ImageView) findViewById(R.id.wallet_back);
        walletback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wallet.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
