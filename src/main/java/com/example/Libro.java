package com.example;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "libro")
public class Libro {

    @DynamoDBHashKey
    private int id;

    @DynamoDBAttribute
    private String titulo;

    @DynamoDBAttribute
    private String autor;

    @DynamoDBAttribute
    private String serie;

    @DynamoDBAttribute
    private String content;
    
    @DynamoDBAttribute
    private String img;

    public Libro() {
    }

    public Libro(int id, String titulo, String content) {
        this.id = id;
        this.titulo = titulo;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}