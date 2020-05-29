package com.redsoft.website.entity;

import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(appliesTo = "solution", comment = "解决方案表")
public class Solution {
    /**
     * 唯一标志
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 标题
     */
    @Basic
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;
    /**
     * 图片url
     */
    @Basic
    @NotNull
    @Column(name = "main_img", nullable = false)
    private String mainImg;
    /**
     * 简介
     */
    @Basic
    @NotNull
    @Column(name = "short_desc", nullable = false)
    private String shortDesc;
    /**
     * 内容
     */
    @Basic
    @NotNull
    @Column(name = "content", nullable = false)
    private String content;
    /**
     * 显示顺序
     */
    @Basic
    @Column(name = "display")
    private Integer display;
    /**
     * 创建人
     */
    @Basic
    @Column(name = "create_by")
    private Integer createBy;
    /**
     * 创建时间
     */
    @Basic
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新人
     */
    @Basic
    @Column(name = "update_by")
    private Integer updateBy;
    /**
     * 更新时间
     */
    @Basic
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 是否删除
     */
    @Basic
    @Column(name = "del_flag", nullable = true)
    private boolean delFlag;
}
