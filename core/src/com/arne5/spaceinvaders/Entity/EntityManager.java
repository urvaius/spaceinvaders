package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.arne5.spaceinvaders.screen.GameOverScreen;
import com.arne5.spaceinvaders.screen.GameScreen;
import com.arne5.spaceinvaders.screen.GameStartScreen;
import com.arne5.spaceinvaders.screen.ScreenManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by urvaius on 9/21/14.
 */
public class EntityManager

	{
		private final Array<Entity> entities = new Array<Entity>();
		private final Player player;
		public int playerScore;




		public EntityManager(int amount, OrthoCamera camera)
			{   player = new Player(new Vector2(230,15),new Vector2(0,0),Assets.PLAYER.getWidth(),Assets.PLAYER.getHeight(),this,camera);
				player.setScore(0);



				for(int i=0;i <amount;i++)
				{
					float x = MathUtils.random(0, SpaceInvaders.WIDTH- Assets.ENEMY.getWidth());
					float y = MathUtils.random(SpaceInvaders.HEIGHT, SpaceInvaders.HEIGHT *3);
					float speed = MathUtils.random(2,5);
					//added height and widht as 1f and 1f need to try
					AddEntity(new Enemy(new Vector2(x,y),new Vector2(0,-speed),Assets.ENEMY.getWidth(),Assets.ENEMY.getHeight()));

				}

			}

		public void update()
			{
				for (Entity e : entities)
					{
						e.update();
					}
				for(Missile m : getMissiles())
					{
						if(m.checkEnd())
							{
								entities.removeValue(m,false);
							}
					}
				player.update();
				checkCollisions();
				playerScore = player.getScore();

			}
		public void render(SpriteBatch sb)
			{
				for (Entity e : entities)
					{
						e.render(sb);

					}
				player.render(sb);



			}

		private void checkCollisions()
			{
				for(Enemy e:getEnemies())
					{
						for(Missile m:getMissiles())
							{
								if(e.getBounds().overlaps(m.getBounds()))
									{
										entities.removeValue(e,false);
										entities.removeValue(m,false);
										player.setScore(player.getScore()+5);
										if(gameOver())
											{
												//if won
												ScreenManager.setScreen(new GameOverScreen(true));
											}

									}
							}

						if (e.getBounds().overlaps(player.getBounds()))
							{
								//make lose life instead

								ScreenManager.setScreen(new GameOverScreen(false));

								//ScreenManager.setScreen(new GameStartScreen());

							}
					}

			}


		public void AddEntity(Entity entity)
			{
				entities.add(entity);
			}

		private Array<Enemy> getEnemies()
			{
				Array<Enemy> ret =new Array<Enemy>();
				for(Entity e : entities)
					{
						if (e instanceof Enemy)
							{
								ret.add((Enemy)e);
							}
					}
				return ret;
			}


		private Array<Missile> getMissiles()
			{
				Array<Missile> ret =new Array<Missile>();
				for(Entity m : entities)
					{
						if (m instanceof Missile)
							{
								ret.add((Missile)m);
							}
					}
				return ret;
			}
		public boolean gameOver()
			{
				return getEnemies().size <=0;

			}

	}
