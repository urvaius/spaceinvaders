package com.arne5.spaceinvaders.screen;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.Entity.EntityManager;
import com.arne5.spaceinvaders.Entity.Player;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class GameScreen extends Screen
	{
		private OrthoCamera camera;

		private EntityManager entityManager;
		@Override
		public void create()

			{   Assets.Load();
				camera = new OrthoCamera();

				entityManager = new EntityManager();

			}

		@Override
		public void update()
			{
				camera.update();
				entityManager.update();

			}

		@Override
		public void render(SpriteBatch sb)
			{
				//start spritebatching
				sb.setProjectionMatrix(camera.combined);
				sb.begin();


				entityManager.render(sb);


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
