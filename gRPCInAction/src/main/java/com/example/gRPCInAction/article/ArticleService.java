package com.example.gRPCInAction.article;
import com.example.grpc.Example;
import com.example.grpc.articleServiceGrpc.articleServiceImplBase;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
public class ArticleService extends articleServiceImplBase {
//    private final ArticlePrincipal articlePrincipal;
//
//    @Autowired
//    public ArticleService(ArticlePrincipal articlePrincipal) {
//        this.articlePrincipal = articlePrincipal;
//    }

//    ArticlePrincipal articlePrincipal = new ArticlePrincipal();

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void articleMethod(Example.articleRequest request, StreamObserver<Example.articleResponse> responseObserver) {
//        super.articleMethod(request, responseObserver);
        System.out.println("Inside Article Method");

        System.out.println(request.getMessage());

        Example.articleResponse.Builder response = Example.articleResponse.newBuilder();

        if(request.getMessage().equals("Ankesh")) {
            response.setReply("Received Successfully");
            Article article = new Article(request.getMessage());
            this.articleRepository.save(article);
            System.out.println("Added to db");
        }
        else {
            response.setReply("Failure :(");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

}


