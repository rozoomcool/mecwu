package ru.mecwu.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mecwu.core.entity.CafeEntity;

@Repository
public interface CafeRepo extends CrudRepository<CafeEntity, Long> {
    public CafeEntity findByTitle(String title);
    public CafeEntity findByEmail(String email);
}
