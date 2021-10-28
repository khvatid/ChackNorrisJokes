package com.to_panelka.cnJokes.models;

public class JokeModel {
  String id;
  String joke;

  public JokeModel(String id, String joke) {
    this.id = id;
    this.joke = joke;
  }

  public JokeModel() {
  }

  public String getId() {
    return id;
  }

  public String getJoke() {
    return joke;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setJoke(String joke) {
    this.joke = joke;
  }


}
