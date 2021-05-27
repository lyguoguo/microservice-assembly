package com.example.sharding.web;

import com.example.sharding.entity.Address;
import com.example.sharding.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddressController {

	@Autowired
	private AddressMapper addressMapper;

	@RequestMapping("/address/save")
	@ResponseBody
	public String save() {
		for (int i = 0; i <2 ; i++) {
			Address address= Address.builder()
					.code("code_"+i)
					.name("name_"+i)
					.pid(i+"")
					.type(0)
					.lit(i%2==0?1:2)
					.build();
			addressMapper.save(address);
		}
		return "success";
	}
	
	@RequestMapping("/address/get/{id}")
	@ResponseBody
	public Address get(@PathVariable Long id) {
		return addressMapper.get(id);
	}
}
