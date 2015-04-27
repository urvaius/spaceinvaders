package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by darneson on 4/27/2015.
 */
public class GreenEnemy extends Entity
	{
		public GreenEnemy(Sprite sprite, Vector2 pos, Vector2 direction, float width, float height)
			{
				super(sprite, pos, direction, width, height);

				
			}

		@Override
		public void update()
			{
				pos.add(direction);
				if(pos.y <= - Assets.greenEnemy.getHeight())
					{
						float x = MathUtils.random(0, SpaceInvaders.WIDTH - Assets.greenEnemy.getWidth());
						pos.set(x,SpaceInvaders.HEIGHT);

					}
			}
	}
