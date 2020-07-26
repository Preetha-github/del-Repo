package com.orangeHRUtilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/Config.properties");

		try {
			FileInputStream fir = new FileInputStream(src);

			pro = new Properties();

			pro.load(fir);

		} catch (Exception e) {

			System.out.println("Exception message : " + e.getMessage());
		}
	}

	public String getbaseurl() {

		String baseurl = pro.getProperty("baseurl");
		return baseurl;
	}

	public String getusername() {

		String uname = pro.getProperty("username");
		return uname;
	}

	public String getpassword() {

		String pword = pro.getProperty("password");
		return pword;
	}

	public String getchromepath() {

		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getfirefoxpath() {

		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}