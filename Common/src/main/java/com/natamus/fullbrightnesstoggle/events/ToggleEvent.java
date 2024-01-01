package com.natamus.fullbrightnesstoggle.events;

import com.natamus.collective.functions.GameSettingsFunctions;
import com.natamus.fullbrightnesstoggle.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.ChatScreen;

public class ToggleEvent {
	private static final Minecraft mc = Minecraft.getInstance();
	private static double initialGamma = -1;
	private static final double maxGamma = 14.0F % 28.0F + 1.0F;

	public static void onMainMenuLoaded() {
		Options options = mc.options;

		initialGamma = GameSettingsFunctions.getGamma(options);

		if (Util.wasLastStateFullBright()) {
			GameSettingsFunctions.setGamma(options, maxGamma);
		}
	}

	public static void onHotkeyPress() {
		if (mc.screen instanceof ChatScreen) {
			return;
		}

		Options options = mc.options;
		if (initialGamma < 0) {
			if (GameSettingsFunctions.getGamma(options) >= 1.0F) {
				initialGamma = 1.0F;
				GameSettingsFunctions.setGamma(options, 1.0F);
			}
			else {
				initialGamma = GameSettingsFunctions.getGamma(options);
			}
		}

		boolean fullBright = false;
		if (GameSettingsFunctions.getGamma(options) != initialGamma && GameSettingsFunctions.getGamma(options) != maxGamma) {
			initialGamma = GameSettingsFunctions.getGamma(options);
			fullBright = true;
		}

		if (GameSettingsFunctions.getGamma(options) == initialGamma || fullBright) {
			GameSettingsFunctions.setGamma(options, maxGamma);
			Util.saveLastStateToConfig(true);
		}
		else {
			GameSettingsFunctions.setGamma(options, initialGamma);
			Util.saveLastStateToConfig(false);
		}
	}
}
