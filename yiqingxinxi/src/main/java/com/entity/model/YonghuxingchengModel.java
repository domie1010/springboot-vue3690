package com.entity.model;

import com.entity.YonghuxingchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 用户行程
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YonghuxingchengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 地区
     */
    private Integer diquId;


    /**
     * 去的时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date quTime;


    /**
     * 回的时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huiTime;


    /**
     * 去的缘由
     */
    private String yuanyouContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：地区
	 */
    public Integer getDiquId() {
        return diquId;
    }


    /**
	 * 设置：地区
	 */
    public void setDiquId(Integer diquId) {
        this.diquId = diquId;
    }
    /**
	 * 获取：去的时间
	 */
    public Date getQuTime() {
        return quTime;
    }


    /**
	 * 设置：去的时间
	 */
    public void setQuTime(Date quTime) {
        this.quTime = quTime;
    }
    /**
	 * 获取：回的时间
	 */
    public Date getHuiTime() {
        return huiTime;
    }


    /**
	 * 设置：回的时间
	 */
    public void setHuiTime(Date huiTime) {
        this.huiTime = huiTime;
    }
    /**
	 * 获取：去的缘由
	 */
    public String getYuanyouContent() {
        return yuanyouContent;
    }


    /**
	 * 设置：去的缘由
	 */
    public void setYuanyouContent(String yuanyouContent) {
        this.yuanyouContent = yuanyouContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
