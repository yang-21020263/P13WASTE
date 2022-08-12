package sg.edu.rp.c346.id21020263.p13ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    AsyncHttpClient client;
    ArrayAdapter<Waste> aaWaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        client = new AsyncHttpClient();

    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Waste> alWaste = new ArrayList<Waste>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=7918b229-0e79-4d74-b725-e34183a56c01&limit=10", new JsonHttpResponseHandler() {

            String recycled;
            String disposed;
            String year;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonObjResult = response.getJSONObject("result");
                    JSONArray jsonArrRecord = jsonObjResult.getJSONArray("records");
                    for (int i = 0; i < jsonArrRecord.length(); i++) {
                        JSONObject jsonObjRecord = jsonArrRecord.getJSONObject(i);
                        recycled = jsonObjRecord.getString("waste_recycled");
                        disposed = jsonObjRecord.getString("waste_disposed_of");
                        year = jsonObjRecord.getString("year");
                        Waste waste = new Waste(recycled, disposed, year);
                        alWaste.add(waste);
                    }
                } catch (JSONException e) {

                }

                //POINT X – Code to display List View
                aaWaste = new ArrayAdapter<Waste>(MainActivity.this, android.R.layout.simple_list_item_1, alWaste);
                lv.setAdapter(aaWaste);

            }//end onSuccess
        });
    }//end onResume
}