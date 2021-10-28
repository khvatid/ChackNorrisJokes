package com.to_panelka.cnJokes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.to_panelka.cnJokes.R;
import com.to_panelka.cnJokes.models.JokeModel;
import com.to_panelka.cnJokes.models.JokesModel;
import java.util.List;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.ViewHolder> {

  private final LayoutInflater inflater;
  private List<JokeModel> jokes;

  public void setJokes(List<JokeModel> jokes) {
    this.jokes = jokes;
  }

  public JokesAdapter(Context context, List<JokeModel> jokes) {
    this.jokes = jokes;
    this.inflater = LayoutInflater.from(context);
  }

  @Override
  public JokesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View view = inflater.inflate(R.layout.item_joke,parent,false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(JokesAdapter.ViewHolder holder, int position) {
    JokeModel jokeModel = jokes.get(position);
    holder.jokeTextView.setText(jokeModel.getJoke());
    holder.jokeIdTextView.setText("id - "+jokeModel.getId());
  }
  @Override
  public int getItemCount(){
    return jokes.size();
  }
  public static class ViewHolder extends RecyclerView.ViewHolder{
    final TextView jokeTextView;
    final TextView jokeIdTextView;
    ViewHolder(View view){
      super(view);
      jokeIdTextView = view.findViewById(R.id.tv_joke_id);
      jokeTextView = view.findViewById(R.id.tv_joke);
    }


  }
}

