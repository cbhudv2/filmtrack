package me.cbhud.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import me.cbhud.model.Review;

import java.util.List;

@Dependent
public class ReviewRepository {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public List<Review> findAll() {
        return entityManager.createQuery("SELECT r FROM Review r", Review.class).getResultList();
    }

    @Transactional
    public Review findById(Integer id) {
        return entityManager.find(Review.class, id);
    }

    @Transactional
    public void save(Review review) {
        if (review.getId() == null) {
            entityManager.persist(review);
        } else {
            entityManager.merge(review);
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        Review review = findById(id);
        if (review != null) {
            entityManager.remove(review);
        }
    }

    @Transactional
    public List<Review> findAllReviewsByUserId(Integer userId) {
        return entityManager.createNamedQuery(Review.GET_ALL_REVIEWS_PROFILE, Review.class)
                .setParameter("id", userId)
                .getResultList();
    }

    @Transactional
    public List<Review> findAllReviewsByMovieId(Integer movieId) {
        return entityManager.createNamedQuery(Review.GET_ALL_REVIEWS_MOVIE, Review.class)
                .setParameter("id", movieId)
                .getResultList();
    }


}
