package com.mr486.tdc.serveur.model;

import com.google.gson.Gson;
import lombok.Data;

@Data
public class Message {
  private static final Gson GSON = new Gson();

  private Integer code;
  private String content;

  public String toJson(){
    return GSON.toJson(this, Message.class);
  }

  public Message(Integer code, String msg){
    this.code = code;
    this.content = msg;
  }

}
