import request from '@/utils/request'

// 获取URL
export function getUrl(id) {
  return request({
    url: '/system/dim/url?id='+id,
    method: 'get',
	// data: id
  })
}