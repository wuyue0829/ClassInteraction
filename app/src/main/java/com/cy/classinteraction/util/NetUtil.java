package com.cy.classinteraction.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.cy.classinteraction.R;

public class NetUtil {

	/**
	 * 判断是否有网络连接
	 * @param context
	 * @return
	 */
	public static boolean isNetworkConnected(Context context) {
	      if (context != null) {  
	          ConnectivityManager mConnectivityManager = (ConnectivityManager) context
	                  .getSystemService(Context.CONNECTIVITY_SERVICE);  
	          NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
	          if (mNetworkInfo != null) {  
	              return mNetworkInfo.isAvailable();  
	          }  
	          Toast.makeText(context.getApplicationContext(),
					  R.string.e_net, Toast.LENGTH_LONG).show();
	      }  
	      return false;  
	} 
	/**
	 * 判断是否有网络连接
	 * @param context
	 * @return
	 */
	public static boolean isNetworkConnected2(Context context) {  
		if (context != null) {  
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context  
					.getSystemService(Context.CONNECTIVITY_SERVICE);  
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();  
			if (mNetworkInfo != null) {  
				return mNetworkInfo.isAvailable();  
			}  
		}  
		return false;  
	} 
	/**
	 * 判断WIFI网络是否可用
	 * @param context
	 * @return
	 */
	public boolean isWifiConnected(Context context) {  
	      if (context != null) {  
	          ConnectivityManager mConnectivityManager = (ConnectivityManager) context  
	                  .getSystemService(Context.CONNECTIVITY_SERVICE);  
	          NetworkInfo mWiFiNetworkInfo = mConnectivityManager  
	                  .getNetworkInfo(ConnectivityManager.TYPE_WIFI);  
	          if (mWiFiNetworkInfo != null) {  
	              return mWiFiNetworkInfo.isAvailable();  
	          }  
	          Toast.makeText(context.getApplicationContext(),
						R.string.e_net,Toast.LENGTH_LONG).show();
	      }  
	      return false;  
	}  
}
