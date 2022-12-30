package ru.mecwu.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mecwu.core.entity.CommentEntity;
import ru.mecwu.core.entity.UserEntity;

import java.util.Iterator;

@Repository
public interface CommentRepo extends CrudRepository<CommentEntity, Long> {
    Iterator<CommentEntity> findAllByAuthor(String name);
}
