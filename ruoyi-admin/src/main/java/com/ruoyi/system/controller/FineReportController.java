package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.FineReportManage;
import com.ruoyi.system.service.IFineReportManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 报表路径Controller
 *
 * @author 林淦
 * @date 2023-05-15
 */
@RestController
@RequestMapping("/system/report")
public class FineReportController extends BaseController
{
    @Autowired
    private IFineReportManageService fineReportManageService;

    /**
     * 返回报表路径
     */
    @GetMapping("/url")
    public AjaxResult getReportUrl (@RequestParam("id") Long id)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        String userId = "&fineid="+ Long.toString(user.getUserId());
        String url = "/webroot/decision/view/report?viewlet=";
        FineReportManage fineReportManage = fineReportManageService.selectFineReportManageById(id);
        String fineReportUrl = fineReportManage.getFineReportUrl();
        String fineReportName = fineReportManage.getFineReportName()+fineReportManage.getFineReportType();
        String fineReportOp = "&op="+fineReportManage.getFineReportOp();
        if (StringUtils.isEmpty(fineReportUrl)){
            url=url+fineReportName+fineReportOp;
        }else {
            url=url+fineReportUrl+"/"+fineReportName+fineReportOp+userId;
        }
        return success(url);
    }


}
