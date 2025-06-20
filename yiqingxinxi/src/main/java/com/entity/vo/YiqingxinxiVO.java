package com.entity.vo;

import com.entity.YiqingxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 疫情信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yiqingxinxi")
public class YiqingxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 疫情信息名称
     */

    @TableField(value = "yiqingxinxi_name")
    private String yiqingxinxiName;


    /**
     * 疫情信息类型
     */

    @TableField(value = "yiqingxinxi_types")
    private Integer yiqingxinxiTypes;


    /**
     * 疫情信息内容
     */

    @TableField(value = "yiqingxinxi_content")
    private String yiqingxinxiContent;


    /**
     * 疫情信息发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：疫情信息名称
	 */
    public String getYiqingxinxiName() {
        return yiqingxinxiName;
    }


    /**
	 * 获取：疫情信息名称
	 */

    public void setYiqingxinxiName(String yiqingxinxiName) {
        this.yiqingxinxiName = yiqingxinxiName;
    }
    /**
	 * 设置：疫情信息类型
	 */
    public Integer getYiqingxinxiTypes() {
        return yiqingxinxiTypes;
    }


    /**
	 * 获取：疫情信息类型
	 */

    public void setYiqingxinxiTypes(Integer yiqingxinxiTypes) {
        this.yiqingxinxiTypes = yiqingxinxiTypes;
    }
    /**
	 * 设置：疫情信息内容
	 */
    public String getYiqingxinxiContent() {
        return yiqingxinxiContent;
    }


    /**
	 * 获取：疫情信息内容
	 */

    public void setYiqingxinxiContent(String yiqingxinxiContent) {
        this.yiqingxinxiContent = yiqingxinxiContent;
    }
    /**
	 * 设置：疫情信息发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：疫情信息发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
