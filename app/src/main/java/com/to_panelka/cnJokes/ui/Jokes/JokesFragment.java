package com.to_panelka.cnJokes.ui.Jokes;

import android.content.Context;
import android.os.AsyncTask;
import android.text.PrecomputedText.Params;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.to_panelka.cnJokes.R;
import com.to_panelka.cnJokes.adapter.JokesAdapter;
import com.to_panelka.cnJokes.models.JokeModel;
import com.to_panelka.cnJokes.models.JokesModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class JokesFragment extends Fragment {

  private JokesViewModel mViewModel;
  JokesModel jokes = new JokesModel();
  JokesAdapter adapter;
  RecyclerView recyclerView;
  String jText;
 // public static JokesFragment newInstance() {
 //   return new JokesFragment();
 // }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_jokes, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mViewModel = new ViewModelProvider(this).get(JokesViewModel.class);
    recyclerView = view.findViewById(R.id.rv_joke);
    Button btnReload = view.findViewById(R.id.btn_reload);
    EditText etValue = view.findViewById(R.id.et_num);

    mViewModel.getJokes().observe(getViewLifecycleOwner(),jokesModel -> {
        adapter = new JokesAdapter(getContext(), Arrays.asList(jokesModel.getValue()));
        recyclerView.setAdapter(adapter);
    });



    btnReload.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        if(!etValue.getText().toString().isEmpty()){
          mViewModel.jokesValue.setValue(etValue.getText().toString());
          mViewModel.execute();
        }
        else{
          Toast.makeText(getContext(),"empty value",Toast.LENGTH_SHORT).show();
        }
      }
    });
  }

  private void initialData()
  {
    String text = "{ \"type\": \"success\", \"value\": [{ \"id\": 457, \"joke\": \"MySpace actually isn't your space, it's Chuck's (he just lets you use it).\", \"categories\": [\"nerdy\"] } ]  }";
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    jokes = gson.fromJson(text,JokesModel.class);
  }




  //@Override
  //public void onActivityCreated(@Nullable Bundle savedInstanceState) {
  //  super.onActivityCreated(savedInstanceState);
  //  mViewModel = new ViewModelProvider(this).get(JokesViewModel.class);
  //  // TODO: Use the ViewModel
  //}

}