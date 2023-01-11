package com.example.sitimit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

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

public class Produk extends AppCompatActivity {
    RecyclerView mRecyclerview;
    AdapterProduk mAdapter;
    RecyclerView.LayoutManager mManager;
    RequestQueue mRequest;
    List<ModelProduk> mListItem;

    private final String url = "https://jualbahanbangunan.com/timit/json_produk.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_produk);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hijau)));

        mRecyclerview = (RecyclerView) findViewById(R.id.recylcerproduk);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListItem = new ArrayList<>();

        request();
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterProduk(mListItem, Produk.this);
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
                ArrayList<ModelProduk> itemFilter = new ArrayList<>();
                for (ModelProduk modelProduk : mListItem ){
                    String nama = modelProduk.getNama_produk().toLowerCase();
                    if(nama.contains(newText)){
                        itemFilter.add(modelProduk);
                    }
                }
                mAdapter.setFilter(itemFilter);

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void request() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse", response.toString());
                        for (int i = 0; i <= response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelProduk model = new ModelProduk();
                                model.setNama_produk(data.getString("nama_produk"));
                                model.setHarga_produk(data.getString("harga_produk"));

                                mListItem.add(model);

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
        mRequest.add(jsonArrayRequest);
    }
}
