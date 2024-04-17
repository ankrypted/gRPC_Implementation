package com.example.gRPCInAction.article;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name="articleEntry")
public class Article {
    @Id
    @UuidGenerator
    private String articleId;
    private String articleContent;

    public Article() {
    }

    public Article(String articleContent) {
        this.articleContent = articleContent;
    }

    public Article(String articleId, String articleContent) {
        this.articleId = articleId;
        this.articleContent = articleContent;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleContent='" + articleContent + '\'' +
                '}';
    }
}
