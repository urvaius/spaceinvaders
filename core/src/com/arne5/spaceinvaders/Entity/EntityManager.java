package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.arne5.spaceinvaders.screen.*;
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
		public int playerLives;




		public EntityManager(int amount, OrthoCamera camera)
			{   player = new Player(new Vector2(230,15),new Vector2(0,0),Assets.PLAYER.getWidth(),Assets.PLAYER.getHeight(),this,camera);
				player.setScore(0);
				player.setLives(3);



				for(int i=0;i <amount;i++)
				{
					float x = MathUtils.random(0, SpaceInvaders.WIDTH- Assets.ENEMY.getWidth());
					float y = MathUtils.random(SpaceInvaders.HEIGHT, SpaceInvaders.HEIGHT *3);
					float speed = MathUtils.random(2,5);
					//added height and widht as 1f and 1f need to try
					AddEntity(new Enemy(new Vector2(x,y),new Vector2(0,-speed),Assets.ENEMY.getWidth(),Assets.ENEMY.getHeight()));

				}

				for(int i=0;i <amount;i++)
					{
						float x = MathUtils.random(0,SpaceInvaders.WIDTH-Assets.greenEnemy.getWidth());
						float y = MathUtils.random(SpaceInvaders.HEIGHT,SpaceInvaders.HEIGHT*3);
						float speed = MathUtils.random(2,5);
						AddEntity(new GreenEnemy(new Vector2(x,y),new Vector2(0,-speed),Assets.greenEnemy.getWidth(),Assets.greenEnemy.getHeight()));

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
				playerLives = player.getLives();


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

				//green enemy collision
				//TODO:  need to fix this so I don't have to keep adding collision for different entities.

						//maybe make an offshoot of enemy class with a different picture only
				for(GreenEnemy e:getGreenEnemies())
					{
						for(Missile m:getMissiles())
							{
								if(e.getBounds().overlaps(m.getBounds()))
									{
										entities.removeValue(e,false);
										entities.removeValue(m,false);
										player.setScore(player.getScore()+10);
										if(gameOver())
											{

												//if won
												ScreenManager.setScreen(new GameOverScreen(true));
											}

									}

							}
						if (e.getBounds().overlaps((player.getBounds())))
							{
								ScreenManager.setScreen((new GameOverScreen(false)));
							}
					}


				for(Enemy e:getEnemies())
					{
						for(Missile m:getMissiles())
							{
								if(e.getBounds().overlaps(m.getBounds()))
									{
										entities.removeValue(e,false);
										entities.removeValue(m,false);
										player.setScore(player.getScore() + 5);
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

		private Array<GreenEnemy> getGreenEnemies()
			{
				Array<GreenEnemy> ret = new Array<GreenEnemy>();
				for(Entity e : entities)
					{
						if(e instanceof GreenEnemy)
							{
								ret.add((GreenEnemy)e);
							}
					}
				return ret;
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


				return getGreenEnemies().size <=0;






			}

	}
