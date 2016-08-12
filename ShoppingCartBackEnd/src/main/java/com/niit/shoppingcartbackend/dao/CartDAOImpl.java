package com.niit.shoppingcartbackend.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Transactional
	public void delete(String id) {
		Cart cartToDelete = new Cart();
		cartToDelete.setCartProductId(id);
		sessionFactory.getCurrentSession().delete(cartToDelete);
	}

	@Transactional
	public Cart get(String id) {
		String hql = "from Cart where cartProductid =" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked" })
		List<Cart> listCartProduct = ((Criteria) query).list();
		if (listCartProduct != null && !listCartProduct.isEmpty()) {
			return listCartProduct.get(0);
		}
		return null;

	}

	@Transactional
	@SuppressWarnings({ "unchecked", "deprecation" })

	public List<Cart> listCart() {
		List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCart;
	}

}
