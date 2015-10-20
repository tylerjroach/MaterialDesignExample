package com.tylerjroach.materialdesignexample.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;


public class BaseFragment extends Fragment {
  protected AppCompatActivity ACA;

  public BaseFragment() {
    // Required empty public constructor
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    ACA = (AppCompatActivity) context;
  }

  @Override public void onDetach() {
    super.onDetach();
    ACA = null;
  }

}
