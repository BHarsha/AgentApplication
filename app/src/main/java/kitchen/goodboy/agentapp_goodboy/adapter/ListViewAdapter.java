package kitchen.goodboy.agentapp_goodboy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kitchen.goodboy.agentapp_goodboy.Items.Hero;
import kitchen.goodboy.agentapp_goodboy.R;

public class ListViewAdapter extends ArrayAdapter<Hero> {

    private List<Hero> heroList;

    private Context mCtx;

    public ListViewAdapter(List<Hero> heroList, Context mCtx) {
        super(mCtx, R.layout.sample_data_listitem, heroList);
        this.heroList = heroList;
        this.mCtx = mCtx;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View listViewItem = inflater.inflate(R.layout.sample_data_listitem, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.sample_data_name);
        TextView textViewNumber = listViewItem.findViewById(R.id.sample_data_mobile);
        TextView textViewAddress = listViewItem.findViewById(R.id.sample_data_address);
        TextView textViewStatus = listViewItem.findViewById(R.id.sample_data_status);

        Hero hero = heroList.get(position);

        textViewName.setText(hero.getName());
        textViewNumber.setText(hero.getNumber());
        textViewAddress.setText(hero.getAddress());
        textViewStatus.setText(hero.getStatus());

        return listViewItem;
    }
}
