package com.example.himel.servicepractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public   class ServiceThread implements Runnable{
        int serviceid;

        public ServiceThread(int serviceid){
            this.serviceid =serviceid;
        }

        @Override
        public void run() {
            for (int i=0;i<=10 ; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopSelf(this.serviceid);
            }

        }

    }



    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
    }


    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Toast.makeText(this,"Service is running",Toast.LENGTH_LONG).show();
        ServiceThread thread = new ServiceThread(startId);
        Thread mainthread = new Thread(thread);
        mainthread.start();

        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }



}
