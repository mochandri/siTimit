package com.example.sitimit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

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
import java.util.Locale;

public class semenMortar extends AppCompatActivity {

        RecyclerView mRecyclerview;
        AdapterSemen mAdapter;
        RecyclerView.LayoutManager mManager;
        RequestQueue mRequest;
        List<ModelSemen> mListItem;

        private final String url = "https://jualbahanbangunan.com/timit/json_semen.php";

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semen_mortar);

            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.action_bar_layout_semen);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hijau)));

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerViewsemen);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListItem = new ArrayList<>();

        request();

        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterSemen(mListItem, semenMortar.this);
        mRecyclerview.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.item_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<ModelSemen> itemFilter = new ArrayList<>();
                for (ModelSemen modelSemen : mListItem ){
                    String nama = modelSemen.getNama_semen().toLowerCase();
                    if(nama.contains(newText)){
                        itemFilter.add(modelSemen);
                    }
                }
                mAdapter.setFilter(itemFilter);

                return true;
            }
        });
            return super.onCreateOptionsMenu(menu);
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
                                modell.setDeskripsi_semen(dataa.getString("deskripsi_semen"));

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
