import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import daka from '@/views/modules/daka/list'
    import dictionary from '@/views/modules/dictionary/list'
    import diqu from '@/views/modules/diqu/list'
    import diquyiqingmeiriguanli from '@/views/modules/diquyiqingmeiriguanli/list'
    import gonggao from '@/views/modules/gonggao/list'
    import hesuanyuyue from '@/views/modules/hesuanyuyue/list'
    import shequguankong from '@/views/modules/shequguankong/list'
    import yimiaoyuyue from '@/views/modules/yimiaoyuyue/list'
    import yiqingxinxi from '@/views/modules/yiqingxinxi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yonghuxingcheng from '@/views/modules/yonghuxingcheng/list'
    import shequguanliyuan from '@/views/modules/shequguanliyuan/list'
    import dictionaryFengxian from '@/views/modules/dictionaryFengxian/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryHesuanyuyue from '@/views/modules/dictionaryHesuanyuyue/list'
    import dictionaryJiancedian from '@/views/modules/dictionaryJiancedian/list'
    import dictionaryJiancejieguo from '@/views/modules/dictionaryJiancejieguo/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShequ from '@/views/modules/dictionaryShequ/list'
    import dictionaryYimiaogongsi from '@/views/modules/dictionaryYimiaogongsi/list'
    import dictionaryYimiaoyuyue from '@/views/modules/dictionaryYimiaoyuyue/list'
    import dictionaryYiqingxinxi from '@/views/modules/dictionaryYiqingxinxi/list'
    import dictionaryZhen from '@/views/modules/dictionaryZhen/list'
    import dictionaryZhiwei from '@/views/modules/dictionaryZhiwei/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryFengxian',
        name: '地区风险等级',
        component: dictionaryFengxian
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryHesuanyuyue',
        name: '核酸预约状态',
        component: dictionaryHesuanyuyue
    }
    ,{
        path: '/dictionaryJiancedian',
        name: '检测点',
        component: dictionaryJiancedian
    }
    ,{
        path: '/dictionaryJiancejieguo',
        name: '检测结果',
        component: dictionaryJiancejieguo
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShequ',
        name: '所属社区',
        component: dictionaryShequ
    }
    ,{
        path: '/dictionaryYimiaogongsi',
        name: '疫苗公司',
        component: dictionaryYimiaogongsi
    }
    ,{
        path: '/dictionaryYimiaoyuyue',
        name: '疫苗预约状态',
        component: dictionaryYimiaoyuyue
    }
    ,{
        path: '/dictionaryYiqingxinxi',
        name: '疫情信息类型',
        component: dictionaryYiqingxinxi
    }
    ,{
        path: '/dictionaryZhen',
        name: '第几针',
        component: dictionaryZhen
    }
    ,{
        path: '/dictionaryZhiwei',
        name: '职位',
        component: dictionaryZhiwei
    }


    ,{
        path: '/daka',
        name: '打卡',
        component: daka
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/diqu',
        name: '地区',
        component: diqu
      }
    ,{
        path: '/diquyiqingmeiriguanli',
        name: '地区疫情每日管理',
        component: diquyiqingmeiriguanli
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/hesuanyuyue',
        name: '核酸预约',
        component: hesuanyuyue
      }
    ,{
        path: '/shequguankong',
        name: '社区管控',
        component: shequguankong
      }
    ,{
        path: '/yimiaoyuyue',
        name: '疫苗预约',
        component: yimiaoyuyue
      }
    ,{
        path: '/yiqingxinxi',
        name: '疫情信息',
        component: yiqingxinxi
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yonghuxingcheng',
        name: '用户行程',
        component: yonghuxingcheng
      }
    ,{
        path: '/shequguanliyuan',
        name: '社区管理员',
        component: shequguanliyuan
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
