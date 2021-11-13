<!--查看所有文章-->
<template>
  <div>
    <!--    <el-row>-->
    <!--      <el-col :span="20">-->
    <!--        <el-form :inline="true" size="small">-->
    <!--          <el-form-item label="文章状态">-->
    <!--            <el-select v-model="value" placeholder="请选择">-->
    <!--              <el-option-->
    <!--                  v-for="item in options"-->
    <!--                  :key="item.value"-->
    <!--                  :label="item.label"-->
    <!--                  :value="item.value">-->
    <!--              </el-option>-->
    <!--            </el-select>-->
    <!--          </el-form-item>-->

    <!--          <el-form-item label="分类目录">-->
    <!--            <el-select v-model="value" placeholder="请选择">-->
    <!--              <el-option-->
    <!--                  v-for="item in options"-->
    <!--                  :key="item.value"-->
    <!--                  :label="item.label"-->
    <!--                  :value="item.value">-->
    <!--              </el-option>-->
    <!--            </el-select>-->
    <!--          </el-form-item>-->

    <!--          <el-form-item>-->
    <!--            <el-button type="primary" @click="onSubmit">查询</el-button>-->
    <!--          </el-form-item>-->
    <!--          <el-form-item>-->
    <!--            <el-button type="primary" @click="onSubmit">重置</el-button>-->
    <!--          </el-form-item>-->
    <!--        </el-form>-->

    <!--      </el-col>-->
    <!--    </el-row>-->

    <!--    <el-row>-->
    <!--      <el-col :span="2">-->
    <!--        <el-button icon="el-icon-edit-outline" size="medium" type="primary">写文章</el-button>-->
    <!--      </el-col>-->
    <!--    </el-row>-->
    <el-row>
      <el-table
          :data="tableData"
          :row-class-name="statusRowClass"
          style="width: 100%">
        <el-table-column
            :show-overflow-tooltip="true"
            label="标题"
            prop="articleTitle"
            width="240">
        </el-table-column>
        <el-table-column
            label="状态"
            prop="statusText"
            width="80">
        </el-table-column>
        <el-table-column
            label="分类"
            width="180">
          <template slot-scope="scope">
            <el-tag :type="scope.row.categoryText === '默认分类' ? 'primary' : 'success'"
                    disable-transitions
                    size="small">{{ scope.row.categoryText }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column
            label="评论"
            prop="commentCount"
            width="100">
        </el-table-column>
        <el-table-column
            label="浏览"
            prop="visitCount"
            width="120">
        </el-table-column>
        <el-table-column
            label="发布时间"
            width="180">
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row.updateTime.substr(0, 16) }}</span>
          </template>
        </el-table-column>
        <el-table-column
            label="操作"
        >
          <template slot-scope="scope">
            <el-button size="medium" type="text" @click="handleClick(scope.row)">查看</el-button>
            <el-button size="medium" type="text">编辑</el-button>
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
        // console.log(res)
        // console.log(res.data)
        this.tableData = res.data.data.records
        return res.data.data
      }).catch(() => {
        this.$message.error('网络拥堵，请稍后重试')
      })
    },
    // eslint-disable-next-line no-unused-vars
    statusRowClass({row, rowIndex}) {

      // console.log(row.isDeleted)
      // console.log(typeof row.isDeleted)
      if (row.isDeleted === 1) {
        return 'success-row'
      }
          // else if (row.isDeleted === 2) {
          //   return 'common-row'
      // }
      else if (row.isDeleted === 3) {
        return 'warning-row'
      } else {
        return ''
      }
    }
  },
  created() {
    this.listByUserId({userId: this.userInfo.id, pageNo: 1, pageSize: 10})
  }
}
</script>

<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}

.el-table .common-row {
  background: #ecf5ff;
}
</style>