package tadsceno01a.g4.com.quizgame;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter
{

    Context context;
    List<RankingModel> rowItem;

    CustomAdapter(Context context, List<RankingModel> rowItem)
    {
        this.context = context;
        this.rowItem = rowItem;

    }

    @Override
    public int getCount()
    {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position)
    {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position)
    {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if (convertView == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.example_list_item, null);
        }

        TextView txtNome = (TextView) convertView.findViewById(R.id.nome);
        TextView txtNota = (TextView) convertView.findViewById(R.id.nota);

        RankingModel row_pos = rowItem.get(position);
        // setting the image resource and title

        txtNome.setText(row_pos.getNome());
        txtNota.setText(row_pos.getNota());

        if (position % 2 == 0)
        {
            convertView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        else
        {
            convertView.setBackgroundColor(Color.parseColor("#FF8DB5E1"));
        }

        return convertView;

    }

}