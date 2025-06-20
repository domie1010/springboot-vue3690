package com.dao;

import com.entity.HesuanyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HesuanyuyueView;

/**
 * 核酸预约 Dao 接口
 *
 * @author 
 */
public interface HesuanyuyueDao extends BaseMapper<HesuanyuyueEntity> {

   List<HesuanyuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
