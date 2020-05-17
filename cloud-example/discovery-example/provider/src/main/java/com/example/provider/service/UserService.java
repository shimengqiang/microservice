package com.example.provider.service;

import com.example.provider.dao.model.Users;
import java.util.List;

/**
 * @author smq
 */

public interface UserService {

	List<Users> findAll();
}
