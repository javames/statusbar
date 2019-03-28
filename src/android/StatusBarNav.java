package org.apache.cordova.statusbarnav;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

public class StatusBarNav extends CordovaPlugin {

    private static final String HIDESTATUSBAR="hideStatusNavBar";
    private static final String SHOWSTATUSBAR="showStatusNavBar";
    private static final String TAG="StatusBar";
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext){
        final Activity activity = this.cordova.getActivity();
        final Window window = activity.getWindow();
        if (action.equals(HIDESTATUSBAR)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    hideStatusBar(callbackContext,window);
                }
            });
            return true;
        }else if(action.equals(SHOWSTATUSBAR)){
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ShowStatusBar(callbackContext,window);
                }
            });
            return true;
        }
        return false;
    }

    private void hideStatusBar(CallbackContext callbackContext,Window window) {
        Log.i(TAG,"hideStatusBar");
        try{
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
                View view = window.getDecorView();
                view.setSystemUiVisibility(View.GONE);
            } else if (Build.VERSION.SDK_INT >= 19) {
                //for new api versions.
                View decorView = window.getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);

            }
            if(callbackContext!=null){
                callbackContext.success();
            }
        }catch (Exception e){
            e.printStackTrace();
            if(callbackContext!=null){
                callbackContext.error(e.getCause().toString());
            }
        }

    }

    private void ShowStatusBar(CallbackContext callbackContext,Window window){
        Log.i(TAG,"ShowStatusBar");
        try{
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
                View view = window.getDecorView();
                view.setSystemUiVisibility(View.VISIBLE);
            } else if (Build.VERSION.SDK_INT >= 19) {
                //for new api versions.
                View decorView = window.getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY ;
                decorView.setSystemUiVisibility(uiOptions);

            }
            if(callbackContext!=null){
                callbackContext.success();
            }
        }catch (Exception e){
            e.printStackTrace();
            if(callbackContext!=null){
                callbackContext.error(e.getCause().toString());
            }
        }
    }
}
