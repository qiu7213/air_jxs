package com.example.demo.service;

import com.example.demo.po.MenuList;
import com.example.demo.po.User;
import com.example.demo.vo.UserPalceInfoVO;

import java.util.List;

public interface UserService {

    public User getUser(Integer id);

    public List<User> findall();

    public List<User> find5();

    public List<User> findByState( Integer state);

    public User exsisUser(String userName,String password);

    public boolean addUser(User user);

    public List<MenuList> userMenu(Integer id);

    public UserPalceInfoVO userPlaceInfo(Integer id);
}
