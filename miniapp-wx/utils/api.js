// utils/api.js
const app = getApp()

/**
 * 封装请求方法
 */
const request = (url, method = 'GET', data = {}) => {
  return new Promise((resolve, reject) => {
    wx.request({
      url: `${app.globalData.apiBaseUrl}${url}`,
      method,
      data,
      header: {
        'Content-Type': 'application/json'
      },
      success: (res) => {
        if (res.statusCode >= 200 && res.statusCode < 300) {
          resolve(res.data)
        } else {
          reject(res)
        }
      },
      fail: reject
    })
  })
}

module.exports = {
  request,
  // API 接口
  getHello: () => request('/api/hello'),
  getUser: () => request('/api/user'),
  postData: (data) => request('/api/data', 'POST', data)
}
