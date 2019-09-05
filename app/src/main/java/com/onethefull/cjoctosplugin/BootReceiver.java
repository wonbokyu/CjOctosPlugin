package com.onethefull.cjoctosplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public  class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        // 전달 받은 Broadcast의 값을 가져오기
        // androidmanifest.xml에 정의한 인텐트 필터를 받아 올 수 있습니다.
        String action = intent.getAction();
        // 전달된 값이 '부팅완료' 인 경우에만 동작 하도록 조건문을 설정 해줍니다.
        if (action.equals("android.intent.action.BOOT_COMPLETED")) {

            try{
                /////////////////////////////////////////////////////////////////////
                // Service 실행
                Intent intent_ = new Intent(context,CheckFireBaseDataService.class);
                context.startService(intent_);

            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

        }
    }
}
