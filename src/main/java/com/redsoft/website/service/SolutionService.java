package com.redsoft.website.service;

import com.redsoft.starters.jpa.page.PageResult;
import com.redsoft.website.entity.Solution;
import org.springframework.data.domain.Pageable;

public interface SolutionService {

    PageResult<Solution> list(Solution solution, Pageable pageable);

    void add(Solution solution);

    void update(Solution solution);

    void delete(Integer id);

    Solution getById(Integer id);
}
