package com.lookout.rediscachedemo;

import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/users")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());


    @Autowired
    RedisConnectionUtil redisConnectionUtil;

    @Autowired
    RedisConfig redisConfig;


    //@Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId) {
        LOG.info("Getting user with ID {}.", userId);
        Map<String, String> testMap = new HashMap<>();
        redisConnectionUtil.setTestMap(testMap);
        LOG.info("################ {} "+redisConnectionUtil.getTestMap());
       // RMap<Object, Object> userMap = redisConnectionUtil.getRedissonClient().getMap("user");
        RLocalCachedMap<Object, Object> userMap = redisConnectionUtil.getRedissonClient().getLocalCachedMap("user", LocalCachedMapOptions.defaults());
        return (User) userMap.get(userId);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        LOG.debug("From properties Configuration: {}  ",redisConfig);
        RMap<Object, Object> userMap = redisConnectionUtil.getRedissonClient().getMap("user");
        List<User> userList= new ArrayList<>();
        userMap.entrySet().forEach(entry->{

            User userFetched = (User)entry.getValue();
            userFetched.setId((String)entry.getKey());
            userList.add(userFetched);

        });
        return userList;
    }

    //@CachePut(value = "users", key = "#user.id")
    @PutMapping("/update")
    public User updatePersonByID(@RequestBody User user) {
        return user;
    }

    // @CacheEvict(value = "users", allEntries=true)
    @DeleteMapping("/{userId}")
    public void deleteUserByID(@PathVariable Long userId) {
        LOG.info("deleting person with id {}", userId);

    }


    //@CacheEvict(value = "users", allEntries=true)
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody User user) {
        LOG.info("creating user in redis {} ", user.getName());
        RedissonClient redissonClient = redisConnectionUtil.getRedissonClient();
        RMap<Object, Object> userMap = redissonClient.getMap("user");
        UUID uuid = UUID.randomUUID();
        LOG.info("UUID generated {}", uuid);
        user.setId(uuid.toString());
        userMap.put(uuid.toString(), user);
        return "created user with id:  "+uuid.toString();


    }

}
