package com.redsoft.website.service;

import com.redsoft.starters.jpa.page.PageResult;
import com.redsoft.website.entity.ContactUs;
import org.springframework.data.domain.Pageable;

public interface ContactUsService {
    PageResult<ContactUs> list(ContactUs contactUs, Pageable pageable);

    void add(ContactUs contactUs);

    void update(ContactUs contactUs);

    void delete(Integer id);

    ContactUs getById(Integer id);
}
