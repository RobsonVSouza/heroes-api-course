package com.projectdio.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.projectdio.heroesapi.constans.HeroContant.REGION_DYNAMO;
import static com.projectdio.heroesapi.constans.HeroContant.ENDPOINT_DYNAMO;


public class HeroesData {

    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO    ))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table_Demo");

        Item hero1 = new Item()
                .withPrimaryKey("id", "1")
                .withString("name","Howard, o pato")
                .withString("universe", "Marvel")
                .withNumber("films", 5);

        Item hero2 = new Item()
                .withPrimaryKey("id", "2")
                .withString("name","Batman")
                .withString("universe", "Dc comics")
                .withNumber("films", 4);

        Item hero3 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name","Thor")
                .withString("universe", "Marvel")
                .withNumber("films", 3);

        PutItemOutcome outcome1 = table.putItem(hero1);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);

    }
}
