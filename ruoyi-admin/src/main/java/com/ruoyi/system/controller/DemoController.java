package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.Demo;
import com.ruoyi.system.domain.FineReportManage;
import com.ruoyi.system.service.IDemoService;
import com.ruoyi.system.service.IFineReportManageService;
import com.ruoyi.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 报表路径Controller
 *
 * @author 林淦
 * @date 2023-05-15
 */
@RestController
@RequestMapping("/system/demo")
public class DemoController extends BaseController
{


    @Autowired
    IFineReportManageService fineReportManageService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    IDemoService demoService;

    @GetMapping("/d1")
    public Demo demo1 (Demo demo)
    {
        Long hk = demo.getHk();
        demo.setXlk(Long.toString(hk));
        return demo;
    }

    @GetMapping("/fineNameList")
    public TableDataInfo list(FineReportManage fineReportManage){
        List<FineReportManage> fineReportManages = fineReportManageService.selectFineReportManageList(fineReportManage);
        return getDataTable(fineReportManages);
    }

    @GetMapping("/menuList")
    public List<String> menuList(SysMenu menu){
        List<SysMenu> menus = menuService.selectMenuIdListByParenId(0);
        List<SysMenu> sysMenuNames = menuService.selectMenuListByParenId(menus);
        List<String> menuName = new ArrayList<String>();
        for (SysMenu sysMenuName : sysMenuNames) {
            menuName.add(sysMenuName.getMenuName());
        }
        return menuName;
    }

    @GetMapping("/dd")
    public List<SysMenu> d2(){
        List<SysMenu> sysMenus = demoService.selectMenuListByParenId();
        return sysMenus;
    }
}
