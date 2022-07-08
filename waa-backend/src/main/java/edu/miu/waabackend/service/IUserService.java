package edu.miu.waabackend.service;
;
import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface IUserService {
    public List<DTOEntity> lstGetAll();
    public DTOEntity GetByPK(Long id);
    public int Insert(DTOEntity userDto);
    public int Update(DTOEntity userDto);
    public int Delete(Long id);
}
