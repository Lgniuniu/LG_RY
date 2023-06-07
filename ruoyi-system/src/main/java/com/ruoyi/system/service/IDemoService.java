package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.SysMenu;

import java.util.List;

public interface IDemoService {

    /**
     * 根据父ID查询系统菜单列表
     *
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuListByParenId();
}
