package com.arne5.spaceinvaders.screen;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by darneson on 1/23/2015.
 */
public class GameStartScreen extends Screen
	{


		private OrthoCamera camera;






		@Override
		public void create()
			{
				Assets.Load();

				camera = new OrthoCamera();
				camera.resize();

			}

		@Override
		public void update()
			{
				camera.update();

				if(Gdx.input.isTouched())
					{
						Vector2 touch= camera.unprojectCoordinates(Gdx.input.getX(),Gdx.input.getY());
						if(touch.x >0 )
							{
								ScreenManager.setScreen(new GameScreen());
							}

					}

				if(Gdx.input.isKeyPressed(Input.Keys.ENTER))
					{


						ScreenManager.setScreen(new GameScreen());
						//create();
						//ScreenManager.setScreen(new GameStartScreen());



					}




			}

		@Override
		public void render(SpriteBatch sb)
			{
				//todo this may be wrond for the draw

				sb.setProjectionMatrix(camera.combined);
				sb.begin();

				sb.draw(Assets.startScreen, 0, 0);

				sb.end();
			}

		@Override
		public void resize(int width, int height)
			{
				camera.resize();
			}

		@Override
		public void dispose()
			{

			}

		@Override
		public void pause()
			{

			}

		@Override
		public void resume()
			{

			}
	}
