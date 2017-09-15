package com.ismartv.android.vod.service;

import android.app.Instrumentation;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyNativeService extends Service {

	private void moniteKeyEvent(final int paramInt) {
		new Thread(new Runnable() {
			public void run() {
				new Instrumentation().sendKeyDownUpSync(paramInt);
			}
		}).start();
	}

	@Override
	public IBinder onBind(Intent paramIntent) {
		return new MyServiceImpl();
	}

	public void onCreate() {
		super.onCreate();
	}

	public class MyServiceImpl extends ISmartvNativeService.Stub {
		@Override
		public void sendMoniterKey(int paramInt) throws RemoteException {
			moniteKeyEvent(paramInt);
		}
	}

}
