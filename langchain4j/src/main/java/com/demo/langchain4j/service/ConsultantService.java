package com.demo.langchain4j.service;
import dev.langchain4j.service.AiServices;


public interface ConsultantService {

    //用于聊天的方法,message为用户输入的内容
    public String chat(String message);

}
