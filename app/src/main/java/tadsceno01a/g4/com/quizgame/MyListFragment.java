package tadsceno01a.g4.com.quizgame;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MyListFragment extends ListFragment implements OnItemClickListener
{
    String[] usuarios;
    String[] notas;

    CustomAdapter adapter;
    private List<RankingModel> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.example_grid_item, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {

        super.onActivityCreated(savedInstanceState);

        usuarios = getResources().getStringArray(R.array.students_list);
        notas = getResources().getStringArray(R.array.students_grade);

        rowItems = new ArrayList<RankingModel>();

        for (int i = 0; i < usuarios.length; i++)
        {
           RankingModel items = new RankingModel(usuarios[i], notas[i]);

           rowItems.add(items);
        }

        adapter = new CustomAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(getActivity(), notas[position], Toast.LENGTH_SHORT).show();
    }
}

