<!--md编辑组件-->
<template>
  <mavon-editor v-model="value"/>
</template>

<script>
export default {
  name: "MdEditor",
  data() {
    return {
      value: ''
    }
  }
}
</script>

<style scoped>

</style>