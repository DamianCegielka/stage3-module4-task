package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.model.TagModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepository implements BaseRepository<NewsModel, Long> {

    private final DataSource dataSource = new DataSource();

    public NewsRepository() {
        dataSource.loadNewsFromDataSource();

    }

    private List<NewsModel> listNews = dataSource.getListNews();

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<NewsModel> readAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT n FROM NewsModel n", NewsModel.class)
                .getResultList();
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return Optional.ofNullable(entityManager.find(NewsModel.class, id));
    }

    @Override
    public NewsModel create(NewsModel entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public NewsModel update(NewsModel entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        NewsModel updatedModel = entityManager.find(NewsModel.class, entity.getId());
        updatedModel.setTitle(entity.getTitle());
        updatedModel.setContent(entity.getContent());
        updatedModel.setAuthorModel(entity.getAuthorModel());
        List<TagModel> tagsToUpdate = entity.getTagModels();
        if (!tagsToUpdate.isEmpty()) {
            updatedModel.setTagModels(tagsToUpdate);
        }
        entityManager.getTransaction().commit();
        return updatedModel;

    }

    @Override
    public boolean deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        if (readById(id).isPresent()) {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(NewsModel.class, id));
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id).isPresent();
    }

}
