<!--顶部导航栏-->
<template>
  <div>
    <el-row justify="space-between" type="flex">
      <el-col :span="3">
        <el-link :underline="false" href="/main">
          <logo style="font-size: 32px; padding-top: 0px"/>
        </el-link>

      </el-col>
      <el-col :span="18">
        <top-menu :metaMenu="menuData"/>
      </el-col>
      <el-col :span="1">
        <el-dropdown>
          <el-button type="text">
            <el-avatar size="small"
                       src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></el-avatar>
          </el-button>

          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
              <i class="el-icon-user"/>个人资料
            </el-dropdown-item>
            <el-dropdown-item divided>
              <i class="el-icon-switch-button"/> 退出
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-col>

    </el-row>
  </div>

</template>

<script>
import TopMenu from "@/components/TopMenu";
import Logo from "@/components/Logo";

export default {
  name: "Header",
  components: {
    TopMenu,
    Logo
  },
  data() {
    return {
      menuData: [{
        text: '文章',
        disabled: false,
        index: '1',
        link: '/',
        subMenu: [
          {text: '写文章', disabled: false, index: '1-1', link: '/#', subMenu: []},
          {text: '所有文章', disabled: false, index: '1-2', link: '/test1', subMenu: []},
          {text: '分类目录', disabled: false, index: '1-3', subMenu: []}]
      },
        {text: '评论', disabled: false, index: '2', subMenu: []},
        {text: '用户', disabled: false, index: '3', subMenu: []},
        {text: '系统设置', disabled: false, index: '4', subMenu: []}]
    }
  }
}
</script>

<style scoped>

</style>