package com.example.assignmentthree;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;


public class FavouritesFragment extends Fragment {
    private RecyclerView recyclerView;

    private FavouritesFragment.OnFragmentInteractionListener mListener;

    public FavouritesFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.favouritesrecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        final FavouritesAdapter favouritesAdapter = new FavouritesAdapter();
        favouritesAdapter.setData(FavList.returnList());

        return view;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String string);
    }

    public void request() {

        EditText editText = getView().findViewById(R.id.search);

        final String searchCondition = editText.getText().toString();

        final RequestQueue requestQueue =  Volley.newRequestQueue(getActivity());
        final SearchAdapter searchAdapter = new SearchAdapter();

        String url =  "https://api.thecatapi.com/v1/breeds?api_key=01124a80-0956-43a2-baa4-617535dc0e8f";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                Cat[] catArray = gson.fromJson(response, Cat[].class);
                List<Cat> catList = Arrays.asList(catArray);

                CatDatabase db = Room.databaseBuilder(getContext(), CatDatabase.class , "database_name").allowMainThreadQueries().build();

                db.catDao().insert(catList);

                searchAdapter.setData(db.catDao().findCatByName(searchCondition));

                recyclerView.setAdapter(searchAdapter);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);

        requestQueue.add(stringRequest);
    }

}
