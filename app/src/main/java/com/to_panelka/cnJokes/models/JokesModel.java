package com.to_panelka.cnJokes.models;

public class JokesModel {

  String type;
  JokeModel[] value;

  public JokesModel(String type, JokeModel[] value) {
    this.type = type;
    this.value = value;
  }

  public JokesModel() {
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setValue(JokeModel[] value) {
    this.value = value;
  }

  public String getType() {
    return type;
  }

  public JokeModel[] getValue() {
    return value;
  }

}
