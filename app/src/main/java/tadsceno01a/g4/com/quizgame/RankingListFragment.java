package tadsceno01a.g4.com.quizgame;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RankingListFragment extends ListFragment implements AdapterView.OnItemClickListener
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.ranking_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.nav_students_grade, android.R.layout.simple_list_item_1);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(getActivity(), "item " + position, Toast.LENGTH_SHORT ).show();
    }
}
