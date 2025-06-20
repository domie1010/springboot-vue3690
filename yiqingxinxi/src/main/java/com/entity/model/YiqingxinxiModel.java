package com.entity.model;

import com.entity.YiqingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 疫情信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YiqingxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 疫情信息名称
     */
    private String yiqingxinxiName;


    /**
     * 疫情信息类型
     */
    private Integer yiqingxinxiTypes;


    /**
     * 疫情信息内容
     */
    private String yiqingxinxiContent;


    /**
     * 疫情信息发布时间
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
	 * 获取：疫情信息名称
	 */
    public String getYiqingxinxiName() {
        return yiqingxinxiName;
    }


    /**
	 * 设置：疫情信息名称
	 */
    public void setYiqingxinxiName(String yiqingxinxiName) {
        this.yiqingxinxiName = yiqingxinxiName;
    }
    /**
	 * 获取：疫情信息类型
	 */
    public Integer getYiqingxinxiTypes() {
        return yiqingxinxiTypes;
    }


    /**
	 * 设置：疫情信息类型
	 */
    public void setYiqingxinxiTypes(Integer yiqingxinxiTypes) {
        this.yiqingxinxiTypes = yiqingxinxiTypes;
    }
    /**
	 * 获取：疫情信息内容
	 */
    public String getYiqingxinxiContent() {
        return yiqingxinxiContent;
    }


    /**
	 * 设置：疫情信息内容
	 */
    public void setYiqingxinxiContent(String yiqingxinxiContent) {
        this.yiqingxinxiContent = yiqingxinxiContent;
    }
    /**
	 * 获取：疫情信息发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：疫情信息发布时间
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
