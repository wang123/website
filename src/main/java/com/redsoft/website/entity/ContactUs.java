package com.redsoft.website.entity;

import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(appliesTo = "contact_us", comment = "联系信息表")
public class ContactUs {
    /**
     * 主键
     */
    @Id
    @Column(name = "id", nullable = false,length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 姓名
     */
    @Basic
    @Column(name = "name", nullable = false,length = 20)
    private String name;
    /**
     * 电话
     */
    @Basic
    @Column(name = "phone", nullable = false,length = 11)
    private String phone;
    /**
     * 邮箱
     */
    @Basic
    @Column(name = "email", nullable = true,length = 60)
    private String email;
    /**
     * 留言
     */
    @Basic
    @Column(name = "leave_message", nullable = true, length = 255)
    private String leaveMessage;
    /**
     * 创建时间
     */
    @Basic
    @Column(name = "create_time", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Basic
    @Column(name = "update_time", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 是否删除
     */
    @Basic
    @Column(name = "del_flag", nullable = true)
    private boolean delFlag;
}
