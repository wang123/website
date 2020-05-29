package com.redsoft.website.dao;

import com.redsoft.starters.jpa.dao.BaseRepository;
import com.redsoft.website.entity.Solution;

public interface SolutionRepository extends BaseRepository<Solution,Integer> {
    Solution getByIdAndDelFlag(Integer id, Boolean delFlag);
}
