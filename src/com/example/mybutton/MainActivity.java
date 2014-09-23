package com.example.mybutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton = (Button) findViewById(R.id.btn);
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
