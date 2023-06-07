package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 报表路径管理对象 fine_report_manage
 * 
 * @author 林淦
 * @date 2023-04-18
 */

@Data
public class Demo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 滑块 */
    private Long hk;

    /** 下拉框 */
    @Excel(name = "下拉框")
    private String xlk;

}
