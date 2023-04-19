import request from '@/utils/request'

// 查询报表路径管理列表
export function listManage(query) {
  return request({
    url: '/system/manage/list',
    method: 'get',
    params: query
  })
}

// 查询报表路径管理详细
export function getManage(id) {
  return request({
    url: '/system/manage/' + id,
    method: 'get'
  })
}

// 新增报表路径管理
export function addManage(data) {
  return request({
    url: '/system/manage',
    method: 'post',
    data: data
  })
}

// 修改报表路径管理
export function updateManage(data) {
  return request({
    url: '/system/manage',
    method: 'put',
    data: data
  })
}

// 删除报表路径管理
export function delManage(id) {
  return request({
    url: '/system/manage/' + id,
    method: 'delete'
  })
}
