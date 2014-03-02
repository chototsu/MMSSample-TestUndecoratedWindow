package com.example

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.util.Log
import android.content.Intent
import com.jme3.app.AndroidHarness
import com.jme3.system.android.AndroidConfigChooser.ConfigType
import android.content.pm.ActivityInfo
import projectkyoto.jme3.mmd.{VMDLoader, PMDLoaderGLSLSkinning2}
import com.jme3.texture.plugins.AndroidImageLoader
import com.typesafe.scalalogging.slf4j._
import org.slf4j.LoggerFactory;

object MainActivity {
  System.loadLibrary("bulletjme");
  def loadLibrary() {
  }
}
class MainActivity extends AndroidHarness with Logging{
  appClass = "com.example.app.MainApp";
  eglConfigType = ConfigType.BEST
  eglConfigVerboseLogging = false
  screenOrientation = ActivityInfo.SCREEN_ORIENTATION_NOSENSOR
  screenFullScreen = false
  screenShowTitle = true
  MainActivity.loadLibrary()
  /** Called when the activity is first created. */
  override def onCreate(savedInstanceState: Bundle) {
    logger.info("start")
    super.onCreate(savedInstanceState)
    val app = new com.example.app.MainApp
    setContentView(view);
  }
}
