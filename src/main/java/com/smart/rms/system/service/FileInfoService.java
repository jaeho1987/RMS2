package com.smart.rms.system.service;

import com.smart.rms.system.model.TbFileInfo;
import com.smart.rms.system.mapper.FileInfoMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileInfoService {

    private final FileInfoMapper fileInfoMapper;

    public List<TbFileInfo> findByKeyword(TbFileInfo fileInfo) {
        return fileInfoMapper.findByKeyword(fileInfo);
    }

    public TbFileInfo findById(Long id) {
        return fileInfoMapper.findById(id);
    }

    public TbFileInfo insert(TbFileInfo fileInfo) {
        fileInfoMapper.insert(fileInfo);
        return  fileInfoMapper.findById(fileInfo.getFileSeq());
    }

    public int update(TbFileInfo fileInfo) {
        return fileInfoMapper.update(fileInfo);
    }

    public int  delete(Long id) {
        return fileInfoMapper.deleteById(id);
    }
}