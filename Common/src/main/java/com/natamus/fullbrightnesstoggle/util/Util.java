package com.natamus.fullbrightnesstoggle.util;

import com.natamus.collective.functions.DataFunctions;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {
	private static final String configDirPath = DataFunctions.getConfigDirectory() + File.separator + Reference.MOD_ID;
	private static final File configDir = new File(configDirPath);
	private static final String stateConfigFilePath = configDirPath + File.separator + "laststate.txt";
	private static final File stateConfigFile = new File(stateConfigFilePath);

	public static void saveLastStateToConfig(boolean fullBright) {
		if (!configDir.isDirectory() || !stateConfigFile.isFile()) {
			boolean ignored = configDir.mkdirs();
		}

		try {
			PrintWriter configWriter = new PrintWriter(stateConfigFilePath, StandardCharsets.UTF_8);

			configWriter.print("fullbright=" + (fullBright ? 1 : 0));
			configWriter.close();
		}
		catch (IOException ignored) {}
	}

	public static boolean wasLastStateFullBright() {
		if (!configDir.isDirectory() || !stateConfigFile.isFile()) {
			return false;
		}

		try {
			String stateConfigContent = new String(Files.readAllBytes(Paths.get(stateConfigFilePath, new String[0]))).strip();
			return stateConfigContent.replace("fullbright=", "").equals("1");
		}
		catch (IOException ignored) { }

		return false;
	}
}
