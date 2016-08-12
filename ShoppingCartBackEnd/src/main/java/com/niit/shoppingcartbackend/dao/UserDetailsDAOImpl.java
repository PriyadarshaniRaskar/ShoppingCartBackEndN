package com.niit.shoppingcartbackend.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.UserDetails;

@Repository("userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
	}

	@Transactional
	public void delete(String id) {
		UserDetails userDetailsToDelete = new UserDetails();
		userDetailsToDelete.setUserId(id);
		sessionFactory.getCurrentSession().delete(userDetailsToDelete);
	}

	@Transactional
	public UserDetails get(String id) {
		String hql = "from User where userProductid =" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked" })
		List<UserDetails> listUserDetails = ((Criteria) query).list();
		if (listUserDetails != null && !listUserDetails.isEmpty()) {
			return listUserDetails.get(0);
		}
		return null;

	}

	@Transactional
	@SuppressWarnings({ "unchecked", "deprecation" })

	public List<UserDetails> listUserDetails() {
		List<UserDetails> listUserDetails = (List<UserDetails>) sessionFactory.getCurrentSession().createCriteria(UserDetails.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUserDetails;
	}

}
