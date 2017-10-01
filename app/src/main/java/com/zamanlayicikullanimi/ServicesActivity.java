package com.zamanlayicikullanimi;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Windows10 on 1.10.2017.
 */

public class ServicesActivity extends Service {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("deger");


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

       Thread zamanlayici = new Thread();
        final int[] a = new int[1];
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                a[0] =Integer.parseInt(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        try {
            a[0]= a[0]*1000;
            a[0]=a[0]*1000;
            zamanlayici.sleep(a[0]);

            MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.asd);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(),"Servis Bitir",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


}
