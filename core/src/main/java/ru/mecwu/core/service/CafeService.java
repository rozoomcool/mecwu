package ru.mecwu.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mecwu.core.entity.CommentEntity;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.CommentNotFoundException;
import ru.mecwu.core.exception.UserAlreadyExistException;
import ru.mecwu.core.repository.CommentRepo;

@Service
public class CafeService {
    @Autowired
    private CommentRepo commentRepo;

    public CommentEntity getOne(Long id) throws CommentNotFoundException {
        CommentEntity commentEntity = commentRepo.findById(id).get();
        if(commentEntity == null){
            throw new CommentNotFoundException("Comment not found");
        }
        return commentEntity;
    }
    public void addComment(CommentEntity commentEntity, String nickname, Long cafeId) {
        commentEntity.setAuthor(nickname);
        commentEntity.setCafeId(cafeId);
        commentRepo.save(commentEntity);
    }
}
