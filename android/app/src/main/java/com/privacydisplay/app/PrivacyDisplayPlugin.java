package com.privacydisplay.app;

import android.content.Intent;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "PrivacyDisplay")
public class PrivacyDisplayPlugin extends Plugin {

    @PluginMethod
    public void startService(PluginCall call) {
        Intent intent = new Intent(getContext(), PrivacyService.class);
        getContext().startForegroundService(intent);
        JSObject ret = new JSObject();
        ret.put("success", true);
        call.resolve(ret);
    }

    @PluginMethod
    public void stopService(PluginCall call) {
        Intent intent = new Intent(getContext(), PrivacyService.class);
        getContext().stopService(intent);
        JSObject ret = new JSObject();
        ret.put("success", true);
        call.resolve(ret);
    }

    @PluginMethod
    public void recalibrate(PluginCall call) {
        Intent intent = new Intent(getContext(), PrivacyService.class);
        intent.setAction("RECALIBRATE");
        getContext().startForegroundService(intent);
        JSObject ret = new JSObject();
        ret.put("success", true);
        call.resolve(ret);
    }
}
