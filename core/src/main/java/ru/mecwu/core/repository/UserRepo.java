package ru.mecwu.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mecwu.core.entity.UserEntity;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    public UserEntity findByNickname(String nickname);
    public UserEntity findByEmail(String email);
}
