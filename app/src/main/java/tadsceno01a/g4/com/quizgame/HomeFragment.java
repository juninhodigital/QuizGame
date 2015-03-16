package tadsceno01a.g4.com.quizgame;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment
{
    public HomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View oView = inflater.inflate(R.layout.fragment_home, container, false);
        TextView lblNome = (TextView)oView.findViewById(R.id.lblNome);

        lblNome.setText(MainActivity.Usuario.Nome + " - " + MainActivity.Usuario.Tipo);

        return oView;

    }
}