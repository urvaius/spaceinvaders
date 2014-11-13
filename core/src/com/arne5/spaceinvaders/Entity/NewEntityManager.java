package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.arne5.spaceinvaders.screen.GameOverScreen;
import com.arne5.spaceinvaders.screen.ScreenManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by urvaius on 9/21/14.
 */
public class NewEntityManager

	{
		private final Array<NewEntity> newentities = new Array<NewEntity>();
		private final NewPlayer newplayer;



		public NewEntityManager(int amount, OrthoCamera camera)
			{   newplayer = new NewPlayer(new Vector2(230,15),new Vector2(0,0),this,camera);



				for(int i=0;i <amount;i++)
				{
					float x = MathUtils.random(0, SpaceInvaders.WIDTH- Assets.NEWENEMY.getWidth());
					float y = MathUtils.random(SpaceInvaders.HEIGHT, SpaceInvaders.HEIGHT *3);
					float speed = MathUtils.random(2,5);
					AddNewEntity(new NewEnemy(new Vector2(x,y),new Vector2(0,-speed)));

				}

			}

		public void update()
			{
				for (NewEntity e : newentities)
					{
						e.update();
					}
				for(NewMissile m : getMissiles())
					{
						if(m.checkEnd())
							{
								newentities.removeValue(m,false);
							}
					}
				newplayer.update();
				checkCollisions();

			}
		public void render(SpriteBatch sb)
			{
				for (NewEntity e : newentities)
					{
						e.render(sb);

					}
				newplayer.render(sb);


			}

		private void checkCollisions()
			{
				for(NewEnemy e:getEnemies())
					{
						for(NewMissile m:getMissiles())
							{
								if(e.getBounds().overlaps(m.getBounds()))
									{
										newentities.removeValue(e,false);
										newentities.removeValue(m,false);
										if(gameOver())
											{
												//if won
												ScreenManager.setScreen(new GameOverScreen(true));
											}

									}
							}

						if (e.getBounds().overlaps(newplayer.getBounds()))
							{
								//make lose life instead
								ScreenManager.setScreen(new GameOverScreen(false));
							}
					}

			}


		public void AddNewEntity(NewEntity newentity)
			{
				newentities.add(newentity);
			}

		private Array<NewEnemy> getEnemies()
			{
				Array<NewEnemy> ret =new Array<NewEnemy>();
				for(NewEntity e : newentities)
					{
						if (e instanceof NewEnemy)
							{
								ret.add((NewEnemy)e);
							}
					}
				return ret;
			}


		private Array<NewMissile> getMissiles()
			{
				Array<NewMissile> ret =new Array<NewMissile>();
				for(NewEntity m : newentities)
					{
						if (m instanceof NewMissile)
							{
								ret.add((NewMissile)m);
							}
					}
				return ret;
			}
		public boolean gameOver()
			{
				return getEnemies().size <=0;

			}

	}
