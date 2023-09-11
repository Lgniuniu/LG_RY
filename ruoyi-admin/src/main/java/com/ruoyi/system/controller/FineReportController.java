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
        //获取登入用户账号信息
        SysUser user = SecurityUtils.getLoginUser().getUser();
        //把用户ID通过URL传参进去
        String userId = "&fineid="+ Long.toString(user.getUserId());
        //初始化报表链接
        String url = "/webroot/decision/view/report?viewlet=";
        //获取报表配置的信息
        FineReportManage fineReportManage = fineReportManageService.selectFineReportManageById(id);
        //获取信息中的报表URL
        String fineReportUrl = fineReportManage.getFineReportUrl();
        //获取报表的名称+报表类型    报表名称: demo  报表类型:  .cpt
        String fineReportName = fineReportManage.getFineReportName()+fineReportManage.getFineReportType();
        //获取报表 浏览类型：填报预览  数据分析预览。。。
        String fineReportOp = "&op="+fineReportManage.getFineReportOp();
        //判断是否为空
        if (StringUtils.isEmpty(fineReportUrl)){
            url=url+fineReportName+fineReportOp;
        }else {
            url=url+fineReportUrl+"/"+fineReportName+fineReportOp+userId;
        }
        //返回完整报表路径
        return success(url);
    }


}
