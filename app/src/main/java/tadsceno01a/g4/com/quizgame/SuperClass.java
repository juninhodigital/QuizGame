package tadsceno01a.g4.com.quizgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;

public class SuperClass extends ActionBarActivity
{
    //region | Methods

    public void openSearch()
    {

    }

    public void openSettings()
    {

    }

    public void Alert(String Titulo, String Mensagem, AlertType TipoAlerta)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(Titulo);
        alertDialog.setMessage(Mensagem);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });

        if(TipoAlerta == AlertType.Info)
        {
            alertDialog.setIcon(R.drawable.androidhappy);
        }

        if(TipoAlerta == AlertType.Error)
        {
            alertDialog.setIcon(R.drawable.ic_action_error);
        }

        if(TipoAlerta == AlertType.Warning)
        {
            alertDialog.setIcon(R.drawable.ic_action_warning);
        }

        alertDialog.show();
    }

    public void Quit()
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

    public boolean IsEmpty(EditText input)
    {
        String ed_text = input.getText().toString().trim();

        if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //endregion

    public enum AlertType
    {
        Info, Warning, Error
    }
}
