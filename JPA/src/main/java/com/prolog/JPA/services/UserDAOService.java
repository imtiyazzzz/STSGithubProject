package com.prolog.JPA.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.prolog.JPA.entities.User;

@Repository
@Transactional
public class UserDAOService {
	private static final Logger log = LoggerFactory.getLogger(UserDAOService.class);
	@PersistenceContext
	private EntityManager entityManager;

	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}

	public long update(User user) {
		entityManager.merge(user);
		return user.getId();
	}

	public User findById(Long id) {
		return entityManager.find(User.class, id);
	}

	public List<User> findAll() {
		TypedQuery<User> namedQuery = entityManager.createNamedQuery("find_all_user", User.class);
		return namedQuery.getResultList();
	}

	public void deleteById(Long id) {
		User user = findById(id);
		entityManager.remove(user);
	}

	public void entityManagerPersist() {
		User user = new User("imtiyaz", "Admin");
		entityManager.persist(user);
		user.setName("Sheikh");
		log.info("User name is updated after persist call");
	}
}
