const base = {
    get() {
        return {
            url : "http://localhost:8080/yiqingxinxi/",
            name: "yiqingxinxi",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yiqingxinxi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "疫情信息管理系统"
        } 
    }
}
export default base
