package org.wecancoeit.reviews.repo;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
