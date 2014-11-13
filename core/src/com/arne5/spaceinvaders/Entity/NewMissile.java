package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by urvaius on 11/12/14.
 */
public class NewMissile extends NewEntity
	{
		public NewMissile( Vector2 pos)
			{
				super(Assets.NEWMISSILE, pos, new Vector2(0,5));
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
