package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.DiquyiqingmeiriguanliEntity;
import com.entity.view.DiquyiqingmeiriguanliView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 地区疫情每日管理 Dao 接口
 *
 * @author 
 */
public interface DiquyiqingmeiriguanliDao extends BaseMapper<DiquyiqingmeiriguanliEntity> {

   List<DiquyiqingmeiriguanliView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
