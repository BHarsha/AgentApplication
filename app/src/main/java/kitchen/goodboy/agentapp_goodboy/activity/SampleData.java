package kitchen.goodboy.agentapp_goodboy.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kitchen.goodboy.agentapp_goodboy.Items.Hero;
import kitchen.goodboy.agentapp_goodboy.R;
import kitchen.goodboy.agentapp_goodboy.adapter.ListViewAdapter;
import kitchen.goodboy.agentapp_goodboy.others.SharedPrefManager;
import kitchen.goodboy.agentapp_goodboy.others.User;

public class SampleData extends AppCompatActivity {

    ImageView backdata;
    Button sampleentry;
    ListView listView;

    List<Hero> heroList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_data);

        setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        backdata = (ImageView) findViewById(R.id.sampledata_back);
        backdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SampleData.this, MainActivity.class);
                startActivity(intent);
            }
        });

        sampleentry = (Button) findViewById(R.id.sampleentry_btn);
        sampleentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SampleData.this, SampleEntry.class);
                startActivity(intent);

            }
        });

        listView = (ListView) findViewById(R.id.sampleDataList);
        heroList = new ArrayList<>();

        loadHeroList();

    }

    private void loadHeroList() {
        User user;
        user = SharedPrefManager.getInstance(this).getUser();

        final String JSON_URL = "http://agentgoodboy.esy.es/AgentAPI/SampleData.php?id="+ user.getId();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject obj = new JSONObject(response);

                            JSONArray heroArray = obj.getJSONArray("heroes");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < heroArray.length(); i++) {
                                JSONObject heroObject = heroArray.getJSONObject(i);

                                Hero hero = new Hero(heroObject.getString("name"), heroObject.getString("number"), heroObject.getString("address"), heroObject.getString("status"));

                                heroList.add(hero);
                            }

                            ListViewAdapter adapter = new ListViewAdapter(heroList, getApplicationContext());

                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }
}
