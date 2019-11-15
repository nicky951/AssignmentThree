package com.example.assignmentthree;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatDetail extends AppCompatActivity {

    private TextView catName;
    private ImageView catImage;
    private TextView catDescription;
    private TextView catTemperament;
    private TextView catOrigin;
    private TextView catLifespan;
    private TextView catWikipedia;
    private TextView catDog;
    private Button favouriteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_detailed);

        final Intent intent = getIntent();
        final Cat cat = (Cat) intent.getSerializableExtra("cat");


        favouriteButton = findViewById(R.id.favouritebutton);
        catName = findViewById(R.id.catname);
        catImage = findViewById(R.id.catimage);
        catDescription = findViewById(R.id.catdescription);
        catTemperament = findViewById(R.id.cattemp);
        catOrigin = findViewById(R.id.catorigin);
        catLifespan = findViewById(R.id.catlife);
        catWikipedia = findViewById(R.id.catlink);
        catDog = findViewById(R.id.catdog);


        catName.setText(cat.getName());
        catDescription.setText(cat.getDescription());
        catTemperament.setText(cat.getTemperament());
        catOrigin.setText(cat.getOrigin());
        catLifespan.setText(cat.getLife_span());
        catWikipedia.setText(cat.getWikipedia_url());

        String dog = Integer.toString(cat.getDog_friendly());
        catDog.setText(dog);


        final String specific = "https://api.thecatapi.com/v1/images/search?breed_ids=" + cat.getId();

        final RequestQueue requestQueue =  Volley.newRequestQueue(getApplicationContext());

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ImageURL[] imageURL = gson.fromJson(response, ImageURL[].class);
                List<ImageURL> urlList = Arrays.asList(imageURL);
                String image = urlList.get(0).getUrl();
                Glide.with(getApplicationContext()).load(image).into(catImage);

                Toast.makeText(getApplicationContext(),"Loading Image", Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, specific, responseListener, errorListener);

        requestQueue.add(stringRequest);

        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FavList.addCat(cat);
                FavList.print();
                Context context = v.getContext();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);

            }
        });

    }
}
