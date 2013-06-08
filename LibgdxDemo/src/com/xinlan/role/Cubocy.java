
package com.xinlan.role;

import com.badlogic.gdx.Game;
import com.xinlan.screen.GameScreen;

public class Cubocy extends Game {
	@Override
	public void create () {
		setScreen(new GameScreen(this));
	}
}
