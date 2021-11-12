<!--查看所有文章-->
<template>
  <div>
    <el-row>
      <el-col :span="20">
        <el-form :inline="true" size="small">
          <el-form-item label="文章状态">
            <el-select v-model="value" placeholder="请选择">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="分类目录">
            <el-select v-model="value" placeholder="请选择">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">重置</el-button>
          </el-form-item>
        </el-form>

      </el-col>
    </el-row>

    <el-row>
      <el-col :span="2">
        <el-button icon="el-icon-edit-outline" size="medium" type="primary">写文章</el-button>
      </el-col>
    </el-row>
    <el-row>
      <el-table
          :data="tableData"
          style="width: 100%">
        <el-table-column
            label="标题"
            prop="articleTitle"
            width="180">
        </el-table-column>
        <el-table-column
            label="状态"
            prop="statusText"
            width="180">
        </el-table-column>
        <el-table-column
            label="分类"
            prop="categoryText"
            width="180">
        </el-table-column>
        <el-table-column
            label="评论"
            prop="commentCount"
            width="180">
        </el-table-column>
        <el-table-column
            label="浏览"
            prop="visitCount"
            width="180">
        </el-table-column>
        <el-table-column
            label="发布时间"
            prop="updateTime"
            width="180">
        </el-table-column>
        <el-table-column
            label="操作"
            width="100">
          <template slot-scope="scope">
            <el-button size="small" type="text" @click="handleClick(scope.row)">查看</el-button>
            <el-button size="small" type="text">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-row>
    <el-row>
      <el-pagination
          :hide-on-single-page="true"
          :total="50"
          layout="prev, pager, next">
      </el-pagination>
    </el-row>

  </div>
</template>

<script>
export default {
  name: "ArticleTable",
  data() {
    return {
      tableData: [],
      userInfo: JSON.parse(sessionStorage.getItem('userInfo'))
    }
  },
  methods: {
    listByUserId: function (param) {
      this.axios.get('/blog/article', {
        params: param
      }).then((res) => {
        // if (res.data.success) {
        //
        // }
        console.log(res.data)
        this.tableData = res.data.data.records
        return res.data.data
      }).catch(() => {
        this.$message.error('网络拥堵，请稍后重试')
      })
    }
  },
  created() {
    this.listByUserId({userId: this.userInfo.id, pageNo: 1, pageSize: 10})
  }
}
</script>

<style scoped>

</style>