package com.example.sitimit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class PanelLantai extends AppCompatActivity {

    RecyclerView mRecyclerview;
    AdapterPanel mAdapter;
    RecyclerView.LayoutManager mManager;
    RequestQueue mRequest;
    List<ModelPanel> mListItems;

    private final String url ="https://jualbahanbangunan.com/timit/json_panel.php";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_lantai);

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListItems = new ArrayList<>();

        request();

        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterPanel(mListItems,PanelLantai.this);
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
                ArrayList<ModelPanel> itemFilter = new ArrayList<>();
                for (ModelPanel modelPanel : mListItems ){
                    String nama = modelPanel.getNama_panel().toLowerCase();
                    if(nama.contains(newText)){
                        itemFilter.add(modelPanel);
                    }
                }
                mAdapter.setFilter(itemFilter);

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void request(){
        JsonArrayRequest requestImage = new JsonArrayRequest(Request.Method.POST,url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse",response.toString());
                        for(int i=0; i<=response.length();i++){
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelPanel model= new ModelPanel();
                                model.setNama_panel(data.getString("nama_panel"));
                                model.setHarga_panel(data.getString("harga_panel"));
                                model.setGambar_url(data.getString("gambar_url"));
                                model.setDeskripsi_panel(data.getString("deskripsi_panel"));

                                mListItems.add(model);

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
                        Log.d("ERRORRequest", "Error :"+ error.getMessage());
                    }
                });
        mRequest.add(requestImage);
    }
}