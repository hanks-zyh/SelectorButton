package com.example.mybutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.Button;

public class SelectorButton extends Button {

	public SelectorButton(Context context) {
		super(context);
	}

	public SelectorButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * zyh:normal_drawable="@drawable/btn_login_normal" zyh:pressed_drawable="@drawable/btn_login_pressed"
	 * @param context
	 * @param attrs
	 */
	public SelectorButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		StateListDrawable seletor = new StateListDrawable();// 背景选择器
		Drawable n = null;
		Drawable p = null;

		TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SelectorButton);
		int count = array.getIndexCount();// 获取属性个数
		System.out.println("count:" + count);
		for (int i = 0; i < count; i++) {
			int index = array.getIndex(i);
			System.out.println("index:" + index);
			System.out.println("draw:" + array.getDrawable(index));
			switch (index) {
				case R.styleable.SelectorButton_normal_drawable:
					n = array.getDrawable(index);
					break;
				case R.styleable.SelectorButton_pressed_drawable:
					p = array.getDrawable(index);
					break;
			}
		}
		seletor.addState(new int[] { android.R.attr.state_pressed }, p);
		seletor.addState(new int[] { android.R.attr.state_focused }, p);
		seletor.addState(new int[] {}, n);
		this.setBackgroundDrawable(seletor);
		// this.setBackgroundDrawable(p);
		array.recycle();
	}
}
