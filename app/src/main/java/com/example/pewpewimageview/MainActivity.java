package com.example.pewpewimageview;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] Guns = {R.drawable.sr1911, R.drawable.b92, R.drawable.g27, R.drawable.m249, R.drawable.at4, R.drawable.xd9};
    Integer[] Exp = {R.drawable.sr1911exp, R.drawable.b92exp, R.drawable.g27exp, R.drawable.m249exp, R.drawable.at4exp, R.drawable.xd9exp};
    String[] Desc = {"Ruger 1911", "Beretta 92", "Glock 27", "AT 4 Rocket Launcher", "Springfield XD-9" };

    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);

        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
        // The Image View Control is instantiated

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Selected Firearm: " + (Desc[position]), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Exp[position]);
            }
        });

    }
    public class ImageAdapter extends BaseAdapter {
        private Context context;
        // The contenxt variable named context is initalized

        public ImageAdapter(Context c) { context=c; }

//            public ImageAdapter(MainActivity mainActivity) {
//            }

        @Override
        public int getCount() {

            return Guns.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Guns[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }
}
