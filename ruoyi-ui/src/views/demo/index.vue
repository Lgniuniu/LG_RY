<template>
  <div>
    
	<el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
      
	  <el-form-item label="百分比" prop="hk" required>
        <el-slider :max='100' :step='1' v-model="formData.hk"></el-slider>
      </el-form-item>
      
	  <el-form-item label="报表名称" prop="xlk">
        <el-select v-model="formData.xlk" placeholder="请选择报表名称" clearable :style="{width: '100%'}">
			<el-option v-for="(item, index) in option" :key="index" :label="item.fineReportName"
			  :value="item.fineReportName" ></el-option>
        </el-select>
      </el-form-item>
	  
	  <el-form-item label="菜单名称" prop="xlk2">
	    <el-select v-model="formData.xlk2" placeholder="请选择菜单名称" clearable :style="{width: '100%'}">
	  			<el-option v-for="(item, index) in menuName" :key="index" :label="item"
	  			  :value="item" ></el-option>
	    </el-select>
	  </el-form-item>
      
	  <el-form-item label="提交" prop="tj">
        <el-button type="primary" icon="el-icon-search" size="medium" @click=""> 主要按钮 </el-button>
      </el-form-item>
      
	  <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    
	</el-form>
  
  </div>
</template>
<script>
import {demo,getList,getMenuList} from "@/api/demo/demo";
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        hk: 0,
        xlk: undefined,
        tj: '',
		xlk2: undefined,
      },
      rules: {
        xlk: [{
          required: false,
          message: '这是我设置的下拉框',
          trigger: 'change'
        }],
      },
	  option:[],
	  menuName:[],
	  queryParams: {
	    pageNum: 1,
	    pageSize: 10,
	    fineReportName: null,
	    fineReportUrl: null,
	    fineReportOp: null,
	    fineReportType: null
	  }
    }
	
  },
  computed: {},
  watch: {},
  created() {
	  this.getOp();
	  this.getMenu();
  },
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (valid) {
			// alert(this.formData.hk);
			demo(this.formData).then(response => {
			alert(response.hk);
			this.formData.xlk = response.xlk;
      });
			}
		else{
			alert('不通过');
		}
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
	getOp() {
	  getList(this.queryParams).then(response => {
	    this.option = response.rows;
	  });
	},
	getMenu() {
	  getMenuList().then(response => {	    
		this.menuName = response;
	  });
	},
  }
}

</script>
<style>
</style>
