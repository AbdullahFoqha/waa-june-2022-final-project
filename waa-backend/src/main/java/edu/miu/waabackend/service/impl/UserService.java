package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.repository.UserRepository;
import edu.miu.waabackend.service.IUserService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public UserService(UserRepository userRepository, DtoUtils dtoUtils) {
        this.userRepository = userRepository;
        this.dtoUtils = dtoUtils;
    }
}
