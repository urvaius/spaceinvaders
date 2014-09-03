package com.arne5.spaceinvaders.screen;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.Entity.Player;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class MenuScreen extends Screen
	{
		private OrthoCamera camera;
		private Player player;
		@Override
		public void create()

			{   Assets.Load();
				camera = new OrthoCamera();
				player = new Player(new Vector2(230,15),new Vector2(0,0));

			}

		@Override
		public void Update()
			{
				camera.update();
				player.Update();
			}

		@Override
		public void render(SpriteBatch sb)
			{
				//start spritebatching
				sb.setProjectionMatrix(camera.combined);
				sb.begin();

				player.Render(sb);



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
