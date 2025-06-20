package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.DiquyiqingmeiriguanliEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 地区疫情每日管理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("diquyiqingmeiriguanli")
public class DiquyiqingmeiriguanliView extends DiquyiqingmeiriguanliEntity implements Serializable {
    private static final long serialVersionUID = 1L;




	public DiquyiqingmeiriguanliView() {

	}

	public DiquyiqingmeiriguanliView(DiquyiqingmeiriguanliEntity diquyiqingmeiriguanliEntity) {
		try {
			BeanUtils.copyProperties(this, diquyiqingmeiriguanliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


















}
