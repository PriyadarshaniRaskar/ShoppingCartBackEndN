package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.model.UserDetails;

public interface UserDetailsDAO {

	public List<UserDetails> listUserDetails();

	public UserDetails get(String id);

	public void saveOrUpdate(UserDetails userDetails);

	public void delete(String id);

}
