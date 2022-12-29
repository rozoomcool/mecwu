package ru.mecwu.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mecwu.core.entity.CommentEntity;

@Repository
public interface CommentRepo extends CrudRepository<CommentEntity, Long> {
}
