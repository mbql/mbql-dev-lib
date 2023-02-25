package com.mbql.mongo.demo;

import com.mongodb.bulk.BulkWriteInsert;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.result.UpdateResult;
import com.mbql.mongo.demo.entity.User;
import com.mbql.mongo.demo.entity.UserDetails;
import org.bson.BsonValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class SpringbootMongoDemoApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void add() {

        User user = User.builder().id(2L).username("mbql").password("123456").build();

        User res = mongoTemplate.save(user);

        System.out.println(res);
    }

    @Test
    void addBatch() {

        User user = User.builder().id(1L).username("mbql").password("123456").build();
        User user1 = User.builder().id(2L).username("sueno").password("123456").build();
        User user2 = User.builder().id(3L).username("tom").password("123456").build();
        User user3 = User.builder().id(4L).username("slp").password("123456").build();
        User user4 = User.builder().id(5L).username("ssd").password("123456").build();

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.ORDERED, User.class);
        BulkOperations operations = bulkOps.insert(users);
        BulkWriteResult execute = operations.execute();
        List<BsonValue> collect = execute.getInserts().stream().map(BulkWriteInsert::getId)
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    void addBatchUserDetails() {

        UserDetails user = UserDetails.builder().id(1L).userId(1L).sex(1).phone("1721221291").build();
        UserDetails user1 = UserDetails.builder().id(2L).userId(2L).sex(0).phone("1721221231").build();
        UserDetails user2 = UserDetails.builder().id(3L).userId(3L).sex(1).phone("1721221221").build();
        UserDetails user3 = UserDetails.builder().id(4L).userId(4L).sex(0).phone("1721221241").build();
        UserDetails user4 = UserDetails.builder().id(5L).userId(5L).sex(1).phone("1721221281").build();

        List<UserDetails> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.ORDERED, UserDetails.class);
        BulkOperations operations = bulkOps.insert(users);
        BulkWriteResult execute = operations.execute();
        List<BsonValue> collect = execute.getInserts().stream().map(BulkWriteInsert::getId)
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    void findAll() {

        // List<User> list = mongoTemplate.findAll(User.class);

        // AggregationExpression.from(MongoExpression.create(""));
        // Field field = Fields.field("sex", "phone");
        //
        // new GroupOperation(Fields.from(Fields.field("")));

        ;

        Long pageIndex = 2L;
        Long pageSize = 3L;

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.skip((pageIndex -1) * pageSize),
                Aggregation.limit(pageSize),
                Aggregation.sort(Sort.sort(UserDetails.class).by(UserDetails::getId).descending()));

        // BucketOperation bucketOperation = new BucketOperation(field);
        AggregationResults<UserDetails> aggregate = mongoTemplate.aggregate(aggregation,
                UserDetails.class, UserDetails.class);

        System.out.println(aggregate.getMappedResults());

        // System.out.println(list);

    }

    @Test
    void update() {

        // ExecutableUpdateOperation.ExecutableUpdate<User> update = mongoTemplate.update(User.class);
        // UpdateResult result = update.apply(BasicUpdate.update("_id", 1L)
        //         .set("username", "mbql")).all();

        Criteria criteria = Criteria.where("username").is("mbql");

        UpdateResult result = mongoTemplate.updateFirst(Query.query(criteria), BasicUpdate.
                update("password", "lllll"), User.class);

        System.out.println(result.getModifiedCount());

    }

    @Test
    void delete() {

        // User result = mongoTemplate.findAndRemove(Query.
        //         query(Criteria.where("_id").is(2L)), User.class);

        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.ORDERED, User.class);
        BulkOperations operations = bulkOps.remove(Query.query(Criteria.where("_id").is(1L)));
        BulkWriteResult execute = operations.execute();
        System.out.println(execute.getDeletedCount());
    }



}
