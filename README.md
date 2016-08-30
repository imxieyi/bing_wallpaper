# Bing Wallpaper Tool

This is a Bing Wallpaper Tool written in Java.

**JNA library** is required. You can get it [there][1].
**JSON-java** is used to save settings. You can get it [there][2].

Currently it only supports **Windows** Platform. It runs smoothly on **Windows 10 x86** and **Windows 10 x64**. **Other verions are untested.**

.java file description:

 - **AboutFrame.java:** An about dialog. You can feel free to delete or modify it.
 - **GetWallPaper.java:** Provide access to Bing Wallpaper API.
 - **MainFrame.java:** The old version of UI. It can be set to auto run on startup.
 - **NewUI.java:** The new version of UI. It doesn't need any 3rd-party lookandfeel. The UI resources is under **/res** directory.
 - **Settings.java:** Unfinished settings panel.

  [1]: https://github.com/java-native-access/jna
  [2]: https://github.com/stleary/JSON-java
