package org.wecancoeit.reviews.repo;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.ReviewCategory;

public interface ReviewCategoryRepository extends CrudRepository<ReviewCategory, Long> {
}
