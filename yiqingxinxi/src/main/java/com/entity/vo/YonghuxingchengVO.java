package com.entity.vo;

import com.entity.YonghuxingchengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 用户行程
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yonghuxingcheng")
public class YonghuxingchengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 地区
     */

    @TableField(value = "diqu_id")
    private Integer diquId;


    /**
     * 去的时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qu_time")
    private Date quTime;


    /**
     * 回的时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "hui_time")
    private Date huiTime;


    /**
     * 去的缘由
     */

    @TableField(value = "yuanyou_content")
    private String yuanyouContent;


    /**
     * 添加时间
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：地区
	 */
    public Integer getDiquId() {
        return diquId;
    }


    /**
	 * 获取：地区
	 */

    public void setDiquId(Integer diquId) {
        this.diquId = diquId;
    }
    /**
	 * 设置：去的时间
	 */
    public Date getQuTime() {
        return quTime;
    }


    /**
	 * 获取：去的时间
	 */

    public void setQuTime(Date quTime) {
        this.quTime = quTime;
    }
    /**
	 * 设置：回的时间
	 */
    public Date getHuiTime() {
        return huiTime;
    }


    /**
	 * 获取：回的时间
	 */

    public void setHuiTime(Date huiTime) {
        this.huiTime = huiTime;
    }
    /**
	 * 设置：去的缘由
	 */
    public String getYuanyouContent() {
        return yuanyouContent;
    }


    /**
	 * 获取：去的缘由
	 */

    public void setYuanyouContent(String yuanyouContent) {
        this.yuanyouContent = yuanyouContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
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
