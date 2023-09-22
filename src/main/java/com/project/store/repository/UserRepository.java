package com.project.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.store.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();
	
	Optional<User> findById(Long userId);

	@Query("select u from User u"
		      + " left join fetch u.authorities"
		      + " where u.login = :username")
	User findByUsername(String login);
}
