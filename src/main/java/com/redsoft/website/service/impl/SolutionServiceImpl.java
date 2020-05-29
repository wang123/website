package com.redsoft.website.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.redsoft.starters.jpa.page.PageResult;
import com.redsoft.starters.own.util.util.BeanUtils;
import com.redsoft.starters.sysc.constant.SysConstants;
import com.redsoft.starters.sysc.util.AuthUtil;
import com.redsoft.website.constant.$;
import com.redsoft.website.dao.SolutionRepository;
import com.redsoft.website.entity.Solution;
import com.redsoft.website.service.SolutionService;
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
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private SolutionRepository solutionRepository;

    @Override
    public PageResult<Solution> list(Solution solution, Pageable pageable) {
        BooleanBuilder where = new BooleanBuilder($.solution.delFlag.eq(SysConstants.EXIST));
        if (StringUtils.hasText(solution.getTitle())) {
            where.and($.solution.title.contains(solution.getContent()));
        }
        Page<Solution> results = solutionRepository.findAll(where, pageable);
        return PageResult.of(results);
    }

    @Override
    public void add(Solution solution) {
        Assert.isNull(solution.getId(),"id必须为空");
        LocalDateTime dateTime = LocalDateTime.now();
        Integer accountId = AuthUtil.currentAccountId();
        solution.setCreateBy(accountId);
        solution.setUpdateBy(accountId);
        solution.setCreateTime(dateTime);
        solution.setUpdateTime(dateTime);
        solution.setDelFlag(false);
        solutionRepository.save(solution);
    }

    @Override
    public void update(Solution solution) {
        Integer id = solution.getId();
        Solution sol = solutionRepository.getByIdAndDelFlag(id,false);
        Assert.notNull(sol,"方案信息不存在");
        LocalDateTime dateTime = LocalDateTime.now();
        Integer accountId = AuthUtil.currentAccountId();
        solution.setUpdateBy(accountId);
        solution.setUpdateTime(dateTime);
        BeanUtils.copyNotNullProperties(solution, sol);
    }

    @Override
    public void delete(Integer id) {
        Solution solution = solutionRepository.getByIdAndDelFlag(id,false);
        Assert.notNull(solution,"方案信息不存在");
        solution.setDelFlag(true);
    }

    @Override
    public Solution getById(Integer id) {
        Solution solution = solutionRepository.getByIdAndDelFlag(id,false);
        Assert.notNull(solution,"方案信息不存在");
        return solution;
    }
}
