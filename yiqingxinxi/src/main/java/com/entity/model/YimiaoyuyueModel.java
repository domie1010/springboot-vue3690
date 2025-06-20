package com.entity.model;

import com.entity.YimiaoyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 疫苗预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YimiaoyuyueModel implements Serializable {
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
     * 预约编号
     */
    private String yimiaoyuyueUuidNumber;


    /**
     * 第几针
     */
    private Integer zhenTypes;


    /**
     * 预约备注
     */
    private String yuyueContent;


    /**
     * 疫苗预约状态
     */
    private Integer yimiaoyuyueTypes;


    /**
     * 预约打针时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyueTime;


    /**
     * 实际打针时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shijiTime;


    /**
     * 疫苗编号
     */
    private String yimiaoBianhao;


    /**
     * 疫苗生产日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yimiaoshengchanTime;


    /**
     * 疫苗公司
     */
    private Integer yimiaogongsiTypes;


    /**
     * 备注
     */
    private String beizhuContent;


    /**
     * 申请时间
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
	 * 获取：预约编号
	 */
    public String getYimiaoyuyueUuidNumber() {
        return yimiaoyuyueUuidNumber;
    }


    /**
	 * 设置：预约编号
	 */
    public void setYimiaoyuyueUuidNumber(String yimiaoyuyueUuidNumber) {
        this.yimiaoyuyueUuidNumber = yimiaoyuyueUuidNumber;
    }
    /**
	 * 获取：第几针
	 */
    public Integer getZhenTypes() {
        return zhenTypes;
    }


    /**
	 * 设置：第几针
	 */
    public void setZhenTypes(Integer zhenTypes) {
        this.zhenTypes = zhenTypes;
    }
    /**
	 * 获取：预约备注
	 */
    public String getYuyueContent() {
        return yuyueContent;
    }


    /**
	 * 设置：预约备注
	 */
    public void setYuyueContent(String yuyueContent) {
        this.yuyueContent = yuyueContent;
    }
    /**
	 * 获取：疫苗预约状态
	 */
    public Integer getYimiaoyuyueTypes() {
        return yimiaoyuyueTypes;
    }


    /**
	 * 设置：疫苗预约状态
	 */
    public void setYimiaoyuyueTypes(Integer yimiaoyuyueTypes) {
        this.yimiaoyuyueTypes = yimiaoyuyueTypes;
    }
    /**
	 * 获取：预约打针时间
	 */
    public Date getYuyueTime() {
        return yuyueTime;
    }


    /**
	 * 设置：预约打针时间
	 */
    public void setYuyueTime(Date yuyueTime) {
        this.yuyueTime = yuyueTime;
    }
    /**
	 * 获取：实际打针时间
	 */
    public Date getShijiTime() {
        return shijiTime;
    }


    /**
	 * 设置：实际打针时间
	 */
    public void setShijiTime(Date shijiTime) {
        this.shijiTime = shijiTime;
    }
    /**
	 * 获取：疫苗编号
	 */
    public String getYimiaoBianhao() {
        return yimiaoBianhao;
    }


    /**
	 * 设置：疫苗编号
	 */
    public void setYimiaoBianhao(String yimiaoBianhao) {
        this.yimiaoBianhao = yimiaoBianhao;
    }
    /**
	 * 获取：疫苗生产日期
	 */
    public Date getYimiaoshengchanTime() {
        return yimiaoshengchanTime;
    }


    /**
	 * 设置：疫苗生产日期
	 */
    public void setYimiaoshengchanTime(Date yimiaoshengchanTime) {
        this.yimiaoshengchanTime = yimiaoshengchanTime;
    }
    /**
	 * 获取：疫苗公司
	 */
    public Integer getYimiaogongsiTypes() {
        return yimiaogongsiTypes;
    }


    /**
	 * 设置：疫苗公司
	 */
    public void setYimiaogongsiTypes(Integer yimiaogongsiTypes) {
        this.yimiaogongsiTypes = yimiaogongsiTypes;
    }
    /**
	 * 获取：备注
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 设置：备注
	 */
    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
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
