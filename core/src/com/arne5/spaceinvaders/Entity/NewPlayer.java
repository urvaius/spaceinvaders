package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.arne5.spaceinvaders.camera.OrthoCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by urvaius on 11/12/14.
 */
public class NewPlayer extends NewEntity
	{
		private final NewEntityManager newentityManager;
		private final OrthoCamera camera;
		private long lastFire;

		public NewPlayer(Vector2 pos, Vector2 direction,NewEntityManager newentityManager,OrthoCamera camera)
			{
				super(Assets.NEWPLAYER, pos, direction);
				this.newentityManager= newentityManager;
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


				if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
					{
						if(System.currentTimeMillis()-lastFire>=250)
							{
								newentityManager.AddNewEntity(new NewMissile(pos.cpy().add(Assets.NEWPLAYER.getWidth() / 2, Assets.NEWPLAYER.getHeight())));
								
									lastFire=System.currentTimeMillis();
							}


					}
			}


	}

