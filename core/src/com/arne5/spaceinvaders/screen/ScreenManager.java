package com.arne5.spaceinvaders.screen;

/**
 * Created by darneson on 8/13/2014.
 */
public class ScreenManager
	{
		private static Screen currentScreen;
		public static void setScreen(Screen screen)
			{

				if (currentScreen !=null)
					{
						currentScreen.dispose();
					}
				currentScreen = screen;
				currentScreen.create();


			}
		public static Screen getCurrentScreen()
		{
			return currentScreen;
		}
	}
