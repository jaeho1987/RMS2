package com.smart.rms.architecture.service;

import com.smart.rms.architecture.model.TbProcFunctionMap;
import com.smart.rms.architecture.mapper.ProcFunctionMapMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcFunctionMapService {

    private final ProcFunctionMapMapper procFunctionMapMapper;

    public List<TbProcFunctionMap> findByKeyword(TbProcFunctionMap procFunctionMap) {
        return procFunctionMapMapper.findByKeyword(procFunctionMap);
    }

    public TbProcFunctionMap findById(Long id) {
        return procFunctionMapMapper.findById(id);
    }

    public TbProcFunctionMap insert(TbProcFunctionMap procFunctionMap) {
        procFunctionMapMapper.insert(procFunctionMap);
        return  procFunctionMapMapper.findById(procFunctionMap.getProcFncSeq());
    }

    public int update(TbProcFunctionMap procFunctionMap) {
        return procFunctionMapMapper.update(procFunctionMap);
    }

    public int  delete(Long id) {
        return procFunctionMapMapper.deleteById(id);
    }

    public int updateOrderBatch(List<TbProcFunctionMap> list) {
        if (list == null || list.isEmpty()) return 0;
        int count = 0;
        for (TbProcFunctionMap item : list) {
            count += procFunctionMapMapper.updateOrderOne(item);
        }
        return count;
    }
}
