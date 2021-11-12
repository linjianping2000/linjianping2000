<!--顶部导航菜单-->
<template>
  <div>
    <!--    @select="handleSelect"-->
    <el-menu :default-active="activeIndex" mode="horizontal">
      <template v-for="(menu) in metaMenu">
        <!--      有下拉      -->
        <el-submenu v-if="hasSubMenu(menu)" :key="menu.index" :disabled="menu.disabled" :index="menu.index">
          <template slot="title">{{ menu.text }}</template>
          <el-menu-item v-for="sub in menu.subMenu" :key="sub.index"
                        :disabled="sub.disabled" :index="sub.index">
            <el-link :disabled="sub.disabled" :href="sub.link">{{ sub.text }}</el-link>
          </el-menu-item>
        </el-submenu>

        <!--      没有下拉      -->
        <el-menu-item v-else :key="menu.index" :disabled="menu.disabled"
                      :index="menu.index">
          <el-link :disabled="menu.disabled" :href="menu.link">{{ menu.text }}</el-link>
        </el-menu-item>
      </template>

    </el-menu>
  </div>
</template>

<script>
export default {
  name: "TopMenu",
  components: {},
  props: {
    metaMenu: {
      type: Array,
      required: false,
      default: function () {
        return [{text: '出问题啦', disabled: true, index: '1', subMenu: []}];
      }
    }
  },
  computed: {},
  methods: {
    hasSubMenu: function (node) {
      return node.subMenu && node.subMenu.length > 0;
    }
  },
  data() {
    return {
      activeIndex: '1',
    }
  }
}
</script>

<style scoped>

</style>