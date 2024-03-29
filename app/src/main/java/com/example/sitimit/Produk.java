package com.example.sitimit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

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

    Button btnBeliProduk;

    RecyclerView mRecyclerview, mRecyclervieww, mRecylerGovalum, mRecyclerBoard;


    AdapterProduk mAdapter;
    AdapterGalvalum mAdapterGolvalum;
    AdapterPlafon mAdapterPlafon;
    AdapterBoard mAdapterBoard;

    RecyclerView.LayoutManager mManager;
    RequestQueue mRequest;



    List<ModelProduk> mListItem;
    List<ModelPlafon> mListPlafon;
    List<ModelGalvalum> mListGalvalum;
    List<ModelBoard> mListBoard;

    private final String urlBoard = "https://jualbahanbangunan.com/timit/json_semenboard.php";
    private  final String urlGalvalum ="https://jualbahanbangunan.com/timit/json_galvalum.php";
    private final String urlPlafon = "https://jualbahanbangunan.com/timit/json_plafon.php";
    private final String url = "https://jualbahanbangunan.com/timit/json_produk.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);

        btnBeliProduk = (Button) findViewById(R.id.btnBeliProduk);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_produk);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hijau)));

        mRecyclerview = (RecyclerView) findViewById(R.id.recylcerproduk);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListItem = new ArrayList<>();

        mRecyclervieww = (RecyclerView) findViewById(R.id.recyclePlafon);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListPlafon = new ArrayList<>();

        mRecylerGovalum = (RecyclerView) findViewById(R.id.recycleGalvalum);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListGalvalum = new ArrayList<>();

        mRecyclerBoard = (RecyclerView) findViewById(R.id.recycleBoard);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListBoard = new ArrayList<>();

        requesttt();
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        mRecylerGovalum.setLayoutManager(mManager);
        mAdapterGolvalum = new AdapterGalvalum(mListGalvalum, Produk.this);
        mRecylerGovalum.setAdapter(mAdapterGolvalum);

        request();
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterProduk(mListItem, Produk.this);
        mRecyclerview.setAdapter(mAdapter);

        requestt();

        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclervieww.setLayoutManager(mManager);
        mAdapterPlafon = new AdapterPlafon(mListPlafon, Produk.this);
        mRecyclervieww.setAdapter(mAdapterPlafon);

        requestBoard();
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        mRecyclerBoard.setLayoutManager(mManager);
        mAdapterBoard = new AdapterBoard(mListBoard, Produk.this);
        mRecyclerBoard.setAdapter(mAdapterBoard);

        btnBeliProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wpurl="https://api.whatsapp.com/send?phone=6281231313222&text=Halo%20Bu%20Rida%20Tiga%20Mitra%20Surabaya..%20Saya%20Ingin%20Membeli%20Produk%20..";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });


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
    private void requestt() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, urlPlafon, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse", response.toString());
                        for (int i = 0; i <= response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelPlafon model = new ModelPlafon();
                                model.setNama_plafon(data.getString("nama_plafon"));
                                model.setHarga_plafon(data.getString("harga_plafon"));

                                mListPlafon.add(model);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapterPlafon.notifyDataSetChanged();
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
    private void requesttt() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, urlGalvalum, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse", response.toString());
                        for (int i = 0; i <= response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelGalvalum model = new ModelGalvalum();
                                model.setNama_galvalum(data.getString("nama_galvalum"));
                                model.setHarga_galvalum(data.getString("harga_galvalum"));

                                mListGalvalum.add(model);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapterGolvalum.notifyDataSetChanged();
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
    private void requestBoard() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, urlBoard, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse", response.toString());
                        for (int i = 0; i <= response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelBoard model = new ModelBoard();
                                model.setNama_board(data.getString("nama_board"));
                                model.setHarga_board(data.getString("harga_board"));

                                mListBoard.add(model);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapterBoard.notifyDataSetChanged();
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
