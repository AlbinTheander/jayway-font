package com.jayway.jaywayfont.symbol;

import android.content.Context;
import android.graphics.Typeface;

public class FontHandler {
	
	private static Typeface jaywayFont;
	
	public static Typeface getJaywayFont(Context context) {
		if (jaywayFont == null) {
			jaywayFont = Typeface.createFromAsset(context.getAssets(), "jayway.ttf");
		}
		return jaywayFont;
	}

}
