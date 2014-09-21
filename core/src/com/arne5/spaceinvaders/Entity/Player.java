package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.Input.*;

/**
 * Created by urvaius on 9/2/14.
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

				// movement

				int dir = 0;
				if(Gdx.input.isTouched())
					{
						Vector2 touch= camera.unprojectCoordinates(Gdx.input.getX(),Gdx.input.getY());
						if(touch.x > SpaceInvaders.WIDTH/2)
							{
								dir=2;

							}
						else
							{
								dir=1;
							}
					}


				if(Gdx.input.isKeyPressed(Keys.A)|| dir==1)
					{
						setDirection(-300,0);


					}
				else if(Gdx.input.isKeyPressed(Keys.D)|| dir==2)
					{
						setDirection(300,0);
					}
				else
					{
						setDirection(0,0);
					}
				if (Gdx.input.isKeyPressed(Keys.SPACE))
					{
						if(System.currentTimeMillis()-lastFire>=250)
							{
								entityManager.AddEntity(new Missile(pos.cpy().add(Assets.PLAYER.getWidth()/2,Assets.PLAYER.getHeight())));
								lastFire=System.currentTimeMillis();
							}

					}
			}


	}
