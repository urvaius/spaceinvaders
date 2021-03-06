package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by urvaius on 11/12/14.
 */
public class Missile extends Entity
	{
		public Missile( Vector2 pos)
			{
				super(Assets.MISSILE, pos, new Vector2(0,5),Assets.MISSILE.getWidth(),Assets.MISSILE.getHeight());
			}

		@Override
		public void update()
			{
				pos.add(direction);


			}

		public boolean checkEnd()
			{
				return pos.y >= SpaceInvaders.HEIGHT;

			}
}
