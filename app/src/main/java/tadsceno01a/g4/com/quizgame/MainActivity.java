package tadsceno01a.g4.com.quizgame;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends SuperClass
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(R.string.app_name);

        //region AutoComplete

        ArrayList<String> searchArrayList = new ArrayList<String>();

        searchArrayList.add("Aluno");
        searchArrayList.add("Professor");

        AutoCompleteAdapter adapter = new AutoCompleteAdapter(this, R.layout.autosuggestlist_item, R.id.textView1, searchArrayList);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.txtNome);
        autoCompleteTextView.setAdapter(adapter);

        //endregion

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final AutoCompleteTextView txtNome = (AutoCompleteTextView)findViewById(R.id.txtNome);
        final EditText txtPassword = (EditText)findViewById(R.id.txtPassword);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnCancel = (Button) findViewById(R.id.btnCancelar);
        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        final RadioButton rdbStudent = (RadioButton)findViewById(R.id.rdbStudent);
        final RadioButton rdbTeacher = (RadioButton)findViewById(R.id.rdbTeacher);

        btnLogin.setOnClickListener
        (
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if(IsEmpty(txtNome) || IsEmpty(txtPassword))
                        {
                            Alert("Atenção", "Por favor, preencha as informações para autenticação", AlertType.Warning);
                        }
                        else
                        {
                            if( (IsEqual(txtNome,"Teacher") && IsEqual(txtPassword,"Password") && rdbTeacher.isChecked()) || (IsEqual(txtNome,"Aluno") && IsEqual(txtPassword,"Senha") && rdbStudent.isChecked()))
                            {
                                Usuario.Nome = txtNome.getText().toString();

                                if (rdbStudent.isChecked())
                                {
                                    Usuario.Tipo = "Aluno";

                                    Intent oForm = new Intent(MainActivity.this, StudentActivity.class);
                                    startActivity(oForm);
                                } else
                                {
                                    Usuario.Tipo = "Professor";

                                    Intent oForm = new Intent(MainActivity.this, TeacherActivity.class);
                                    startActivity(oForm);
                                }
                            }
                            else
                            {
                                Alert("Atenção", "Credenciais de autenticação informadas incorretamente.", AlertType.Warning);
                            }
                        }
                    }
                }
        );

        btnCancel.setOnClickListener
        (
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Alert("Informação", "Operação cancelada", AlertType.Info);
                    }
                }
        );

        btnRegistrar.setOnClickListener
        (
            new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent oForm = new Intent(MainActivity.this, SubscribeActivity.class);
                    startActivity(oForm);
                }
            }
        );

        rdbStudent.setOnClickListener
        (
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        rdbTeacher.setChecked(false);
                    }
                }
        );

        rdbTeacher.setOnClickListener
        (
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        rdbStudent.setChecked(false);
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void Sair()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Confirmação");
        alertDialog.setMessage("Você deseja realmente sair do aplicativo");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Sim", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Não", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                Alert("Informação", "Operação cancelada", AlertType.Info);
            }
        });

        alertDialog.setIcon(R.drawable.androidhappy);
        alertDialog.show();
    }

    public static class Usuario
    {
        public static String Nome;
        public static String Tipo;
    }
}
