package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class semenMortar extends AppCompatActivity {

        RecyclerView mRecyclerview;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mManager;
        RequestQueue mRequest;
        List<ModelSemen> mListItem;

        private final String url = "https://jualbahanbangunan.com/timit/json_semen.php";

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semen_mortar);

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerViewsemen);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListItem = new ArrayList<>();

        request();

        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterSemen(mListItem, semenMortar.this);
        mRecyclerview.setAdapter(mAdapter);

    }
        private void request () {
        JsonArrayRequest requestImage = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse", response.toString());
                        for (int i = 0; i <= response.length(); i++) {
                            try {
                                JSONObject dataa = response.getJSONObject(i);
                                ModelSemen modell = new ModelSemen();
                                modell.setNama_semen(dataa.getString("nama_semen"));
                                modell.setHarga_semen(dataa.getString("harga_semen"));
                                modell.setGambar_url(dataa.getString("gambar_url"));

                                mListItem.add(modell);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERRORRequest", "Error :" + error.getMessage());
                    }
                });
        mRequest.add(requestImage);
    }
    }
