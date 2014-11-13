package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by urvaius on 11/12/14.
 */
public class NewEnemy extends NewEntity
	{

		public NewEnemy( Vector2 pos, Vector2 direction)
			{
				super(Assets.NEWENEMY, pos, direction);
			}

		@Override
		public void update()
			{
				pos.add(direction);
				if(pos.y <= - Assets.NEWENEMY.getHeight())
					{
						float x = MathUtils.random(0, SpaceInvaders.WIDTH - Assets.NEWENEMY.getWidth());
						pos.set(x,SpaceInvaders.HEIGHT);

					}
			}
	}
