package com.redsoft.website.dao;


import com.redsoft.starters.jpa.dao.BaseRepository;
import com.redsoft.website.entity.ContactUs;

public interface ContactUsRepository extends BaseRepository<ContactUs,Integer> {
    ContactUs getByIdAndDelFlag(Integer id,Boolean delFlag);
}
