SelectorButton
==============

Custom button that can implement click effect don't need create a selector.xml

=====================================
How To Use
--------------------------------------------------
************************************
0. init /res/values/attrs.xml
<resources>
     <declare-styleable name="SelectorButton">
        <attr name="normal_drawable" format="reference" />
        <attr name="pressed_drawable" format="reference" />
　　</declare-styleable>
</resources>
************************************
1.Create a class SeletorButton to extends  Button

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
		array.recycle();
	}
}
************************************
2. use  in xml
<!-- First you should define a namespace --!>
 xmlns:zyh="http://schemas.android.com/apk/res/com.example.mybutton"
<!--use SelectorButton--!>
 <com.example.mybutton.SelectorButton
        android:id="@+id/btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="button"
        zyh:normal_drawable="@drawable/exam_list_bg_default"
        zyh:pressed_drawable="@drawable/exam_list_bg_pressed" />

example: main.xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:zyh="http://schemas.android.com/apk/res/com.example.mybutton"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.example.mybutton.MainActivity" >

    <com.example.mybutton.SelectorButton
        android:id="@+id/btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="button"
        zyh:normal_drawable="@drawable/exam_list_bg_default"
        zyh:pressed_drawable="@drawable/exam_list_bg_pressed" />
</RelativeLayout>

************************************
3. use in code.java

SelectorButton mButton = findViewById(R.id.button);
Drawable normalDrawable = getResources().getDrawable(R.drawable.btn_normal);
Drawable pressedDrawable = getResources().getDrawable(R.drawable.btn_pressed);
mButton.setSelecorDrawable(normalDrawable, pressedDrawable);
