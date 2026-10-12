package com.serilum.fullbrightnesstoggle.events;

import com.natamus.collective.functions.GameSettingsFunctions;
import com.serilum.fullbrightnesstoggle.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;

public class ToggleEvent {
	private static final Minecraft mc = Minecraft.getInstance();
	private static double initialGamma = -1;
	private static final double maxGamma = 14.0F % 28.0F + 1.0F;
	private static boolean restoreFullBrightAfterSave = false;

	public static void onMainMenuLoaded() {
		if (initialGamma >= 0) {
			return;
		}

		Options options = mc.options;

		initialGamma = Math.min(GameSettingsFunctions.getGamma(options), 1.0F);

		if (Util.wasLastStateFullBright()) {
			GameSettingsFunctions.setGamma(options, maxGamma);
		}
	}

	// options.txt only accepts a gamma up to 1.0, so the player's own brightness is written instead of being dropped.
	public static void onOptionsSaveStart(Options options) {
		if (initialGamma < 0 || GameSettingsFunctions.getGamma(options) != maxGamma) {
			return;
		}

		GameSettingsFunctions.setGamma(options, initialGamma);
		restoreFullBrightAfterSave = true;
	}

	public static void onOptionsSaveEnd(Options options) {
		if (!restoreFullBrightAfterSave) {
			return;
		}

		GameSettingsFunctions.setGamma(options, maxGamma);
		restoreFullBrightAfterSave = false;
	}

	public static void onHotkeyPress() {
		if (mc.gui.screen() != null) {
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
