package com.arne5.spaceinvaders;

import com.arne5.spaceinvaders.screen.GameScreen;
import com.arne5.spaceinvaders.screen.GameScreen;
import com.arne5.spaceinvaders.screen.GameStartScreen;
import com.arne5.spaceinvaders.screen.ScreenManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceInvaders extends ApplicationAdapter
	{
		public static int WIDTH =480,HEIGHT =800;

		public Preferences prefs;


		private SpriteBatch batch;

	
	@Override
	public void create ()
		{
			batch = new SpriteBatch();
			prefs =  Gdx.app.getPreferences("GamePref");

			//ScreenManager.setScreen(new GameScreen());
			//try new game with using atlas


			ScreenManager.setScreen(new GameStartScreen());

			//ScreenManager.setScreen(new GameScreen());


		}
	@Override
	public void dispose()
		{
			if (ScreenManager.getCurrentScreen() !=null)
				{
					ScreenManager.getCurrentScreen().dispose();
				}

			batch.dispose();
		}
	@Override
	public void render ()
		{
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



		if (ScreenManager.getCurrentScreen()!=null)
			{
				ScreenManager.getCurrentScreen().update();
			}
		if (ScreenManager.getCurrentScreen() !=null)
			{

				ScreenManager.getCurrentScreen().render(batch);
			}

		}
	@Override

	public void resize(int width, int height)
		{
			if (ScreenManager.getCurrentScreen() !=null)
				{
					ScreenManager.getCurrentScreen().resize(width,height);
				}
		}
	@Override
	public void pause()
		{
			if (ScreenManager.getCurrentScreen() !=null)
				{
					ScreenManager.getCurrentScreen().pause();
				}

		}
	@Override
	public void resume()
		{
			if (ScreenManager.getCurrentScreen() !=null)
				{
					ScreenManager.getCurrentScreen().resume();
				}
		}


}




