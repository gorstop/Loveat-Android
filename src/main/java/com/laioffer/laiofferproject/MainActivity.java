package com.laioffer.laiofferproject;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements RestaurantListFragment.OnItemSelectListener,RestaurantGridFragment.OnItemSelectListener {

    private BackendListFragment mBackendFragment;
    private RestaurantListFragment mListFragment;
    private RestaurantGridFragment mGridFragment;
    @Override
    public void onListItemSelected(int position) {
        mListFragment.onItemSelected(position);
    }

    @Override
    public void onItemSelected(int position){
        mGridFragment.onItemSelected(position);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add list view

        Intent intent = getIntent();
        String service = intent.getStringExtra("Service");

        if (service.equals("Yelp")) {
            mListFragment = new RestaurantListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.restaurant_list_container,
                    mListFragment).commit();
        } else {
            mBackendFragment = new BackendListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.restaurant_list_container,
                    mBackendFragment).commit();
        }


    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }


}