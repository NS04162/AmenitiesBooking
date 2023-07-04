package com.citi.amenitiesbooking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.citi.amenitiesbooking.entity.CustomerLoginInfo;

@Mapper
public interface CustomerLoginMapper {
	
	@Select("select * from CustomerLoginInfo where userName = CustUserName")
	CustomerLoginInfo login(String CustUserName);

}
