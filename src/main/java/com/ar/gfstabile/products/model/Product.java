package com.ar.gfstabile.products.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")
public record Product(@Id @Field("_id") ObjectId id, @Field("code") String code, @Field("name") String name,
        @Field("description") String description, @Field("price") Double price) {

}
