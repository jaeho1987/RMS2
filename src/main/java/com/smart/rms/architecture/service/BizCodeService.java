package com.smart.rms.architecture.service;

import com.smart.rms.architecture.mapper.BizCodeMapper;
import com.smart.rms.architecture.model.TbBizCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BizCodeService {

    private final BizCodeMapper bizCodeMapper;

    public BizCodeService(BizCodeMapper bizCodeMapper) {
        this.bizCodeMapper = bizCodeMapper;
    }

    // 전체 목록
    public List<TbBizCode> findAll() {
        return bizCodeMapper.findAll();
    }

    // 단건 조회
    public TbBizCode findById(Long id) {
        return bizCodeMapper.findById(id);
    }

    // 등록
    public int save(TbBizCode code) {
        return bizCodeMapper.save(code);
    }

    // 수정
    public int update(TbBizCode code) {
        return bizCodeMapper.update(code);
    }

    // 삭제 (논리 삭제)
    public int deleteById(Long id) {
        int childCount = bizCodeMapper.countChildren(id);
        if (childCount > 0) {
            throw new IllegalStateException("하위 항목이 존재하여 삭제할 수 없습니다.");
        }
        return bizCodeMapper.deleteById(id);
    }

    public void updateOrder(List<TbBizCode> list, String modId) {
        for (TbBizCode code : list) {
            code.setModId(modId);
            bizCodeMapper.updateOrder(code);
        }
    }
    public boolean isSysCodeExists(TbBizCode code) {
        return bizCodeMapper.countBySysCode(code) > 0;
    }
    public List<Map<String, Object>> findFlatSystemList() {
        return bizCodeMapper.findFlatSystemList();
    }
}
