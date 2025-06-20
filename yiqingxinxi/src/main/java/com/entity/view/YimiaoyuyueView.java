package com.entity.view;

import com.entity.YimiaoyuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 疫苗预约
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yimiaoyuyue")
public class YimiaoyuyueView extends YimiaoyuyueEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 第几针的值
		*/
		private String zhenValue;
		/**
		* 疫苗预约状态的值
		*/
		private String yimiaoyuyueValue;
		/**
		* 疫苗公司的值
		*/
		private String yimiaogongsiValue;



		//级联表 yonghu
			/**
			* 用户编号
			*/
			private String yonghuUuidNumber;
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public YimiaoyuyueView() {

	}

	public YimiaoyuyueView(YimiaoyuyueEntity yimiaoyuyueEntity) {
		try {
			BeanUtils.copyProperties(this, yimiaoyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 第几针的值
			*/
			public String getZhenValue() {
				return zhenValue;
			}
			/**
			* 设置： 第几针的值
			*/
			public void setZhenValue(String zhenValue) {
				this.zhenValue = zhenValue;
			}
			/**
			* 获取： 疫苗预约状态的值
			*/
			public String getYimiaoyuyueValue() {
				return yimiaoyuyueValue;
			}
			/**
			* 设置： 疫苗预约状态的值
			*/
			public void setYimiaoyuyueValue(String yimiaoyuyueValue) {
				this.yimiaoyuyueValue = yimiaoyuyueValue;
			}
			/**
			* 获取： 疫苗公司的值
			*/
			public String getYimiaogongsiValue() {
				return yimiaogongsiValue;
			}
			/**
			* 设置： 疫苗公司的值
			*/
			public void setYimiaogongsiValue(String yimiaogongsiValue) {
				this.yimiaogongsiValue = yimiaogongsiValue;
			}




















				//级联表的get和set yonghu

					/**
					* 获取： 用户编号
					*/
					public String getYonghuUuidNumber() {
						return yonghuUuidNumber;
					}
					/**
					* 设置： 用户编号
					*/
					public void setYonghuUuidNumber(String yonghuUuidNumber) {
						this.yonghuUuidNumber = yonghuUuidNumber;
					}

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}






}
