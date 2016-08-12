package com.niit.shoppingcartbackend.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public void delete(String id) {
		User userToDelete = new User();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	@Transactional
	public User get(String id) {
		String hql = "from User where userProductid =" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked" })
		List<User> listUser = ((Criteria) query).list();
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;

	}

	@Transactional
	@SuppressWarnings({ "unchecked", "deprecation" })

	public List<User> listUser() {
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

}
