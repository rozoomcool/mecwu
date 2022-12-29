package ru.mecwu.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mecwu.core.entity.CommentEntity;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.CommentNotFoundException;
import ru.mecwu.core.repository.CafeRepo;
import ru.mecwu.core.repository.CommentRepo;
import ru.mecwu.core.repository.UserRepo;

import java.util.Iterator;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CafeRepo cafeRepo;

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
        UserEntity userEntity = userRepo.findByNickname(nickname);
        userEntity.addCommentId(commentEntity.getId());
        commentRepo.save(commentEntity);
        userRepo.save(userEntity);
    }
    public Iterator<CommentEntity> getAllUserComments(Long userId){
        return (Iterator<CommentEntity>) commentRepo.findAllById(userRepo.findById(userId).get().getComments());
    }
}
