package com.arne5.spaceinvaders.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class DesktopLauncher {
	public static void main (String[] arg) {

		TexturePacker.Settings settings = new TexturePacker.Settings();
		TexturePacker.process(settings, "C:/Development/github/spaceinvaders/spaceimages","C:/Development/github/spaceinvaders/android/assets","pack");



		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SpaceInvaders(), config);
	}
}
