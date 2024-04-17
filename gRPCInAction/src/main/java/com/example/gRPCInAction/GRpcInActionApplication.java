package com.example.gRPCInAction;
import com.example.gRPCInAction.article.ArticleService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("com.example.gRPCInAction.article")
//@ComponentScan({"com.example.gRPCInAction.article"})
public class GRpcInActionApplication {

//    private final ArticlePrincipal articlePrincipal;
//
//    public GRpcInActionApplication(ArticlePrincipal articlePrincipal) {
//        this.articlePrincipal = articlePrincipal;
//    }
    private static ArticleService articleService;

    @Autowired
    public GRpcInActionApplication(ArticleService articleService) {
        this.articleService = articleService;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(GRpcInActionApplication.class, args);
        Server server = ServerBuilder.forPort(9090).addService(articleService).build();
        server.start();
        System.out.println("Server started at " + server.getPort());
        server.awaitTermination();

	}










}
