package com.smart.rms.architecture.mapper;

import com.smart.rms.architecture.model.TbBizCode;
import java.util.List;
import java.util.Map;

public interface BizCodeMapper {
    List<TbBizCode> findAll();
    TbBizCode findById(Long bizSeq);
    int save(TbBizCode code);
    int update(TbBizCode code);
    int deleteById(Long bizSeq);
    int countChildren(Long bizSeq);
    int updateOrder(TbBizCode code);
    int countBySysCode(TbBizCode code);
    List<Map<String, Object>> findFlatSystemList();

}