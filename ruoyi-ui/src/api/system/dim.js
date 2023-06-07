import request from '@/utils/request'

// 获取URL
export function getUrl(id) {
  return request({
    url: '/system/report/url?id='+id,
    method: 'get',
	// data: id
  })
}
