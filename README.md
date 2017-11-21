# react-native-feedback

#### 基于阿里云封装的App反馈平台，【一行代码，双平台反馈】


【 Android 平台配置 】

1. 添加依赖文件

（1）将libs文件夹Copy到android / app 目录下
（2）打开android / app目录下的build.gradle文件，添加如下代码：

```xml
compile(name: 'alicloud-android-feedback-3.1.1', ext: 'aar')  
compile files('libs/alicloud-android-monitor-2.5.1.1_for_bc_proguard.jar')  
compile files('libs/utdid4all-1.1.5.3_proguard.jar')  
compile files('libs/alicloud-android-utils-1.1.1.jar') 
```

2.将feedback文件夹Copy到你的工程android目录的src下的包名目录下（注意：如果文件夹下的类文件报错，要将import的目录改成自己对应的包名即可）


【 iOS 平台配置 】

1. 添加依赖

（1）添加系统公共库：
```xml
libz.tbd  
libresolv.tbd  
libsqlite3.tbd  
CoreMotion.framework  
CoreTelephony.framework  
SystemConfiguration.framework  
```
根据名字搜索，添加即可。

（2）在 info.plist 中添加如下字段
```xml
<key>NSCameraUsageDescription</key>  
<string>访问相机</string>  
<key>NSPhotoLibraryUsageDescription</key>  
<string>访问相册</string>  
```
（3）将ios_feedback文件夹添加到工程中


【使用】

1. 引入桥接
```javascript
import {  
  NativeModules  
} from 'react-native'  
```

2. 打开反馈界面
```javascript
// openFeedbackActivity方法中可以传递json对象，用于向反馈平台传递额外参数信息。例如，传递设备信息：
let phone = {
  platform: 'android'
}
NativeModules.feedbackModule.openFeedbackActivity(phone) 

没有则传null即可。
NativeModules.feedbackModule.openFeedbackActivity(null) 
```
