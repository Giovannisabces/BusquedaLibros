package com.example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler implements RequestHandler<Request, Object> {
    @Override
    public Object handleRequest(Request request, Context context) {

        AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(db);
        Libro libro = null;

        switch (request.getHttpMethod()) {
            case "GET":
                if (request.getId() == 0) {
                    List<Libro> libros = new ArrayList<>();
                    libros = mapper.scan(Libro.class, new DynamoDBScanExpression());
                    return libros;
                } else {
                    libro = mapper.load(Libro.class, request.getId());
                    return libro;
                }
            case "POST":
                libro = request.getLibro();
                mapper.save(libro);
                return libro;
            case "DELETE":
                libro = mapper.load(Libro.class, request.getId());
                if (libro != null)
                    mapper.delete(libro);
                return libro;
        }
        return null;
    }
}