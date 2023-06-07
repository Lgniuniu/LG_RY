package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.system.mapper.DemoMapper;
import com.ruoyi.system.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    DemoMapper demoMapper;

    @Override
    public List<SysMenu> selectMenuListByParenId() {
        List<SysMenu> sysMenus = demoMapper.selectList(null);
        return sysMenus;
    }
}
