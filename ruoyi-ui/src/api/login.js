import request from '@/utils/request'

// 登录方法
export function login(username, password, code, uuid) {
  const data = {
    username,
    password,
    code,
    uuid
  }
  request({
      url: 'http://120.77.76.208/webroot/decision/login/cross/domain?fine_username=root&fine_password=wrvY7quMcv5gS1ywv6ayFA%3D%3D&encrypted=true&validity=-1',
      method: 'get',
      //data: { validity: '-1', fine_username: 'root', fine_password: 'lg807050' } // 指定第二个请求的参数
    })
  return request({
    url: '/login',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}

// 注册方法
export function register(data) {
  return request({
    url: '/register',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}

// 获取用户详细信息
export function getInfo() {
  return request({
    url: '/getInfo',
    method: 'get'
  })
}

// 退出方法
export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}

// 获取验证码
export function getCodeImg() {
  return request({
    url: '/captchaImage',
    headers: {
      isToken: false
    },
    method: 'get',
    timeout: 20000
  })
}