
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.DiquyiqingmeiriguanliEntity;
import com.entity.view.DiquyiqingmeiriguanliView;
import com.service.*;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 地区疫情每日管理
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/diquyiqingmeiriguanli")
public class DiquyiqingmeiriguanliController {
    private static final Logger logger = LoggerFactory.getLogger(DiquyiqingmeiriguanliController.class);

    @Autowired
    private DiquyiqingmeiriguanliService diquyiqingmeiriguanliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ShequguanliyuanService shequguanliyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("社区管理员".equals(role))
            params.put("shequguanliyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = diquyiqingmeiriguanliService.queryPage(params);

        //字典表数据转换
        List<DiquyiqingmeiriguanliView> list =(List<DiquyiqingmeiriguanliView>)page.getList();
        for(DiquyiqingmeiriguanliView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DiquyiqingmeiriguanliEntity diquyiqingmeiriguanli = diquyiqingmeiriguanliService.selectById(id);
        if(diquyiqingmeiriguanli !=null){
            //entity转view
            DiquyiqingmeiriguanliView view = new DiquyiqingmeiriguanliView();
            BeanUtils.copyProperties( diquyiqingmeiriguanli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DiquyiqingmeiriguanliEntity diquyiqingmeiriguanli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,diquyiqingmeiriguanli:{}",this.getClass().getName(),diquyiqingmeiriguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DiquyiqingmeiriguanliEntity> queryWrapper = new EntityWrapper<DiquyiqingmeiriguanliEntity>()
            .eq("suoshu_time", new SimpleDateFormat("yyyy-MM-dd").format(diquyiqingmeiriguanli.getSuoshuTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiquyiqingmeiriguanliEntity diquyiqingmeiriguanliEntity = diquyiqingmeiriguanliService.selectOne(queryWrapper);
        if(diquyiqingmeiriguanliEntity==null){
            diquyiqingmeiriguanli.setInsertTime(new Date());
            diquyiqingmeiriguanli.setCreateTime(new Date());
            diquyiqingmeiriguanliService.insert(diquyiqingmeiriguanli);
            return R.ok();
        }else {
            return R.error(511,"该天已有记录了");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DiquyiqingmeiriguanliEntity diquyiqingmeiriguanli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,diquyiqingmeiriguanli:{}",this.getClass().getName(),diquyiqingmeiriguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<DiquyiqingmeiriguanliEntity> queryWrapper = new EntityWrapper<DiquyiqingmeiriguanliEntity>()
            .notIn("id",diquyiqingmeiriguanli.getId())
            .andNew()
            .eq("suoshu_time", new SimpleDateFormat("yyyy-MM-dd").format(diquyiqingmeiriguanli.getSuoshuTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiquyiqingmeiriguanliEntity diquyiqingmeiriguanliEntity = diquyiqingmeiriguanliService.selectOne(queryWrapper);
        if(diquyiqingmeiriguanliEntity==null){
            diquyiqingmeiriguanliService.updateById(diquyiqingmeiriguanli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该天已有记录了");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        diquyiqingmeiriguanliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<DiquyiqingmeiriguanliEntity> diquyiqingmeiriguanliList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DiquyiqingmeiriguanliEntity diquyiqingmeiriguanliEntity = new DiquyiqingmeiriguanliEntity();
//                            diquyiqingmeiriguanliEntity.setJinriquezhenNumber(Integer.valueOf(data.get(0)));   //今日确诊人数 要改的
//                            diquyiqingmeiriguanliEntity.setLeijiquezhenNumber(Integer.valueOf(data.get(0)));   //累计确诊人数 要改的
//                            diquyiqingmeiriguanliEntity.setJinrizhiyuNumber(Integer.valueOf(data.get(0)));   //今日治愈人数 要改的
//                            diquyiqingmeiriguanliEntity.setLeijizhiyuNumber(Integer.valueOf(data.get(0)));   //累计治愈人数 要改的
//                            diquyiqingmeiriguanliEntity.setJinrisiwangNumber(Integer.valueOf(data.get(0)));   //今日死亡人数 要改的
//                            diquyiqingmeiriguanliEntity.setLeijisiwangNumber(Integer.valueOf(data.get(0)));   //累计死亡人数 要改的
//                            diquyiqingmeiriguanliEntity.setSuoshuTime(sdf.parse(data.get(0)));          //所属日期 要改的
//                            diquyiqingmeiriguanliEntity.setInsertTime(date);//时间
//                            diquyiqingmeiriguanliEntity.setCreateTime(date);//时间
                            diquyiqingmeiriguanliList.add(diquyiqingmeiriguanliEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        diquyiqingmeiriguanliService.insertBatch(diquyiqingmeiriguanliList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
