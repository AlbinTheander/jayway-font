package com.jayway.jaywayfont.symbol;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SymbolAdapter extends ArrayAdapter<String>{
	
	private final static String[] symbols = "n s \ue002 r \u221a p \ue006 \u220f o m c P \ue00c R i C k j".split(" ");
	
	public SymbolAdapter(Context context) {
		super(context, android.R.layout.simple_list_item_1, android.R.id.text1, symbols);
	}
	
	@Override
	public long getItemId(int position) {
		return symbols[position].charAt(0);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
		TextView tv = (TextView) view.findViewById(android.R.id.text1);
		tv.setTypeface(FontHandler.getJaywayFont(getContext()));
		return view;
	}

}
