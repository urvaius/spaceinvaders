package com.arne5.spaceinvaders.screen;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.Entity.EntityManager;
import com.arne5.spaceinvaders.Entity.NewEntityManager;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by urvaius on 11/12/14.
 */
public class NewGameScreen extends Screen

	{
		private OrthoCamera camera;

		private NewEntityManager entityManager;
		@Override
		public void create()

			{
				Assets.Load();
				camera = new OrthoCamera();

				//entityManager = new EntityManager(10,camera);
				entityManager = new NewEntityManager(10,camera);

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
