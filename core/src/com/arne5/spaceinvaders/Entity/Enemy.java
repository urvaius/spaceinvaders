package com.arne5.spaceinvaders.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by urvaius on 9/21/14.
 */
public class Enemy extends Entity
	{

		public Enemy(Texture texture, Vector2 pos, Vector2 direction)
			{
				super(texture, pos, direction);
			}

		@Override
		public void update()
			{
				pos.add(direction);
			}
	}
