package com.jbground.community.web.address;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jbground.community.model.Address;
import com.jbground.community.web.address.dao.AddressDao;

@Service
public class AddressService {
	
	private final static Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	
	@Resource(type = AddressDao.class)
	private AddressDao addressDao;
	
	public int insertAddress(Address address) {

		if(address.getZipcode() != null && !address.getZipcode().isEmpty() && address.getAdd1() != null && !address.getAdd1().isEmpty()) {
			return addressDao.insertAddress(address);
		}

		return 0;		
		
	}

}
