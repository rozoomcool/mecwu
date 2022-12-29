package ru.mecwu.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mecwu.core.entity.UserEntity;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByNickname(String nickname);
    Optional<UserEntity> findByEmail(String email);
}
