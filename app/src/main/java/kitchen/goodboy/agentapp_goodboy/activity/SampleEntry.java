package kitchen.goodboy.agentapp_goodboy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import kitchen.goodboy.agentapp_goodboy.R;

public class SampleEntry extends AppCompatActivity {

    Button sampledata, adddata;
    ImageView backsample;
    EditText samplepetname, samplepetage, samplepetbreed, samplecustomername, samplecustomercontact, samplecustomeraddress, samplecustomeremail;

    public static final String INSERT_URL = "http://agentgoodboy.esy.es/AgentAPI/SampleEntry.php";
    public static final String KEY_PETNAME = "petname";
    public static final String KEY_PETBREED = "petbreed";
    public static final String KEY_PETAGE = "petage";
    public static final String KEY_CUSTOMERNAME = "name";
    public static final String KEY_CUSTOMERCONTACT = "number";
    public static final String KEY_CUSTOMERADDRESS = "address";
    public static final String KEY_CUSTOMEREMAIL = "emailid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_entry);

        samplepetname = (EditText) findViewById(R.id.sample_petname);
        samplepetage = (EditText) findViewById(R.id.sample_petage);
        samplepetbreed = (EditText) findViewById(R.id.sample_petbreed);
        samplecustomername = (EditText) findViewById(R.id.sample_name);
        samplecustomercontact = (EditText) findViewById(R.id.sample_number);
        samplecustomeraddress = (EditText) findViewById(R.id.sample_address);
        samplecustomeremail = (EditText) findViewById(R.id.sample_email);

        sampledata = (Button) findViewById(R.id.sampledata_btn);
        sampledata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SampleEntry.this, SampleData.class);
                startActivity(intent);
            }
        });

        adddata = (Button) findViewById(R.id.sample_submit);

        backsample = (ImageView) findViewById(R.id.sampleentry_back);
        backsample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SampleEntry.this, MainActivity.class);
                startActivity(intent);
            }
        });

        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUser();
                cleardata();
                Intent intent = new Intent(SampleEntry.this, Success.class);
                startActivity(intent);
            }
        });
    }

    private void cleardata() {

        samplepetage.setText("");
        samplepetbreed.setText("");
        samplepetage.setText("");
        samplecustomername.setText("");
        samplecustomeraddress.setText("");
        samplecustomercontact.setText("");
        samplecustomeremail.setText("");
    }

    private void insertUser() {
        final String fpetname = samplepetname.getText().toString().trim();
        final String fpetbreed = samplepetbreed.getText().toString().trim();
        final String fpetage = samplepetage.getText().toString().trim();
        final String fcname = samplecustomername.getText().toString().trim();
        final String fcnumber = samplecustomercontact.getText().toString().trim();
        final String fcaddress = samplecustomeraddress.getText().toString().trim();
        final String fcemail = samplecustomeremail.getText().toString().trim();

        if (TextUtils.isEmpty(fpetname)) {
            samplepetname.setError("Please enter Pet Name");
            samplepetname.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(fpetbreed)) {
            samplepetbreed.setError("Please enter Pet Breed");
            samplepetbreed.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(fpetage)) {
            samplepetage.setError("Please enter Pet Age");
            samplepetage.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(fcname)) {
            samplecustomername.setError("Please enter Customer Name");
            samplecustomername.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(fcnumber)) {
            samplecustomercontact.setError("Please enter Customer Number");
            samplecustomercontact.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(fcaddress)) {
            samplecustomeraddress.setError("Please enter Customer Address");
            samplecustomeraddress.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(fcemail)) {
            samplecustomeremail.setError("Please enter Customer Email");
            samplecustomeremail.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, INSERT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SampleEntry.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SampleEntry.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_PETNAME, fpetname);
                params.put(KEY_PETBREED, fpetbreed);
                params.put(KEY_PETAGE, fpetage);
                params.put(KEY_CUSTOMERNAME, fcname);
                params.put(KEY_CUSTOMERCONTACT, fcnumber);
                params.put(KEY_CUSTOMERADDRESS, fcaddress);
                params.put(KEY_CUSTOMEREMAIL, fcemail);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
