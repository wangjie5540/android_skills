package com.example.net;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

public class NetHttpJson {
	private static String TAG = NetHttpJson.class.getSimpleName();
	
	private HttpClient mHttpClient = null;
	private HttpParams mHttpParams = new BasicHttpParams();
	private HttpGet mHttpGet = null;
	private HttpResponse mHttpResponse = null;

	private class NetHandlerThread extends HandlerThread {
		private final static int MSG_START_GETTING = 1;
		private boolean isLooperPrepared = false;

		private Handler handler = null;
		private String resultStr = null;
		private Callback callback = new Callback() {

			@Override
			public boolean handleMessage(Message msg) {
				switch (msg.what) {
				case MSG_START_GETTING:
					try {
						if (mHttpClient == null)
							mHttpClient = new DefaultHttpClient();
						mHttpResponse = mHttpClient.execute(mHttpGet);
						int responseCode = mHttpResponse.getStatusLine()
								.getStatusCode();
						Log.d(TAG, "responseCode:" + responseCode);
						switch (responseCode) {
						case 200:
							resultStr = EntityUtils.toString(mHttpResponse
									.getEntity());
//							Log.d(TAG, "resultStr:" + resultStr);
							try {
								JSONObject jsonObject = new JSONObject(
										resultStr);
								getInfoFromJson(jsonObject);
							} catch (JSONException e) {
								Log.w(TAG, e.toString());
							}
							mHttpClient.getConnectionManager().shutdown();
							mHttpClient = null;
							mHttpGet.abort();
							mHttpGet = null;
							break;
						case 400:
							break;
						default:
							break;
						}
					} catch (ClientProtocolException e) {
						Log.w(TAG, e.toString());
					} catch (IOException e) {
						Log.w(TAG, e.toString());
					} catch (NullPointerException e) {
						Log.w(TAG, e.toString());
					} catch (Exception e) {
						Log.w(TAG, e.toString());
					} finally {

					}
					break;
				default:
					break;
				}
				return false;
			}

		};

		private void getInfoFromJson(JSONObject object) {
			// get MediaInfo
//			if (mPlayTaskType == PlayTaskType.VOD){
//				try {
//					mMediaInfo.mediaName = object.getString("filename");
//					JSONArray gcids = object.getJSONArray("gcids");
//					mMediaInfo.mediaStreamCount = gcids.length();
//					// get StreamInfo
//					for (int i = 0; i < gcids.length(); i++) {
//						JSONObject gcidObj = gcids.getJSONObject(i);
//						StreamInfo streamInfo = new StreamInfo();
//						streamInfo.defaultStream = false;
//						streamInfo.duration = gcidObj.getInt("duration");
//						streamInfo.fileSize = gcidObj.getInt("filesize");
//						streamInfo.gcid = gcidObj.getString("gcid");
//						streamInfo.streamId = i;
//						streamInfo.streamName = gcidObj.getString("resolution");
//						mStreamInfoList.add(streamInfo);
//						String urllist = gcidObj.getString("urllist");
//						urllist = urllist.replaceAll("\\\\", "");
//						urllist = urllist.replaceAll("\"", "");
//						urllist = urllist.replaceAll("\\[", "");
//						urllist = urllist.replaceAll("\\]", "");
//						String url = urllist.split(",")[0];
////						Log.d(TAG, "url:" + url);
//						mStreamIdUrls.put(streamInfo.streamName, url);
//					}
//				} catch (JSONException e) {
//					
//				} catch (NullPointerException e) {
//
//				}
//			} else if (mPlayTaskType == PlayTaskType.LIVE){
//				try {
//					mMediaInfo.mediaName = object.getString("showname");
//					JSONArray gcids = object.getJSONArray("gcids");
//					mMediaInfo.mediaStreamCount = gcids.length();
//					// get StreamInfo
//					for (int i = 0; i < gcids.length(); i++) {
//						JSONObject gcidObj = gcids.getJSONObject(i);
//						StreamInfo streamInfo = new StreamInfo();
//						streamInfo.defaultStream = false;
//						streamInfo.gcid = gcidObj.getString("gcid");
//						streamInfo.streamName = gcidObj.getString("resolution");
//						mStreamInfoList.add(streamInfo);
//						String urllist = gcidObj.getString("urllist");
//						urllist = urllist.replaceAll("\\\\", "");
//						urllist = urllist.replaceAll("\"", "");
//						urllist = urllist.replaceAll("\\[", "");
//						urllist = urllist.replaceAll("\\]", "");
//						String url = urllist.split(",")[0];
////						Log.d(TAG, "url:" + url);
//						mStreamIdUrls.put(streamInfo.streamName, url);
//					}
//				} catch (JSONException e) {
//					
//				} catch (NullPointerException e) {
//
//				}
//			}
		}

		public NetHandlerThread(String name, int priority) {
			super(name, priority);
		}

		@Override
		protected void onLooperPrepared() {
			handler = new Handler(getLooper(), callback);
//			for (int i = 0; i < mP2PListeners.size(); i++) {
//				mP2PListeners.get(i).onInitSuccess();
//			}
			isLooperPrepared = true;
			super.onLooperPrepared();
		}

		@Override
		public void run() {
			super.run();
		}
	}
}
