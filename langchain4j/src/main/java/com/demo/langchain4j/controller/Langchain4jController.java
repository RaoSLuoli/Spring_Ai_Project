package com.demo.langchain4j.controller;

import com.demo.langchain4j.service.ConsultantService;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.internal.chat.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class Langchain4jController {

    @Autowired
    private OpenAiChatModel model;
    @Autowired
    private ConsultantService consultantService;

    /**脚本式/命令式写法，适合本地测试、简单的命令行工具或一次性任务**/
//    @GetMapping("/chat")
//    public String generation(@RequestParam(value = "message", defaultValue = "你好") String message) {
//        OpenAiChatModel  model = OpenAiChatModel.builder()
//                .apiKey("sk-b72e0ee0ac2f4964bc7ac7143a43cadf")
//                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
//                .modelName("qwen-plus")
//                .logRequests(true)//设置打印请求日志
//                .logResponses(true)//设置打印响应日志
//                .build();
//
//        SystemMessage systemMessage = new SystemMessage("你叫小张，你是一个10年丰富经验的Java工程师，计算机领域的大神级别人物");
//        UserMessage userMessage = new UserMessage(message);
//        return model.chat(systemMessage, userMessage).aiMessage().text();
//    }

//    /**Spring Boot 集成写法，适合构建 Web 服务、微服务或生产环境应用**/
//    @GetMapping("/chat")
//    public String generation(@RequestParam(value = "message", defaultValue = "你好") String message) {
//        SystemMessage systemMessage = new SystemMessage("你叫小张，你是一个10年丰富经验的Java工程师，计算机领域的大神级别人物");
//        UserMessage userMessage = new UserMessage(message);
//        String result = model.chat(message);
//        return result;
//    }

    /**使用AiServices工具类创建*/
    @RequestMapping("/chat")
    public String chat(String message){
        String result = consultantService.chat(message);
        return result;
    }

}
