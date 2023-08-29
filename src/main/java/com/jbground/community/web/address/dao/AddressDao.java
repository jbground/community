package com.jbground.community.web.address.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jbground.community.model.Address;

@Mapper
public interface AddressDao {
	int insertAddress(Address address);
}
