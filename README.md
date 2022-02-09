# Mobile Test Automation with Appium 2.0 and Java

![image](https://user-images.githubusercontent.com/89974862/153133957-3933a9b3-38da-4784-90ca-918c6ee1ceab.png)

**Youtube Webinar Video**

https://www.youtube.com/watch?v=Tk_e6onks54

***

**Requirements:**

Java JDK 11 installation

Homebrew installation

NodeJS installation

IntelliJ IDEA CE Installation

Appium Server v2.0.0-beta.25 installation (Required for Mobile TestRun & Debugging)

Appium Desktop v1.22 installation (Optional)

Appium Inspector v2022.1.2 installation (Required for Debugging the Apps)

Android Studio installation (Required for Android Emulator access)

Xcode installation (Required for iOS Simulator access)

***

**Appium Server & Driver Installation**

```
npm install -g appium@next
appium driver install uiautomator2
appium driver install xcuitest
```
***

**Appium Plugin Installation**

```
appium plugin install --source=npm appium-wait-plugin
appium plugin install --source=npm appium-device-farm
appium plugin install --source=npm appium-dashboard
```

**Appium Wait Plugin Activation**
```
source ~/.bash_profile
appium --use-plugins element-wait
```

**Appium Device Farm Plugin Activation**
```
source ~/.bash_profile
appium server -ka 800 --use-plugins=element-wait,device-farm,appium-dashboard --plugin-device-farm-platform=Android
```
***
