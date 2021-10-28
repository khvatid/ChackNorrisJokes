package com.to_panelka.cnJokes.ui.Jokes;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.to_panelka.cnJokes.models.JokesModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JokesViewModel extends ViewModel {

  private MutableLiveData<JokesModel> jokesModelMutableLiveData;
  public MutableLiveData<String> jokesValue = new MutableLiveData<>("0");
  private MutableLiveData<Boolean> isStarted = new MutableLiveData<>(false);

  public LiveData<JokesModel> getJokes(){
    if(jokesModelMutableLiveData == null){
      jokesModelMutableLiveData = new MutableLiveData<JokesModel>();
    }
    return jokesModelMutableLiveData;
  }

  public void execute(){
    if(!isStarted.getValue()){
      isStarted.postValue(true);
      Runnable runnable = new Runnable() {
        @Override
        public void run() {

          HttpURLConnection connection = null;
          BufferedReader bufferedReader = null;

          try {
            URL url = new URL("http://api.icndb.com/jokes/random/" + jokesValue.getValue());
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            JokesModel model = null;
            while ((line = bufferedReader.readLine())!=null){
              buffer.append(line+"\n");
              Log.d("Json: ", "> " +line);
              GsonBuilder gsonBuilder = new GsonBuilder();
              Gson gson = gsonBuilder.create();
              model = gson.fromJson(line,JokesModel.class);
            }

            jokesModelMutableLiveData.postValue(model);
            isStarted.postValue(false);

          } catch (MalformedURLException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      };
      Thread thread = new Thread(runnable);
      thread.start();
    }
  }


}