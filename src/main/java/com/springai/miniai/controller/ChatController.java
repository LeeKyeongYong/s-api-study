package com.springai.miniai.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChatController {

    private final ChatClient talkAi;

    @Autowired
    public ChatController(ChatClient talkAi){
        this.talkAi = talkAi;
    }

    @GetMapping("/OpenAi/generate")
    public Map generate(@RequestParam(value="msg",defaultValue = "Tell me a joke")String msg){
        return Map.of("generation",talkAi.call(msg));
    }

}
