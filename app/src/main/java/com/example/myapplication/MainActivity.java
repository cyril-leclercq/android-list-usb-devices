package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;

import java.util.Collection;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(() -> {
            UsbManager m = (UsbManager)getApplicationContext().getSystemService(USB_SERVICE);
            HashMap<String, UsbDevice> usbDevices = m.getDeviceList();
            Collection<UsbDevice> ite = usbDevices.values();
            UsbDevice[] usbs = ite.toArray(new UsbDevice[]{});
            for (UsbDevice usb : usbs) {
                Log.i("Connected usb devices","Connected usb devices are "+ usb.getProductName());
            }
        }).start();
    }
}