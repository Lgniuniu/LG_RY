import request from '@/utils/request'

// 查询维度列表列表
export function listDim(query) {
  return request({
    url: '/system/dim/list',
    method: 'get',
    params: query
  })
}

// 查询维度列表详细
export function getDim(dim) {
  return request({
    url: '/system/dim/' + dim,
    method: 'get'
  })
}

// 新增维度列表
export function addDim(data) {
  return request({
    url: '/system/dim',
    method: 'post',
    data: data
  })
}

// 修改维度列表
export function updateDim(data) {
  return request({
    url: '/system/dim',
    method: 'put',
    data: data
  })
}

// 删除维度列表
export function delDim(dim) {
  return request({
    url: '/system/dim/' + dim,
    method: 'delete'
  })
}
