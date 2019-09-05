package com.onethefull.cjoctosplugin;

import android.content.Context;
import android.os.Build;

import com.unity3d.player.UnityPlayer;

public class UnityPluginMainClass {

    private static UnityPluginMainClass m_instance;
    private  Context context;

    public static UnityPluginMainClass instance(){
        if(m_instance == null ) {
            m_instance = new UnityPluginMainClass();
        }
        return m_instance;
    }
    private void setContext(Context context){
        this.context = context;
    }

    private void AndroidVersionCheck(String objName,String objMethod){
        UnityPlayer.UnitySendMessage(objName , objMethod , Build.VERSION.RELEASE);
    }
}
