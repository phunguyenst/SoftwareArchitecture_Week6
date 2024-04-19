package org.example.services;

import org.example.models.User;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {
    public static final String HASH_KEY = "User";
    @Autowired
    UserRepository userRepository;

    @Autowired
    private RedisTemplate template;

    public User save(User user){
        template.opsForHash().put(HASH_KEY,user.getId(),user);
        userRepository.save(user);
        return user;
    }
    public List<User> findAll() {
        return  template.opsForHash().values(HASH_KEY);
    }

    public User findUserById(Long id){
        return (User) template.opsForHash().get(HASH_KEY,id);
    }
    public Long deleteUser(Long id){
        template.opsForHash().delete(HASH_KEY,id);
        userRepository.deleteById(id);
        return id;
    }

    public User updateUser(User updateUser){
        Long userId = updateUser.getId();
        if(template.opsForHash().hasKey(HASH_KEY, userId)){
            template.opsForHash().put(HASH_KEY, userId, updateUser);
            return updateUser;
        }else{
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }
}
