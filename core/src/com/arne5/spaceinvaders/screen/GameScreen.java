package com.arne5.spaceinvaders.screen;

import com.arne5.spaceinvaders.Assets;

import com.arne5.spaceinvaders.Entity.EntityManager;
import com.arne5.spaceinvaders.Entity.Player;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by urvaius on 11/12/14.
 */
public class GameScreen extends Screen

	{
		private OrthoCamera camera;

		private EntityManager entityManager;
		private BitmapFont scoreFont;






		@Override
		public void create()

			{
				//maybe do not need here.
				//Assets.Load();
				camera = new OrthoCamera();
				camera.resize();
				//entityManager = new EntityManager(10,camera);
				entityManager = new EntityManager(10,camera);
				Assets.gameMusic.isLooping();
				Assets.gameMusic.play();
				scoreFont = new BitmapFont();
				scoreFont.setColor(Color.WHITE);






			}

		@Override
		public void update()
			{
				camera.update();
				entityManager.update();




				/*if(Gdx.input.isKeyPressed(Input.Keys.P))
					{

						//set pause screen.
						pause();

					}
				if(Gdx.input.isKeyPressed(Input.Keys.O))
					{
						resume();
					}*/

			}

		@Override
		public void render(SpriteBatch sb)
			{
				//start spritebatching
				sb.setProjectionMatrix(camera.combined);
				sb.begin();


				sb.draw(Assets.gameBack,0,0);
				sb.draw(Assets.shootButton,0,0);
				scoreFont.draw(sb,"Score" , SpaceInvaders.WIDTH /2 -20 ,SpaceInvaders.HEIGHT -20);

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
				Assets.gameMusic.dispose();
				scoreFont.dispose();

			}

		@Override
		public void pause()
			{
				Assets.gameMusic.pause();
			}

		@Override
		public void resume()
			{
				Assets.gameMusic.play();
			}
	}
