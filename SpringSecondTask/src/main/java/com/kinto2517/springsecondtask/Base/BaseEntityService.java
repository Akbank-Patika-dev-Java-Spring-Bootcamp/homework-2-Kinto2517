package com.kinto2517.springsecondtask.Base;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, R extends JpaRepository<E,Long>> {

    private final R repository;

    public E save(E entity) {

        BaseAdditionalFields additionalFields = entity.getAdditionalFields();
        if (additionalFields == null) {
            additionalFields = new BaseAdditionalFields();
        }

        if (entity.getId() == null) {
            additionalFields.setCreateDate(LocalDateTime.now());
        }

        additionalFields.setUpdateDate(LocalDateTime.now());

        entity.setAdditionalFields(additionalFields);

        entity = repository.save(entity);

        return entity;
    }

    public List<E> findAll() {
        return repository.findAll();
    }
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public void delete(E entity) {
        repository.delete(entity);
    }

}
