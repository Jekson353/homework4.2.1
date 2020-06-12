package com.samoylenko.homework222;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {


    private List<Product> products;
    private LayoutInflater inflater;

    private CompoundButton.OnCheckedChangeListener myCheck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            products.get((Integer) buttonView.getTag()).setChecked(isChecked);
        }
    };

    ProductAdapter(Context context, List<Product> products) {
        if (products == null) {
            this.products = new ArrayList<>();
        } else {
            this.products = products;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    void addItem(Product products) {
        this.products.add(products);
        notifyDataSetChanged();
    }

    void removeItem(int position) {
        products.remove(position);
        notifyDataSetChanged();
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return products.size();
        //return 0;
    }

    // элемент по позиции
    @Override
    public Product getItem(int position) {
        if (position < products.size()) {
            return products.get(position);
        }else{
            return null;
        }
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = inflater.inflate(R.layout.content_main, parent, false);
        }

        Product prod = products.get(position);

        ImageView image = view.findViewById(R.id.icon_prod);
        TextView tittle = view.findViewById(R.id.title_prod);
        TextView subtitle = view.findViewById(R.id.subtittle_prod);
        CheckBox checkBox = view.findViewById(R.id.checkBox_prod);

        tittle.setText(prod.getTittle());
        subtitle.setText(prod.getSubtitle());
        image.setImageDrawable(prod.getImage());
        checkBox.setOnCheckedChangeListener(myCheck);
        checkBox.setTag(position);
        checkBox.setChecked(prod.isChecked());
        return view;
    }
}
