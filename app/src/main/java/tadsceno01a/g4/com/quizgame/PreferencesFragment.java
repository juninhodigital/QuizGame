package tadsceno01a.g4.com.quizgame;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class PreferencesFragment extends Fragment
{
    public PreferencesFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_preferences, container, false);

        Button btnAdd = (Button)v.findViewById(R.id.btnAddQuestion);
        final Switch btnSwitch = (Switch)v.findViewById(R.id.btnSwitch);

        if(btnAdd!=null)
        {
            btnAdd.setOnClickListener
            (
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Toast.makeText(getActivity(), "Cadastrado com sucesso.", Toast.LENGTH_SHORT).show();
                    }
                }
            );
        }

        if(btnSwitch!=null)
        {
            btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                   if(isChecked)
                   {
                       btnSwitch.setText("Ativa ");
                   }
                   else
                   {
                       btnSwitch.setText("Inativa ");
                   }
                }
            });
        }

        return v;

    }
}
