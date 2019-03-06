package org.apache.cordova.statusbar;

import android.app.Activity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class StatusBar extends CordovaPlugin {

    private static final String HIDESTATUSBAR="hideStatusBar";
    private static final String SHOWSTATUSBAR="showStatusBar";
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
            WindowManager.LayoutParams params = window.getAttributes();
            params.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            window.setAttributes(params);
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
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
            WindowManager.LayoutParams params = window.getAttributes();
            params.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            window.setAttributes(params);
            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
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
