package sg.edu.rp.c346.id20041194.L13ProblemStatement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.*;


public class MainActivity extends AppCompatActivity {

    ListView lvHospital;
    AsyncHttpClient client;
    ArrayAdapter<HospitalRecords> aa;
    CustomAdapter caAdapter;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHospital = findViewById(R.id.lvHospital);
        spinner = findViewById(R.id.spinner);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // This line simply creates a new empty Array List of Weather objects with the variable name alWeather
        ArrayList<HospitalRecords> alHospital = new ArrayList<HospitalRecords>();
        // Connect to the URL and wait for a response from URL.
        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=dee5ccce-4dfb-467f-bcb4-dc025b56b977&limit=10", new JsonHttpResponseHandler() {

            String institution; /* institution_type */
            String beds; /* no of beds */
            String facilities;
            String facilityNo; /* no of facilities. */
            String year; /* Year */
            /* onSuccess listener. Once a response is successfully received by the app from the URL, all code
                here will trigger. The variable (JSONObject response) represent the entire JSON object data
                that is being received. */
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonArrResult = response.getJSONObject("result");
                    JSONArray jsonArrRecords = jsonArrResult.getJSONArray("records");

                    for(int i = 0; i < jsonArrRecords.length(); i++) {

                        JSONObject jsonObjRecords = jsonArrRecords.getJSONObject(i);
                        institution = jsonObjRecords.getString("institution_type");
                        facilities = jsonObjRecords.getString("facility_type_a");
                        beds = jsonObjRecords.getString("no_beds");
                        facilityNo = jsonObjRecords.getString("no_of_facilities");
                        year = jsonObjRecords.getString("year");
                        HospitalRecords records = new HospitalRecords(institution, facilities, beds, facilityNo, year);
                        alHospital.add(records);
                    }
                }
                catch(JSONException e){

                }

                //Point X: Write your list view
                caAdapter = new CustomAdapter(MainActivity.this,R.layout.row,alHospital);
                lvHospital.setAdapter(caAdapter);


            }//end onSuccess
        });
    }//end onResume
}