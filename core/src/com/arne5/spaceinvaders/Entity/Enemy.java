package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by urvaius on 11/12/14.
 */
public class Enemy extends Entity
	{

		public Enemy( Vector2 pos, Vector2 direction,Float width,Float height)
			{

				super(Assets.ENEMY, pos, direction,width,height);
			}



		@Override
		public void update()
			{
				pos.add(direction);
				if(pos.y <= - Assets.ENEMY.getHeight())
					{
						float x = MathUtils.random(0, SpaceInvaders.WIDTH - Assets.ENEMY.getWidth());
						pos.set(x,SpaceInvaders.HEIGHT);

					}
			}
	}
