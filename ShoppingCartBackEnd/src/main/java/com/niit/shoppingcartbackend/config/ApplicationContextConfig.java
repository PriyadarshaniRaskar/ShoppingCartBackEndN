package com.niit.shoppingcartbackend.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcartbackend.dao.CartDAO;
import com.niit.shoppingcartbackend.dao.CartDAOImpl;
import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.CategoryDAOImpl;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.ProductDAOImpl;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAOImpl;
import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.dao.UserDAOImpl;
import com.niit.shoppingcartbackend.dao.UserDetailsDAO;
import com.niit.shoppingcartbackend.dao.UserDetailsDAOImpl;
import com.niit.shoppingcartbackend.model.Cart;
import com.niit.shoppingcartbackend.model.Category;
import com.niit.shoppingcartbackend.model.Product;
import com.niit.shoppingcartbackend.model.Supplier;
import com.niit.shoppingcartbackend.model.User;
import com.niit.shoppingcartbackend.model.UserDetails;

@Configuration
@ComponentScan("com.niit.shoppingcartbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");

		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		return dataSource;

	}

	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getDataSource());

		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "cartDAO")
	public CartDAO getCartDao(SessionFactory sessionFactory) {
		return new CartDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDao(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "userDetailsDAO")
	public UserDetailsDAO getUserDetailsDao(SessionFactory sessionFactory) {
		return new UserDetailsDAOImpl(sessionFactory);
	}

}
