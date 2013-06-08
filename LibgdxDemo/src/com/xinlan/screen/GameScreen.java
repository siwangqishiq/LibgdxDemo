
package com.xinlan.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.xinlan.role.Map;
import com.xinlan.role.MapRenderer;
import com.xinlan.role.OnscreenControlRenderer;

public class GameScreen extends CubocScreen {
	Map map;
	MapRenderer renderer;
	OnscreenControlRenderer controlRenderer;

	public GameScreen (Game game) {
		super(game);
	}

	@Override
	public void show () {
		map = new Map();//地图
		renderer = new MapRenderer(map);//地图渲染器
		controlRenderer = new OnscreenControlRenderer(map);//控制器
	}

	@Override
	public void render (float delta) {
		delta = Math.min(0.06f, Gdx.graphics.getDeltaTime());
		map.update(delta);
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		renderer.render(delta);
		controlRenderer.render();

		if (map.bob.bounds.overlaps(map.endDoor.bounds)) {//结束画面
			game.setScreen(new GameOverScreen(game));
		}

		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {//按下返回键
			game.setScreen(new MainMenu(game));
		}
	}

	@Override
	public void hide () {
		System.out.println("dispose game screen");
		renderer.dispose();
		controlRenderer.dispose();
	}
}
