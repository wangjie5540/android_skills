package com.example.jni_demo;

public class NativeCenter {
	private static NativeCenter mNativeCenter = null;
	static {
		try {
			System.loadLibrary("native_center");
		} catch (Exception e) {
		}
		
	}
	
	private NativeCenter(){
		
	}
	
	public static NativeCenter getInstance(){
		synchronized (NativeCenter.class) {
            if (mNativeCenter == null) {
            	mNativeCenter = new NativeCenter();
            }
        }
		return mNativeCenter;
	}
	
	public native void void_call(NativeTest n);
}
