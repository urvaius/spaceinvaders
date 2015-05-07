package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.arne5.spaceinvaders.screen.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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
		public int level;
		private boolean runLevel2 = true;
		private boolean runLevel3 = true;
		public Preferences prefs = Gdx.app.getPreferences("GamePref");






		public EntityManager(int amount, OrthoCamera camera)
			{   player = new Player(new Vector2(230,15),new Vector2(0,0),Assets.PLAYER.getWidth(),Assets.PLAYER.getHeight(),this,camera);
				player.setScore(0);
				player.setLives(3);
				player.setLevel(1);
				level = player.getLevel();





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
				playerLives = player.getLives();
				level = player.getLevel();
				checkLevel();


			}
		public void render(SpriteBatch sb)
			{
				for (Entity e : entities)
					{
						e.render(sb);

					}
				player.render(sb);



			}



		private void checkLevel()
		{



			if (player.getScore() >=15 && player.getScore() <=29)
				{
					player.setLevel(2);
					level2();


				}
			else if(player.getScore() >=30 )
				{
					player.setLevel(3);
					level3();
				}

			else
			{
				player.setLevel(1);

			}


		}


		private void level2()
			{


				if(runLevel2)
					{
						for(int i=0;i <10;i++)
							{
								float x = MathUtils.random(0,SpaceInvaders.WIDTH-Assets.greenEnemy.getWidth());
								float y = MathUtils.random(SpaceInvaders.HEIGHT,SpaceInvaders.HEIGHT*3);
								float speed = MathUtils.random(2,5);
								AddEntity(new GreenEnemy(new Vector2(x,y),new Vector2(0,-speed),Assets.greenEnemy.getWidth(),Assets.greenEnemy.getHeight()));

							}
						runLevel2 =false;

					}

			}

		private void level3()
			{


				if(runLevel3)
					{
						for(int i=0;i <10;i++)
							{
								float x = MathUtils.random(0,SpaceInvaders.WIDTH-Assets.blackEnemy.getWidth());
								float y = MathUtils.random(SpaceInvaders.HEIGHT,SpaceInvaders.HEIGHT*3);
								float speed = MathUtils.random(2,5);
								AddEntity(new BlackEnemy(new Vector2(x,y),new Vector2(0,-speed),Assets.blackEnemy.getWidth(),Assets.blackEnemy.getHeight()));

							}
						runLevel3 =false;

					}

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
						//TODO: need to fix this overlapping and scoring to be one method
						if (e.getBounds().overlaps((player.getBounds())))
							{

								entities.removeValue(e, false);

								if (playerLives == 0)
									{

										ScreenManager.setScreen(new GameOverScreen(false));
									}
								else
									{
										player.setLives(player.getLives() -1);
									}

							}
					}

				for(BlackEnemy e:getBlackEnemies())
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
						//TODO: need to fix this overlapping and scoring to be one method
						if (e.getBounds().overlaps((player.getBounds())))
							{

								entities.removeValue(e, false);

								if (playerLives == 0)
									{
										prefs.putInteger("HighScore", player.getScore());
										ScreenManager.setScreen(new GameOverScreen(false));
									}
								else
									{
										player.setLives(player.getLives() -1);
									}

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
								entities.removeValue(e,false);

								if (playerLives == 1)
									{

										//try to add hightscore
										prefs.putInteger("HighScore", player.getScore());

										ScreenManager.setScreen(new GameOverScreen(false));
									}
								else
									{
										player.setLives(player.getLives() -1);
									}



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

		private Array<BlackEnemy> getBlackEnemies()
			{
				Array<BlackEnemy> ret = new Array<BlackEnemy>();
				for(Entity e : entities)
					{
						if(e instanceof BlackEnemy)
							{
								ret.add((BlackEnemy)e);
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


				return getEnemies().size <=0;






			}

	}
