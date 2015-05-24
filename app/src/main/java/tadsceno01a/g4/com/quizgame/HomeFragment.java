package tadsceno01a.g4.com.quizgame;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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

        Button btnNext = (Button)oView.findViewById(R.id.btnNext);

        final RadioButton rdb1 = (RadioButton)oView.findViewById(R.id.rdb1);
        final RadioButton rdb2 = (RadioButton)oView.findViewById(R.id.rdb2);
        final RadioButton rdb3 = (RadioButton)oView.findViewById(R.id.rdb3);

        lblNome.setText("Nome: " + MainActivity.Usuario.Nome + " - tipo:" + MainActivity.Usuario.Tipo);

        if(btnNext!=null)
        {
            btnNext.setOnClickListener
            (
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Toast.makeText(getActivity(), "Resposta correta.", Toast.LENGTH_SHORT).show();
                    }
                }
            );
        }

        rdb1.setOnClickListener
        (
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        rdb2.setChecked(false);
                        rdb3.setChecked(false);
                    }
                }
        );

        rdb2.setOnClickListener
        (
            new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    rdb1.setChecked(false);
                    rdb3.setChecked(false);
                }
            }
        );

        rdb3.setOnClickListener
        (
            new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    rdb1.setChecked(false);
                    rdb2.setChecked(false);
                }
            }
        );

        return oView;

    }
}