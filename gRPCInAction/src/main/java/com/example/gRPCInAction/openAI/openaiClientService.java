package com.example.gRPCInAction.openAI;

import io.grpc.Channel;

import openai_service.OpenaiService;
import openai_service.openai_serviceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class openaiClientService {
    private final openai_serviceGrpc.openai_serviceBlockingStub blockingStub;

    @Autowired
    public openaiClientService(Channel channel) {
        this.blockingStub = openai_serviceGrpc.newBlockingStub(channel);
    }

    public String pingServer(String requestBody) {
        OpenaiService.MyRequest request = OpenaiService.MyRequest.newBuilder().setInput(requestBody).build();
        System.out.println(request.getInput());
        OpenaiService.MyResponse response = blockingStub.openaiMethod(request);
        return response.getOutput();
    }

}
