package com.health_conciencia;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import static com.blitzapp.animatedsplash.animation.AddImageView.FIT_XY;
import static com.blitzapp.animatedsplash.animation.AddImageView.getCenterX;
import static com.blitzapp.animatedsplash.animation.AddImageView.getCenterY;
import static com.blitzapp.animatedsplash.animation.GroupAnimation.splash;
import static com.blitzapp.animatedsplash.animation.Splash.FADE;
import static com.blitzapp.animatedsplash.animation.Splash.SLIDE;
import static com.blitzapp.animatedsplash.animation.Splash.performSingleAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideDelay;
import static com.blitzapp.animatedsplash.animation.Splash.splashShow;

import android.os.Bundle;


public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
@Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initiateSplash();
  }
  public void initiateSplash() {
    splash.createSplashView(MainActivity.this);
    setSplashHideAnimation(SLIDE);
    setSplashHideDelay(1500);

    AddImageView image1 = new AddImageView(R.drawable.background, screenHeight * 1, screenWidth * 1, getCenterX(screenWidth * 1), getCenterY(screenHeight * 1), FIT_XY, false);
    AddImageView image2 = new AddImageView(R.drawable.logo, screenHeight * 0.25, screenWidth * 0.52, getCenterX(screenWidth * 0.52), getCenterY(screenHeight * -0.29), FIT_XY, false);

    performSingleAnimation(image1, FADE, 500, 0f, 1f);
    performSingleAnimation(image2, FADE, 400, 0f, 1f);

    splashShow();
  }

  @Override
  protected String getMainComponentName() {
    return "Health_conciencia";
  }

  /**
   * Returns the instance of the {@link ReactActivityDelegate}. Here we use a util class {@link
   * DefaultReactActivityDelegate} which allows you to easily enable Fabric and Concurrent React
   * (aka React 18) with two boolean flags.
   */
  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new DefaultReactActivityDelegate(
        this,
        getMainComponentName(),
        // If you opted-in for the New Architecture, we enable the Fabric Renderer.
        DefaultNewArchitectureEntryPoint.getFabricEnabled(), // fabricEnabled
        // If you opted-in for the New Architecture, we enable Concurrent React (i.e. React 18).
        DefaultNewArchitectureEntryPoint.getConcurrentReactEnabled() // concurrentRootEnabled
        );
  }
}
