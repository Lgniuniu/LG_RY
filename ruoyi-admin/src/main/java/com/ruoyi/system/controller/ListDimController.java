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