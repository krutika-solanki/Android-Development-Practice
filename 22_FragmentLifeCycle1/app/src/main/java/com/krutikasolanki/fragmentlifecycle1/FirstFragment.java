package com.krutikasolanki.fragmentlifecycle1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FirstFragment extends Fragment {
    private static final String TAG = "MainActivity";

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: Fragment");
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Fragment");    
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Fragment");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Fragment");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: Fragment");
    }
}