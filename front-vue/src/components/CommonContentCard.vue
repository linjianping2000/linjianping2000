<!--main内容基本框架-->
<template>
  <div>
    <el-card class="box-card" shadow="hover">
      <div slot="header" class="clearfix">
        <el-page-header :content="this.$route.meta.pageName" @back="goBack">
        </el-page-header>
      </div>
      <router-view/>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "CommonContentCard",
  methods: {
    goBack: function () {
      this.$router.go(-1)
    }
  }
}
</script>

<style scoped>

</style>