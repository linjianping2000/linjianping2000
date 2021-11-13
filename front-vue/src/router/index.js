import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        component: () => import('@/views/BasicPage'),
        meta: {requireLogin: true},
        children: [{
            // 主页
            path: 'main',
            component: () => import('@/components/HomePage'),
            meta: {requireLogin: true}
        }, {
            // 写文章
            path: 'write',
            component: () => import('@/components/MdEditor'),
            meta: {requireLogin: true}
        }, {
            // 查看所有文章
            path: 'allpost',
            component: () => import('@/components/ArticleTable'),
            meta: {requireLogin: true}
        }]
    },
    // {path: '/test1', component: () => import('@/components/MdEditor')},
    // {path: '/test2', component: () => import('@/components/MdViewer')},
    // {path: '/test3', component: () => import('@/components/TopMenu')},
    // {path: '/test4', component: () => import('@/components/Header')},
    // {path: '/test5', component: () => import('@/components/CommonContentCard'), meta: {pageName: '测试'}},
    {path: '/test6', component: () => import('@/components/ArticleTable')},
    {path: '/ca', component: () => import('@/components/CategoryForm')},
    {path: '/login', component: () => import('@/views/LoginPage'), meta: {requireLogin: false}},

    // {path: '/register', component: () => import('@/views/LoginPage'), meta: {requireLogin: false}}
]

const router = new VueRouter({
    routes,
})

// 重复跳转
const routerPush = router.push
router.push = function push(location, onResolve, onReject) {
    if (onResolve || onReject) return routerPush.call(this, location, onResolve, onReject)
    return routerPush.call(this, location).catch((err) => err)
}

router.beforeEach((to, from, next) => {
    // 需要验证的页面
    if (to.meta.requireLogin) {
        let userInfo = window.sessionStorage.getItem('userInfo')
        // 如果已经登录了
        if (userInfo) {
            next()

            // 还没登录
        } else {
            next('/login')
        }

        // 如果是不需要验证的页面直接放行
    } else {
        next()
    }
})

export default router
