// pages/index/index.js
const app = getApp()

Page({
  data: {
    message: '点击按钮获取数据',
    userInfo: null,
    apiUrl: ''
  },

  onLoad() {
    this.setData({
      apiUrl: app.globalData.apiBaseUrl
    })
    // 页面加载时自动获取问候
    this.fetchHello()
  },

  // 获取问候消息
  fetchHello() {
    wx.request({
      url: `${app.globalData.apiBaseUrl}/api/hello`,
      method: 'GET',
      success: (res) => {
        if (res.statusCode === 200) {
          this.setData({
            message: res.data.message
          })
        }
      },
      fail: (err) => {
        wx.showToast({
          title: '请求失败',
          icon: 'error'
        })
        console.error('请求失败:', err)
      }
    })
  },

  // 获取用户信息
  fetchUserInfo() {
    wx.request({
      url: `${app.globalData.apiBaseUrl}/api/user`,
      method: 'GET',
      success: (res) => {
        if (res.statusCode === 200) {
          this.setData({
            userInfo: res.data
          })
          wx.showToast({
            title: '获取成功',
            icon: 'success'
          })
        }
      },
      fail: (err) => {
        wx.showToast({
          title: '请求失败',
          icon: 'error'
        })
        console.error('请求失败:', err)
      }
    })
  }
})
