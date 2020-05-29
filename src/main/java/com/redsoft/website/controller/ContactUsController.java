package com.redsoft.website.controller;

import com.redsoft.starters.jpa.page.PageParam;
import com.redsoft.starters.jpa.page.PageResult;
import com.redsoft.starters.own.util.result.JsonResult;
import com.redsoft.website.constant.$;
import com.redsoft.website.entity.ContactUs;
import com.redsoft.website.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QSort;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangyj
 * @date 2020/5/27 0027 17:55
 * @description 联系信息
 * @menu 联系信息
**/
@RestController
@RequestMapping("contact-us")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;
    /**
     * @author wangyj
     * @date 2020/5/27 0027 17:56
     * @description 获取列表
     * @param page:
     * @param size:
     * @param contactUs:
     * @return {@link JsonResult< PageResult< ContactUs>>}
    **/
    @GetMapping
    public JsonResult<PageResult<ContactUs>> list(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size, ContactUs contactUs) {
        PageResult<ContactUs> result = contactUsService
                .list(contactUs, PageParam.of(page, size, QSort.by($.contactUs.id.desc())));
        return JsonResult.ok(result);
    }
    /**
     * @author wangyj
     * @date 2020/5/27 0027 17:56
     * @description 新增
     * @param contactUs:
     * @return {@link JsonResult< Void>}
    **/
    @PostMapping
    public JsonResult<Void> add(ContactUs contactUs) {
        contactUsService.add(contactUs);
        return JsonResult.ok();
    }
    /**
     * @author wangyj
     * @date 2020/5/27 0027 17:56
     * @description 删除
     * @param id:
     * @return {@link JsonResult< Void>}
    **/
    @DeleteMapping("/{id}")
    public JsonResult<Void> delete(@PathVariable Integer id) {
        contactUsService.delete(id);
        return JsonResult.ok();
    }
}
