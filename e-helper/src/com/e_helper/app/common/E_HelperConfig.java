package com.e_helper.app.common;

import com.e_helper.app.model.Config;


public class E_HelperConfig {
	
	private static E_HelperConfig instanceAppSettings;
	private int screenWith;
	private String installationId;
	private Config avConfig;
	public static E_HelperConfig getAppConfigs() {
		if (null == instanceAppSettings) {
			instanceAppSettings  = new E_HelperConfig();
		}
		return instanceAppSettings;
	}
	
	
	public Config getAvConfig() {
		return avConfig;
	}


	public void setAvConfig(Config avConfig) {
		this.avConfig = avConfig;
	}


	public String getInstallationId() {
		return installationId;
	}


	public void setInstallationId(String installationId) {
		this.installationId = installationId;
	}


	public int getScreenWith() {
		return screenWith;
	}
	public void setScreenWith(int screenWith) {
		this.screenWith = screenWith;
	}

}
