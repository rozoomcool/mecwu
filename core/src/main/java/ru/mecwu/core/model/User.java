package ru.mecwu.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String nickname;
    private String email;
    private Set<Long> comments;
    private Set<Long> grades;
    private Role role;
    private Status status;
    private Date createdAt;

}
