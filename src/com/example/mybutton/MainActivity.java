package com.example.mybutton;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	private SelectorButton mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton = (SelectorButton) findViewById(R.id.btn);

		Drawable normalDrawable = getResources().getDrawable(R.drawable.exam_list_bg_default);
		Drawable pressedDrawable = getResources().getDrawable(R.drawable.exam_list_bg_pressed);
		mButton.setSelecorDrawable(normalDrawable, pressedDrawable);

		// // mButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.d));;
		// StateListDrawable seletor = new StateListDrawable();
		// seletor.addState(new int[] { android.R.attr.state_pressed },
		// getResources().getDrawable(R.drawable.btn_login_normal));
		// seletor.addState(new int[] { android.R.attr.state_focused },
		// getResources().getDrawable(R.drawable.btn_login_normal));
		// seletor.addState(new int[] {}, getResources().getDrawable(R.drawable.btn_login_pressed));
		// mButton.setBackgroundDrawable(seletor);
		mButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				System.out.println("µã»÷");
			}
		});
	}

}
