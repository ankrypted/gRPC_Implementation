package com.example.gRPCInAction;
//import com.example.gRPCInAction.article.ArticleService;
import com.example.gRPCInAction.openAI.openaiClientService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
//@EnableJpaRepositories("com.example.gRPCInAction.article")
//@ComponentScan({"com.example.gRPCInAction.article"})
public class GRpcInActionApplication {

//    private final ArticlePrincipal articlePrincipal;
//
//    public GRpcInActionApplication(ArticlePrincipal articlePrincipal) {
//        this.articlePrincipal = articlePrincipal;
//    }
//    private static ArticleService articleService;
    private static openaiClientService openaiService;
    @Autowired
    public GRpcInActionApplication(openaiClientService openaiService) {
//        this.articleService = articleService;
        this.openaiService = openaiService;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(GRpcInActionApplication.class, args);
//        Server server = ServerBuilder.forPort(9090).addService(articleService).build();
//        server.start();
//        System.out.println("Server started at " + server.getPort());
//        server.awaitTermination();
	}


    @PostMapping("/pingGrpc")
    public String openAi(@RequestBody String messageRequest) {
        HashMap<String, String> response;
        String openaiResponse = this.openaiService.pingServer(messageRequest);
        return openaiResponse;

    }










}
