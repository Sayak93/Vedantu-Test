package com.example.vedantuBackend.repository;

import com.example.vedantuBackend.models.Account;
import com.example.vedantuBackend.models.Inventory;
import com.example.vedantuBackend.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository("Repo")
public class RepoImpl implements Repo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean placeOrder(Orders payload){

        Inventory productDetails = mongoTemplate.findOne(Query.query(Criteria.where("productId").is(payload.productId)), Inventory.class);
        if(productDetails != null){
            if(productDetails.stocks >= payload.quantity){
                mongoTemplate.findAndModify(Query.query(Criteria.where("productId").is(payload.productId)), Update.update("stocks", productDetails.stocks-payload.quantity),Inventory.class );
                mongoTemplate.save(payload);
                mongoTemplate.findAndModify(Query.query(Criteria.where("userId").is(payload.userId)), Update.update("orderId", "someRandomGeneratedID"),Account.class );
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }

    }
}
