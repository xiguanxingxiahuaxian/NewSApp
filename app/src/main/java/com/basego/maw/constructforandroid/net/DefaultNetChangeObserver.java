package com.basego.maw.constructforandroid.net;

import android.content.Context;
import android.widget.Toast;


public class DefaultNetChangeObserver extends NetChangeObserver {
    Context context;

    public DefaultNetChangeObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onConnect(NetWorkUtil.NetType type) {
        super.onConnect(type);
        switch (type) {
            case NETWORK_2_G:
                break;
            case NETWORK_WIFI:
                Toast.makeText(context, "网络已连接", Toast.LENGTH_SHORT).show();
                break;
            case NETWORK_4_G:
                break;
            case NETWORK_3_G:
                break;
            default:
                break;

        }

    }

    @Override
    public void onDisConnect() {
        super.onDisConnect();
        Toast.makeText(context, "网络已断开", Toast.LENGTH_SHORT).show();
    }
}
