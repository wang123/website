package com.redsoft.website.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.redsoft.starters.jpa.page.PageResult;
import com.redsoft.starters.own.util.util.BeanUtils;
import com.redsoft.starters.sysc.constant.SysConstants;
import com.redsoft.starters.sysc.util.AuthUtil;
import com.redsoft.website.constant.$;
import com.redsoft.website.dao.ContactUsRepository;
import com.redsoft.website.entity.ContactUs;
import com.redsoft.website.service.ContactUsService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
@Transactional
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public PageResult<ContactUs> list(ContactUs contactUs, Pageable pageable) {
        BooleanBuilder where = new BooleanBuilder($.contactUs.delFlag.eq(SysConstants.EXIST));
        if (StringUtils.hasText(contactUs.getName())) {
            where.and($.contactUs.name.contains(contactUs.getName()));
        }
        Page<ContactUs> results = contactUsRepository.findAll(where, pageable);
        return PageResult.of(results);
    }

    @Override
    public void add(ContactUs contactUs) {
        Assert.isNull(contactUs.getId(),"id必须为空");
        LocalDateTime dateTime = LocalDateTime.now();
        contactUs.setCreateTime(dateTime);
        contactUs.setUpdateTime(dateTime);
        contactUs.setDelFlag(false);
        contactUsRepository.save(contactUs);
    }

    @Override
    public void update(ContactUs contactUs) {

    }

    @Override
    public void delete(Integer id) {
        ContactUs contactUs = contactUsRepository.getByIdAndDelFlag(id,false);
        Assert.notNull(contactUs,"联系信息不存在");
        contactUs.setDelFlag(true);
    }

    @Override
    public ContactUs getById(Integer id) {
        ContactUs contactUs = contactUsRepository.getByIdAndDelFlag(id,false);
        Assert.notNull(contactUs,"联系信息不存在");
        return contactUs;
    }
}
