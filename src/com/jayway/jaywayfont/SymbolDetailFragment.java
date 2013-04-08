package com.jayway.jaywayfont;

import com.jayway.jaywayfont.symbol.FontHandler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/**
 * A fragment representing a single Symbol detail screen. This fragment is
 * either contained in a {@link SymbolListActivity} in two-pane mode (on
 * tablets) or a {@link SymbolDetailActivity} on handsets.
 */
public class SymbolDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	private String data;

	private TextView textView;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public SymbolDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			data = getArguments().getString(ARG_ITEM_ID);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_symbol_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (data != null) {
			textView = (TextView) rootView.findViewById(R.id.text);
			textView.setText(data);
			textView.setTypeface(FontHandler.getJaywayFont(getActivity()));
			SeekBar seekBar = (SeekBar) rootView.findViewById(R.id.slider);
			seekBar.setOnSeekBarChangeListener(new MySeekBarChangeListener());
			
			textView.setTextSize(seekBar.getProgress());
		}

		return rootView;
	}

	public class MySeekBarChangeListener implements OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			textView.setTextSize(progress);

		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

	}
}
