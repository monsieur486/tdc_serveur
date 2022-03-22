package com.mr486.tdc.serveur.model;

import com.google.gson.Gson;
import lombok.Data;

@Data
public class Ping {
  private static final Gson GSON = new Gson();

  private Integer code;
  private String content;

  public String toJson(){
    return GSON.toJson(this, Ping.class);
  }

  public Ping(Integer code, String content){
    this.code = code;
    this.content = content;
  }

}
