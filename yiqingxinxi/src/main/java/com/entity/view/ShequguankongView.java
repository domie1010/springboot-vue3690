package com.entity.view;

import com.entity.ShequguankongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 社区管控
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shequguankong")
public class ShequguankongView extends ShequguankongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 社区的值
		*/
		private String shequValue;
		/**
		* 管控等级的值
		*/
		private String fengxianValue;



	public ShequguankongView() {

	}

	public ShequguankongView(ShequguankongEntity shequguankongEntity) {
		try {
			BeanUtils.copyProperties(this, shequguankongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 社区的值
			*/
			public String getShequValue() {
				return shequValue;
			}
			/**
			* 设置： 社区的值
			*/
			public void setShequValue(String shequValue) {
				this.shequValue = shequValue;
			}
			/**
			* 获取： 管控等级的值
			*/
			public String getFengxianValue() {
				return fengxianValue;
			}
			/**
			* 设置： 管控等级的值
			*/
			public void setFengxianValue(String fengxianValue) {
				this.fengxianValue = fengxianValue;
			}














}
