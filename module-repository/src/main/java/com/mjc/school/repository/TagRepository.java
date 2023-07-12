package com.mjc.school.repository;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.model.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<TagModel, Long> {
    @Query("select t from TagModel t join FETCH t.newsModelSet n where n.id =:newsId")
    List<TagModel> findAllByNewsModelId(@Param(value = "newsId") Long newsId);
}

