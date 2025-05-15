package com.smart.rms.system.controller;

import com.smart.rms.system.model.TbCommonCode;
import com.smart.rms.system.service.CommonCodeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/common-code")
public class CommonCodeController {

    private final CommonCodeService service;

    public CommonCodeController(CommonCodeService service) {
        this.service = service;
    }

    @GetMapping
    public List<TbCommonCode> getList(@ModelAttribute TbCommonCode code) {
        return service.findByKeyword(code);
    }

    // 2) 단건조회
    //    GET /api/common-code/{id}
    @GetMapping("/{id}")
    public TbCommonCode getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    // 3) 등록
    //    POST /api/common-code
    @PostMapping
    public int insert(@RequestBody TbCommonCode code) {
        return service.insert(code);
    }

    // 4) 수정
    //    PUT /api/common-code/{id}
    @PutMapping("/{id}")
    public int update(@PathVariable Long id, @RequestBody TbCommonCode code) {
        code.setCodeSeq(id);
        return service.update(code);
    }

    // 5) 삭제 (논리)
    //    DELETE /api/common-code/{id}
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    // 6) 정렬 순서 일괄 업데이트 (Drag&Drop 후)
    //    PUT /api/common-code/order
    @PutMapping("/order")
    public int updateOrderBatch(@RequestBody List<TbCommonCode> list) {
        return service.updateOrderBatch(list);
    }

    // 그룹별 공통코드 Map 조회
    @GetMapping("/common-codes")
    public Map<String, List<TbCommonCode>> getCommonCodes(HttpServletRequest request) {
        return (Map<String, List<TbCommonCode>>) request.getServletContext().getAttribute("commonCode");
    }


}
