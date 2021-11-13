<!--文章分类的表单-->
<template>
<div class="head-from">
  <el-form ref="form" :model="form" label-width="80px">
    <!-- 分类框 -->
    <el-form-item label="分类名">
        <el-input v-model="form.name" maxlength="20" show-word-limit></el-input>
    </el-form-item>
    <!-- 描述框 -->
    <el-form-item label="描述">
      <el-input type="textarea" v-model="form.desc" :rows="10" maxlength="200" show-word-limit></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">提交</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
export default {
  name: "CategoryForm",
  data() {
    return {
       form: {
          name: '',
          desc: '',

        },
        
    }
  },
  methods: {
    onSubmit() {
        
      }
  },
}
</script>

<style scoped>
  .head-from{
    text-align: left;
    width: 50%;
    font-weight: 1000;
  }

</style>