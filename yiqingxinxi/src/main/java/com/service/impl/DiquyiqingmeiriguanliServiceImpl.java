package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.DiquyiqingmeiriguanliDao;
import com.entity.DiquyiqingmeiriguanliEntity;
import com.entity.view.DiquyiqingmeiriguanliView;
import com.service.DiquyiqingmeiriguanliService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 地区疫情每日管理 服务实现类
 */
@Service("diquyiqingmeiriguanliService")
@Transactional
public class DiquyiqingmeiriguanliServiceImpl extends ServiceImpl<DiquyiqingmeiriguanliDao, DiquyiqingmeiriguanliEntity> implements DiquyiqingmeiriguanliService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<DiquyiqingmeiriguanliView> page =new Query<DiquyiqingmeiriguanliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
