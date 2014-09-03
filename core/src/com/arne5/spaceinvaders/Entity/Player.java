package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
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
		public Player(Vector2 pos, Vector2 direction)
			{
				super(Assets.PLAYER, pos, direction);
			}

		@Override
		public void Update()
			{

				pos.add(direction);

				// movement
				if(Gdx.input.isKeyPressed(Keys.A))
					{
						setDirection(-300,0);


					}
				else if(Gdx.input.isKeyPressed(Keys.D))
					{
						setDirection(300,0);
					}
				else
					{
						setDirection(0,0);
					}
			}
	}
