package com.example.sitimit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


public class BataRingan extends AppCompatActivity
    {
        RecyclerView mRecyclerview;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mManager;
        RequestQueue mRequest;
        List<ModelList> mListItems;

        int RecyclerViewItemPosition;


        ArrayList<String> ImageTitleidArrayListForClick;

        private final String url ="https://jualbahanbangunan.com/timit/json_bata.php";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bata_ringan);


            ImageTitleidArrayListForClick = new ArrayList<>();

            mRecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
            mRequest = Volley.newRequestQueue(getApplicationContext());
            mListItems = new ArrayList<>();


            request();
            mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            mRecyclerview.setLayoutManager(mManager);
            mAdapter = new AdapterList(mListItems, BataRingan.this);
            mRecyclerview.setAdapter(mAdapter);

            //fungsi klik
            mRecyclerview.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                GestureDetector gestureDetector = new GestureDetector(BataRingan.this, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent motionEvent) {
                        return true;
                    }
                });


                @Override
                public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {


                     View view = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                    if (view != null && gestureDetector.onTouchEvent(motionEvent)) {
                        RecyclerViewItemPosition= Recyclerview.getChildAdapterPosition(view);

                        Intent intent = new Intent(BataRingan.this, DetailActivity.class);
                        intent.putExtra("send_id", ImageTitleidArrayListForClick.get(RecyclerViewItemPosition));
                        startActivity(intent);
                    }


                    return false;
                }

                @Override
                public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }
            });

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
                                    ModelList model= new ModelList();
                                    model.setNama_bata(data.getString("nama_bata"));
                                    model.setHarga_bata(data.getString("harga_bata"));
                                    model.setGambar_url(data.getString("gambar_url"));

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