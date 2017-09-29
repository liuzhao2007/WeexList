# WeexList

**关于Weex的探索记录：自定义Component、网络、下拉刷新，及问题解决的思考。**

# 一、涉及技能

1. **Weex完整开发的一个列表页。两种实现方式；**
2. **自定义Component组件，自定义控件与Weex的结合，包括下拉刷新和圆角图片；**
3. **Weex与下拉刷新的冲突解决思考思路；**
4. **完整的网络请求示例：参数、Header、Post请求等；**

# 二、项目展示

![项目展示](https://user-gold-cdn.xitu.io/2017/8/16/d87f8033f41a5de3cdf4c8849631e2d5)

# 三、项目说明
Clone项目之后可直接运行，两种下拉刷新的实现区别在于：
1. **下拉刷新写在Native，然后将Weex渲染出来的View加到下拉刷新里；**
2. **封装下拉刷新为Weex的一个组件，在Weex代码中调用，灵活性更高。**

代码目录：
- components为自定义的组件；
- adapter为基础功能的接口，此处为图片下载；
- main/assets里是Weex源文件打包生成的Js文件；
- main/weex里是Weex的源文件；

# 四、文章说明

**欢迎关注Weex系列文章，实战+源码分析！**

- [《Weex系列（一）之Weex入门准备》](http://www.jianshu.com/p/657896f60706)
- [《Weex系列（二）之列表页实战》](http://www.jianshu.com/p/64288751cfc3)
