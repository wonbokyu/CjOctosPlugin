package com.onethefull.cjoctosplugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.unity3d.player.UnityPlayer;

import org.json.JSONException;
import org.json.JSONObject;

public class CheckFireBaseDataService  extends Service {

    private FirebaseDatabase mFirebaseInstance;
    private DatabaseReference mFirebaseDatabaseRef_Wating;
    private DatabaseReference mFirebaseDatabaseRef_Order;
    //private static final String TAG = CheckFireBaseDataService.class.getSimpleName();
    private static  final String TAG = "octoscjplugin";

    public CheckFireBaseDataService() {
        super();
    }


    public void initFirebaseDatabase(){

        Log.e(TAG, "initFirebaseDatabase!" );

        mFirebaseInstance = FirebaseDatabase.getInstance();
        //database 구조 :  octosuses/cj/waiting
        mFirebaseDatabaseRef_Wating = mFirebaseInstance.getReference("cj").child("waiting");
        mFirebaseDatabaseRef_Order = mFirebaseInstance.getReference("cj").child("oneorder");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Wating
    public void checkDb_Wating(){

        // User data change listener
        mFirebaseDatabaseRef_Wating.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.e(TAG, "onDataChange!!!" );

                String key ;
                String app_id ;
                String lang ;
                String reqDevice ;
                String showImgCode ;
                String speakStr;
                String use_yn ;

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    //  Toast.makeText(getApplicationContext(),dsp.getKey(),Toast.LENGTH_SHORT).show();
                    //  Toast.makeText(getApplicationContext(),String.valueOf(dsp.child("user").getValue()),Toast.LENGTH_SHORT).show();

                    if(dsp.child("use_yn").getValue() != null && dsp.child("use_yn").getValue().equals("n"))
                    {
                        Log.e(TAG, "key : " + dsp.getKey()  );
                        Log.e(TAG, "app_id : " + dsp.child("app_id").getValue() );
                        Log.e(TAG, "lang : " + dsp.child("lang").getValue() );
                        Log.e(TAG, "reqDevice : " + dsp.child("reqDevice").getValue() );
                        Log.e(TAG, "showImgCode : " + dsp.child("showImgCode").getValue() );
                        Log.e(TAG, "speakStr : " + dsp.child("speakStr").getValue() );
                        Log.e(TAG, "use_yn : " + dsp.child("use_yn").getValue() );

                        key = dsp.getKey();
                        app_id = dsp.child("app_id").getValue().toString() ;
                        lang  = dsp.child("lang").getValue().toString() ;
                        reqDevice= dsp.child("reqDevice").getValue().toString() ;
                        showImgCode = dsp.child("showImgCode").getValue().toString() ;
                        speakStr = dsp.child("speakStr").getValue().toString() ;
                        use_yn = dsp.child("use_yn").getValue().toString() ;

                        ///////////////////////////////////////////////////////////////////////////////

                        updateDb_Waiting(key,app_id,lang,reqDevice,showImgCode,speakStr,use_yn);

                        ///////////////////////////////////////////////////////////////////////////////
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });

    }
    public void updateDb_Waiting(String key,String app_id, String lang, String reqDevice, String showImgCode , String speakStr , String use_yn)
    {
        Log.e(TAG, "Update updateDb_Order DB ! ");
        mFirebaseDatabaseRef_Wating.child(key).child("use_yn").setValue("y");
        sendMessageToUnity_Waiting(showImgCode ,  speakStr);

    }

    public void sendMessageToUnity_Waiting(String showImgCode , String speakStr)
    {
        try{
            JSONObject sObject = new JSONObject();
            sObject.put("showImgCode", showImgCode);
            sObject.put("speakStr", speakStr);

            Log.e(TAG, "sendMessageToUnity_Waiting :  " + sObject.toString() );
           UnityPlayer.UnitySendMessage("CJ_OCTOS_DEMO","waiting",sObject.toString());

        }catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Order
    public void checkDb_Order(){

        // User data change listener
        mFirebaseDatabaseRef_Order.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.e(TAG, "onDataChange!!!" );

                String key ;
                String app_id ;
                String lang ;
                String reqDevice ;
                String showImgCode ;
                String speakStr;
                String use_yn ;

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    //  Toast.makeText(getApplicationContext(),dsp.getKey(),Toast.LENGTH_SHORT).show();
                    //  Toast.makeText(getApplicationContext(),String.valueOf(dsp.child("user").getValue()),Toast.LENGTH_SHORT).show();

                    if(dsp.child("use_yn").getValue() != null && dsp.child("use_yn").getValue().equals("n"))
                    {
                        Log.e(TAG, "key : " + dsp.getKey()  );
                        Log.e(TAG, "app_id : " + dsp.child("app_id").getValue() );
                        Log.e(TAG, "lang : " + dsp.child("lang").getValue() );
                        Log.e(TAG, "reqDevice : " + dsp.child("reqDevice").getValue() );
                        Log.e(TAG, "showImgCode : " + dsp.child("showImgCode").getValue() );
                        Log.e(TAG, "speakStr : " + dsp.child("speakStr").getValue() );
                        Log.e(TAG, "use_yn : " + dsp.child("use_yn").getValue() );

                        key = dsp.getKey();
                        app_id = dsp.child("app_id").getValue().toString() ;
                        lang  = dsp.child("lang").getValue().toString() ;
                        reqDevice= dsp.child("reqDevice").getValue().toString() ;
                        showImgCode = dsp.child("showImgCode").getValue().toString() ;
                        speakStr = dsp.child("speakStr").getValue().toString() ;
                        use_yn = dsp.child("use_yn").getValue().toString() ;

                        ///////////////////////////////////////////////////////////////////////////////

                        updateDb_Order(key,app_id,lang,reqDevice,showImgCode,speakStr,use_yn);

                        ///////////////////////////////////////////////////////////////////////////////
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });

    }
    public void updateDb_Order(String key,String app_id, String lang, String reqDevice, String showImgCode , String speakStr , String use_yn)
    {
        Log.e(TAG, "Update updateDb_Order DB ! ");
        mFirebaseDatabaseRef_Wating.child(key).child("use_yn").setValue("y");
        sendMessageToUnity_Order(showImgCode ,  speakStr);

    }

    public void sendMessageToUnity_Order(String showImgCode , String speakStr)
    {
        try{
            JSONObject sObject = new JSONObject();
            sObject.put("showImgCode", showImgCode);
            sObject.put("speakStr", speakStr);

            Log.e(TAG, "sendMessageToUnity_oneorder :  " + sObject.toString() );

            UnityPlayer.UnitySendMessage("CJ_OCTOS_DEMO","oneorder",sObject.toString());

        }catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        initFirebaseDatabase();
        checkDb_Order();
        checkDb_Wating();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

}