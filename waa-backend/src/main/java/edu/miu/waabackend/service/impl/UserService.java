package edu.miu.waabackend.service.impl;

;import edu.miu.waabackend.domain.User;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.UserDto;
import edu.miu.waabackend.repository.UserRepository;
import edu.miu.waabackend.service.IUserService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public UserService(UserRepository userRepository, DtoUtils dtoUtils) {
        this.userRepository = userRepository;
        this.dtoUtils = dtoUtils;
    }

    @Override
    public List<DTOEntity> lstGetAll() {
        try {
            return dtoUtils.convertToListDto(userRepository.findAll(), new UserDto());
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public DTOEntity GetByPK(Long id) {
        User userObj = userRepository.findById(id).orElse(null);
        if(userObj != null)
            return dtoUtils.convertToDto(userObj, new UserDto());

        return null;
    }

    @Override
    public int Insert(DTOEntity userDto) {
        try {
            User userObj = (User) dtoUtils.convertToEntity(userDto, new User());
            userRepository.save(userObj);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Update(DTOEntity userDto) {
        try {
            User userObj = (User) dtoUtils.convertToEntity(userDto, new User());
            userRepository.save(userObj);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Delete(Long id) {
        try {
            userRepository.deleteById(id);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }
}
