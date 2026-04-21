package com.demo.langchain4j.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;


//public interface ConsultantService {
//
//    //用于聊天的方法,message为用户输入的内容
//    public String chat(String message);
//
//}

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
//        chatMemory = "chatMemory",//配置会话记忆对象，
        chatMemoryProvider = "chatMemoryProvider",//配置会话记忆对象提供者
        contentRetriever = "contentRetriever"//配置向量数据库检索对象
)
public interface ConsultantService {

    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chat(@MemoryId String memoryId, @UserMessage String message);
}

