<!--文字logo-->
<template>
  <div class="blog-logo">
    <span>ap-blog</span>
  </div>
</template>

<script>
export default {
  name: "Logo"
}
</script>

<style scoped>
.blog-logo {
  text-align: center;
  vertical-align: text-bottom;
  font-size: 38px;
  display: inline-block;
  font-weight: 600;
  color: #1790fe;
  background-image: linear-gradient(
      -20deg, #6e45e2, #88d3ce);
  -webkit-text-fill-color: transparent;
  -webkit-background-clip: text;
}
</style>