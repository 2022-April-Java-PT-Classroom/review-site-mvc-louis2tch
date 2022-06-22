package org.wecancoeit.reviews.repo;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
