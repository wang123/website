package com.redsoft.website.controller;

import com.redsoft.starters.jpa.page.PageParam;
import com.redsoft.starters.jpa.page.PageResult;
import com.redsoft.starters.own.util.result.JsonResult;
import com.redsoft.website.constant.$;
import com.redsoft.website.entity.Solution;
import com.redsoft.website.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QSort;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangyj
 * @date 2020/5/27 0027 17:54
 * @description 解决方案
 * @menu 解决方案
**/
@RestController
@RequestMapping("solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;

    /**
     * @author wangyj
     * @date 2020/5/27 0027 17:55
     * @description 获取列表
     * @param page:
     * @param size:
     * @param solution:
     * @return {@link JsonResult< PageResult< Solution>>}
    **/
    @GetMapping
    public JsonResult<PageResult<Solution>> list(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size, Solution solution) {
        PageResult<Solution> result = solutionService
                .list(solution, PageParam.of(page, size, QSort.by($.solution.display.asc())));
        return JsonResult.ok(result);
    }
    /**
     * @author wangyj
     * @date 2020/5/27 0027 17:55
     * @description 新增
     * @param solution:
     * @return {@link JsonResult< Void>}
    **/
    @PostMapping
    public JsonResult<Void> add(Solution solution) {
        solutionService.add(solution);
        return JsonResult.ok();
    }
    /**
     * @author wangyj
     * @date 2020/5/27 0027 17:55
     * @description 修改
     * @param id:
     * @param solution:
     * @return {@link JsonResult< Void>}
    **/
    @PutMapping("/{id}")
    public JsonResult<Void> update(@PathVariable Integer id, Solution solution) {
        solution.setId(id);
        solutionService.update(solution);
        return JsonResult.ok();
    }
    /**
     * @author wangyj
     * @date 2020/5/27 0027 17:55
     * @description 删除
     * @param id:
     * @return {@link JsonResult< Void>}
    **/
    @DeleteMapping("/{id}")
    public JsonResult<Void> delete(@PathVariable Integer id) {
        solutionService.delete(id);
        return JsonResult.ok();
    }
    /**
     * @author wangyj
     * @date 2020/5/27 0027 17:55
     * @description 获取详情
     * @param id:
     * @return {@link JsonResult< Solution>}
    **/
    @GetMapping("/{id}")
    public JsonResult<Solution> getById(@PathVariable Integer id) {
        return JsonResult.ok(solutionService.getById(id));
    }
}
