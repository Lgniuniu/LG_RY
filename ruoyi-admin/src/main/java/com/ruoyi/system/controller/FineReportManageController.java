package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.FineReportManage;
import com.ruoyi.system.service.IFineReportManageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报表路径Controller
 *
 * @author 林淦
 * @date 2023-05-15
 */
@RestController
@RequestMapping("/system/manage")
public class FineReportManageController extends BaseController
{
    @Autowired
    private IFineReportManageService fineReportManageService;

    /**
     * 查询报表路径列表
     */
    @PreAuthorize("@ss.hasPermi('system:manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(FineReportManage fineReportManage)
    {
        startPage();
        List<FineReportManage> list = fineReportManageService.selectFineReportManageList(fineReportManage);
        return getDataTable(list);
    }

    /**
     * 导出报表路径列表
     */
    @PreAuthorize("@ss.hasPermi('system:manage:export')")
    @Log(title = "报表路径", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FineReportManage fineReportManage)
    {
        List<FineReportManage> list = fineReportManageService.selectFineReportManageList(fineReportManage);
        ExcelUtil<FineReportManage> util = new ExcelUtil<FineReportManage>(FineReportManage.class);
        util.exportExcel(response, list, "报表路径数据");
    }

    /**
     * 获取报表路径详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fineReportManageService.selectFineReportManageById(id));
    }

    /**
     * 新增报表路径
     */
    @PreAuthorize("@ss.hasPermi('system:manage:add')")
    @Log(title = "报表路径", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FineReportManage fineReportManage)
    {
        return toAjax(fineReportManageService.insertFineReportManage(fineReportManage));
    }

    /**
     * 修改报表路径
     */
    @PreAuthorize("@ss.hasPermi('system:manage:edit')")
    @Log(title = "报表路径", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FineReportManage fineReportManage)
    {
        return toAjax(fineReportManageService.updateFineReportManage(fineReportManage));
    }

    /**
     * 删除报表路径
     */
    @PreAuthorize("@ss.hasPermi('system:manage:remove')")
    @Log(title = "报表路径", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fineReportManageService.deleteFineReportManageByIds(ids));
    }
}
