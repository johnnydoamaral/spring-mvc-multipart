package com.johnny.springmultipart;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("files-path")
public class FileStoringProperties {

	private String saveLocation = "/Users/jaribeiro/Downloads";

	public String getSaveLocation() {
		return saveLocation;
	}

	public void setSaveLocation(String saveLocation) {
		this.saveLocation = saveLocation;
	}

}
