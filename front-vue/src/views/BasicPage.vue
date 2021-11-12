<!--基本页面（含首页）-->
<template>
  <div>
    <el-container>
      <el-header>
        <el-row>
          <el-col :offset="3" :span="18">
            <Header/>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <el-row>
          <el-col :offset="4" :span="16">
            <div>
              <router-view/>
            </div>
          </el-col>
        </el-row>
      </el-main>
      <el-footer>
        <el-row>
          <el-col :offset="3" :span="18">
            <Footer/>
          </el-col>
        </el-row>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import Header from '@/components/Header';
import Footer from "@/components/Footer";

export default {
  name: "BasicPage",
  components: {
    Header,
    Footer,
  },
  data() {
    return {
      tableData: Array(20).fill('item')
    }
  }
}
</script>

<style scoped>
.el-header, .el-footer {
  /*background-color: #B3C0D1;*/
  /*color: #333;*/
  text-align: center;
  line-height: 60px;
}

.el-main {
  /*background-color: #E9EEF3;*/
  /*color: #333;*/
  text-align: center;
  line-height: 160px;
}
</style>