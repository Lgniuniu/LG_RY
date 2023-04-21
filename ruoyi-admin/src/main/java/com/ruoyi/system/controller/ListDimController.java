package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.FineReportManage;
import com.ruoyi.system.service.IFineReportManageService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ListDim;
import com.ruoyi.system.service.IListDimService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维度列表Controller
 * 
 * @author tls
 * @date 2023-03-23
 */
@RestController
@RequestMapping("/system/dim")
public class ListDimController extends BaseController
{
    @Autowired
    private IListDimService listDimService;

    @Autowired
    private IFineReportManageService fineReportManageService;
    /**
     * 设置iframe地址
     */
//    @PreAuthorize("@ss.hasPermi('system:dim:list')")
    @GetMapping("/url")
    public AjaxResult url(@RequestParam("id") long id)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        String userId = "&fineid="+ Long.toString(user.getUserId());
        String url = "/fine/view/report?f_t=design&ref_c=3ce44eb7-8e58-4654-bc0d-909f1932af87&viewlet=";
        FineReportManage fineReportManage = fineReportManageService.selectFineReportManageById(id);
        String fineReportUrl = fineReportManage.getFineReportUrl();
        String fineReportName = fineReportManage.getFineReportName()+".cpt";
        String fineReportOp = "&op="+fineReportManage.getFineReportOp();
        if (StringUtils.isEmpty(fineReportUrl)){
            url=url+fineReportName+fineReportOp;
        }else {
            url=url+fineReportUrl+"/"+fineReportName+fineReportOp+userId;
        }
        return success(url);
    }


    /**
     * 查询维度列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:dim:list')")
    @GetMapping("/list")
    public TableDataInfo list(ListDim listDim)
    {
        startPage();
        List<ListDim> list = listDimService.selectListDimList(listDim);
        return getDataTable(list);
    }

    /**
     * 导出维度列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:dim:export')")
    @Log(title = "维度列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ListDim listDim)
    {
        List<ListDim> list = listDimService.selectListDimList(listDim);
        ExcelUtil<ListDim> util = new ExcelUtil<ListDim>(ListDim.class);
        util.exportExcel(response, list, "维度列表数据");
    }

    /**
     * 获取维度列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dim:query')")
    @GetMapping(value = "/{dim}")
    public AjaxResult getInfo(@PathVariable("dim") String dim)
    {
        return success(listDimService.selectListDimByDim(dim));
    }

    /**
     * 新增维度列表
     */
    @PreAuthorize("@ss.hasPermi('system:dim:add')")
    @Log(title = "维度列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ListDim listDim)
    {
        return toAjax(listDimService.insertListDim(listDim));
    }

    /**
     * 修改维度列表
     */
    @PreAuthorize("@ss.hasPermi('system:dim:edit')")
    @Log(title = "维度列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ListDim listDim)
    {
//        return toAjax(listDimService.insertListDim(listDim));
        return toAjax(listDimService.updateListDim(listDim));
    }

    /**
     * 删除维度列表
     */
    @PreAuthorize("@ss.hasPermi('system:dim:remove')")
    @Log(title = "维度列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dims}")
    public AjaxResult remove(@PathVariable String[] dims)
    {
        return toAjax(listDimService.deleteListDimByDims(dims));
    }
}
