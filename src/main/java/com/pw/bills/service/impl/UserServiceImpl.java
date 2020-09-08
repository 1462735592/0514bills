package com.pw.bills.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.bills.mapper.UserMapper;
import com.pw.bills.pojo.User;
import com.pw.bills.pojo.UserExample;
import com.pw.bills.pojo.UserExample.Criteria;
import com.pw.bills.service.UserService;
import com.pw.bills.utils.Result;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User queryUserById(Integer id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	@Override
	public User queryUserByLoginname(String loginname) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginnameEqualTo(loginname);
		List<User> userList = userMapper.selectByExample(example );
		if(userList!=null&&userList.size()>0)
		return userList.get(0);
		return null;
	}
	@Override
	public int addUser(User user) {
		int row = userMapper.insertSelective(user);
		return row;
	}
	@Override
	public Result updateUser(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginnameEqualTo(user.getLoginname());
		int row = userMapper.updateByExampleSelective(user, example );
		if(row>0) {
			return Result.ok();
		}
		return Result.build(409, "更新失败");
	}

}
