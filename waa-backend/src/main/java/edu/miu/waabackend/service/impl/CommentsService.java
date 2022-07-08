package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.repository.CommnetsRepository;
import edu.miu.waabackend.service.ICommentsService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService implements ICommentsService {

    private CommnetsRepository commnetsRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public CommentsService(CommnetsRepository commnetsRepository, DtoUtils dtoUtils) {
        this.commnetsRepository = commnetsRepository;
        this.dtoUtils = dtoUtils;
    }
}
