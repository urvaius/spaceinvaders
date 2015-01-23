package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import java.rmi.server.ServerNotActiveException;

/**
 * Created by urvaius on 11/12/14.
 */
public class Player extends Entity
	{
		private final EntityManager entityManager;
		private final OrthoCamera camera;
		private long lastFire;

		public Player(Vector2 pos, Vector2 direction,EntityManager entityManager,OrthoCamera camera)
			{
				super(Assets.PLAYER, pos, direction);
				this.entityManager= entityManager;
				this.camera = camera;

			}

		@Override
		public void update()
			{

				pos.add(direction);


				// shoot button?
				// movement

				int dir = 0;
				if(Gdx.input.isTouched())
					{
						Vector2 touch= camera.unprojectCoordinates(Gdx.input.getX(),Gdx.input.getY());
						if(touch.x > SpaceInvaders.WIDTH/2 )
							{
								dir=2;

							}
						else if(touch.x < 0 + Assets.shootButton.getWidth() && touch.y < 0 + Assets.shootButton.getHeight())
							{
								dir =0;
							}
						else
							{
								dir=1;
							}
					}


				if(Gdx.input.isKeyPressed(Input.Keys.A)|| dir==1)
					{
						setDirection(-300,0);


					}
				else if(Gdx.input.isKeyPressed(Input.Keys.D)|| dir==2)
					{
						setDirection(300,0);
					}
				else
					{
						setDirection(0,0);
					}

				//add to not go past screen

				if (pos.x >= SpaceInvaders.WIDTH - Assets.PLAYER.getWidth() )
					{
						pos.x = SpaceInvaders.WIDTH  - Assets.PLAYER.getWidth();
					}

				if (pos.x <= 0 )
					{
						pos.x = 0 ;
					}



				if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
					{
						if(System.currentTimeMillis()-lastFire>=250)
							{
								entityManager.AddEntity(new Missile(pos.cpy().add(Assets.PLAYER.getWidth() / 2, Assets.PLAYER.getHeight())));

									lastFire=System.currentTimeMillis();
							}


					}

				// add if shootbutton pressed as well
				if(Gdx.input.isTouched())
					{
						Vector2 touchButton= camera.unprojectCoordinates(Gdx.input.getX(),Gdx.input.getY());
						Vector2 touchFire = new Vector2(Assets.shootButton.getX(),Assets.shootButton.getY());
						if(touchButton.x < touchFire.x +Assets.shootButton.getWidth() && touchButton.y < touchFire.y + Assets.shootButton.getHeight())
							{

								if(System.currentTimeMillis()-lastFire>=250)
									{
										entityManager.AddEntity(new Missile(pos.cpy().add(Assets.PLAYER.getWidth() / 2, Assets.PLAYER.getHeight())));

										lastFire=System.currentTimeMillis();
									}

							}

					}



			}


	}

