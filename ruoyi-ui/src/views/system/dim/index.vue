<template>
  <iframe id="reportFrame" src="http://120.77.76.208/webroot/decision/view/report?viewlet=doc%252FForm%252F%25E5%259C%25A8%25E7%25BA%25BF%25E5%25AF%25BC%25E5%2585%25A5Excel.cpt&ref_t=design&op=write&ref_c=3ce44eb7-8e58-4654-bc0d-909f1932af87" style="width: 95vw; height: 90vh;"></iframe>
</template>

<script>
import { listDim, getDim, delDim, addDim, updateDim } from "@/api/system/dim";

export default {
  name: "Dim",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 维度列表表格数据
      dimList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        dim: null,
        dimName: null,
        createdBy: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询维度列表列表 */
    getList() {
      this.loading = true;
      listDim(this.queryParams).then(response => {
        this.dimList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        dim: null,
        dimName: null,
        createdBy: null,
        createdTime: null,
        updatedBy: null,
        updatedTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.dim)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加维度列表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const dim = row.dim || this.ids
      getDim(dim).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改维度列表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.dim != null) {
            updateDim(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDim(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const dims = row.dim || this.ids;
      this.$modal.confirm('是否确认删除维度列表编号为"' + dims + '"的数据项？').then(function() {
        return delDim(dims);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/dim/export', {
        ...this.queryParams
      }, `dim_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
