package kitchen.goodboy.agentapp_goodboy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import kitchen.goodboy.agentapp_goodboy.R;

public class Help extends AppCompatActivity {
    ImageView helpback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        helpback = (ImageView) findViewById(R.id.help_back);
        helpback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
