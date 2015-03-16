package tadsceno01a.g4.com.quizgame;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends SuperClass
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(R.string.app_name);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final EditText txtNome = (EditText)findViewById(R.id.txtNome);
        final EditText txtPassword = (EditText)findViewById(R.id.txtPassword);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnCancel = (Button) findViewById(R.id.btnCancelar);
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
                            Usuario.Nome = txtNome.getText().toString();
                            Usuario.Tipo = "Professor";

                            Intent oForm = new Intent(MainActivity.this, TeacherActivity.class);
                            startActivity(oForm);
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
