package com.example.gridview;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

 class ButtonAdpter extends BaseAdapter {
    private Context mContext;

    private static final String[] buttonNames = {
            "button-1", "button-2",
            "button-3", "button-4",
            "button-5", "button-6",
            "button-7", "button-8",
            "button-9", "button-10",
            "button-11", "button-12",
            "button-13", "button-14",
            "button-15"
    };

    public ButtonAdpter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return buttonNames.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button = new Button(mContext);
        button.setLayoutParams(new GridView.LayoutParams(300, 200));
        button.setPadding(8, 8, 8, 8);
        button.setText(buttonNames[position]);
        button.setBackgroundColor(Color.GREEN);
        button.setTextColor(Color.BLACK);
        button.setTextSize(18);

        // Set OnClickListener for each button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Button Clicked: " + buttonNames[position], Toast.LENGTH_SHORT).show();
            }
        });

        return button;
    }
}
