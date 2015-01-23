package com.arne5.spaceinvaders.screen;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by urvaius on 9/21/14.
 */
public class GameOverScreen extends Screen
	{
		private OrthoCamera camera;
		private Sprite sprite;

		public GameOverScreen(boolean won)
			{
				if(won)
					{
						sprite = Assets.gameWon;
					}
				else
					{
						sprite = Assets.gameOver;
					}
			}


		@Override
		public void create()
			{
				camera= new OrthoCamera();
				camera.resize();

			}

		@Override
		public void update()
			{
				camera.update();
			}

		@Override
		public void render(SpriteBatch sb)
			{
				sb.setProjectionMatrix(camera.combined);
				sb.begin();

				sb.draw(sprite, SpaceInvaders.WIDTH/2-sprite.getWidth()/2,SpaceInvaders.HEIGHT/2 -sprite.getHeight()/2);
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
