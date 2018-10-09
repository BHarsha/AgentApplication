package kitchen.goodboy.agentapp_goodboy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kitchen.goodboy.agentapp_goodboy.R;
import kitchen.goodboy.agentapp_goodboy.others.SharedPrefManager;
import kitchen.goodboy.agentapp_goodboy.others.User;

public class Profile extends AppCompatActivity {

    TextView aname, aemail, amobile, aprofession, agentid, arefcode;
    ImageView profileback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        aname = (TextView) findViewById(R.id.aname);
        agentid = (TextView) findViewById(R.id.agentid);
        amobile = (TextView) findViewById(R.id.anumber);
        aprofession = (TextView) findViewById(R.id.aprofession);
        aemail = (TextView) findViewById(R.id.aemail);
        arefcode = (TextView) findViewById(R.id.arefcode);

        profileback = (ImageView) findViewById(R.id.profile_back);
        profileback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, MainActivity.class);
                startActivity(intent);
            }
        });


        User user = SharedPrefManager.getInstance(this).getUser();

        aname.setText(user.getName());
        agentid.setText(user.getId());
        amobile.setText(user.getMobile());
        aprofession.setText(user.getProfession());
        arefcode.setText(user.getRefcode());
        aemail.setText(user.getEmail());
    }
}
