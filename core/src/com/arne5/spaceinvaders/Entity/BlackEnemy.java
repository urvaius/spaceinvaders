package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by darneson on 5/5/2015.
 */
public class BlackEnemy extends Entity
	{

		public BlackEnemy(Vector2 pos, Vector2 direction, Float width, Float height)
			{
				super(Assets.blackEnemy,pos, direction, width, height);
			}

		@Override
		public void update()
			{
				pos.add(direction);
				if(pos.y <= - Assets.blackEnemy.getHeight())
					{
						float x = MathUtils.random(0, SpaceInvaders.WIDTH - Assets.blackEnemy.getWidth());
						pos.set(x,SpaceInvaders.HEIGHT);

					}
			}
	}
